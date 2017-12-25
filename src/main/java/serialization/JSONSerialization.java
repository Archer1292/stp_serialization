package serialization;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class JSONSerialization implements Serializable {
    @Override
    public void bookSerialize(Book book) throws IOException {
        try (FileWriter writer = new FileWriter("bookJSON.json")) {
            org.json.JSONObject jsonObject = new org.json.JSONObject(book);
            writer.write(jsonObject.toString(4));
        }
    }

    @Override
    public Book bookDeserialize() throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        Object object = jsonParser.parse(new FileReader("bookJSON.json"));
        JSONObject jsonObject = (JSONObject) object;

        org.json.simple.JSONArray jsonArray = (org.json.simple.JSONArray) jsonObject.get("chapters");
        ArrayList<Chapter> chapters = new ArrayList<>();
        for (Object element : jsonArray) {
            JSONObject chapter = (JSONObject) element;
            chapters.add(new Chapter(Short.parseShort(chapter.get("page").toString()), (String) chapter.get("title"), (String) chapter.get("text")));
        }

        return new Book(Short.parseShort(jsonObject.get("pageCount").toString()),
                (String) jsonObject.get("name"), (String) jsonObject.get("author"), chapters);
    }
}
