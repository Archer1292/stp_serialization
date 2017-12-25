package serializers;

import com.google.gson.Gson;
import java.io.*;

public class GSON<T> extends Serializer<T>{
    private Gson gson;

    public GSON(Class<T> paramClass) {
        super(paramClass);
        gson = new Gson();
    }

    private String testString = "";

    public GSON(Class<T> paramClass, boolean isTest) {
        this(paramClass);
        if (isTest) {
            testString = "_test";
        }
    }

    @Override
    public void serialize(T object) throws IOException {
        FileWriter writer = new FileWriter(paramClass.getName() + "_GSON.json" + testString, false);
        writer.write(gson.toJson(object));
        writer.flush();
        writer.close();
        //gson.toJson(object, new FileWriter(paramClass.getName() + "_GSON.json", false));
    }

    @Override
    public T deserialize()throws IOException {
        T object = null;
        object = gson.fromJson(new FileReader(paramClass.getName() + "_GSON.json" + testString), paramClass);
        return object;
    }
}
