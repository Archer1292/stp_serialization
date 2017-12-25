package serialization;

import com.google.gson.*;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.util.*;
import java.lang.reflect.Type;

public class GSONSerialization implements Serializable {
    @Override
    public void bookSerialize(Book book) throws IOException {
        try (FileWriter writer = new FileWriter("bookGSON.json")) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(book, writer);
        }
    }

    @Override
    public Book bookDeserialize() throws IOException {
        try (FileReader reader = new FileReader("bookGSON.json")) {
            Gson gson = new GsonBuilder().enableComplexMapKeySerialization().registerTypeAdapter(new TypeToken<Map <String, Object>>(){}.getType(),  new MapDeserializerDoubleAsIntFix()).setPrettyPrinting().create();
            return gson.fromJson(reader, Book.class);
        }
    }
    static class MapDeserializerDoubleAsIntFix implements JsonDeserializer<Map<String, Object>> {
        @Override  @SuppressWarnings("unchecked")
        public Map<String, Object> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            return (Map<String, Object>) read(json);
        }

        Object read(JsonElement element) {
            if (element.isJsonObject()){
                Map<String, Object> map = new LinkedTreeMap<>();
                JsonObject obj = element.getAsJsonObject();
                Set<Map.Entry<String, JsonElement>> entitySet = obj.entrySet();
                for(Map.Entry<String, JsonElement> entry: entitySet)
                    map.put(entry.getKey(), read(entry.getValue()));
                return map;
            }
            else if (element.isJsonPrimitive()) {
                JsonPrimitive prim = element.getAsJsonPrimitive();
                if (prim.isString())
                    return prim.getAsString();
                else if (prim.isNumber()) {
                    Number num = prim.getAsNumber();
                    if(Math.ceil(num.doubleValue())  == num.shortValue())
                        return num.shortValue();
                }
            }
            return null;
        }
    }
}
