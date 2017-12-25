package serializers;

import data.Address;
import data.Person;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class OrgJSONforPerson {
    private Class paramClass;

    public OrgJSONforPerson() {
        this.paramClass = Person.class;
    }

    private String testString = "";

    public OrgJSONforPerson(boolean isTest) {
        this();
        if (isTest) {
            testString = "_test";
        }
    }

    public void serialize(Person object) throws IOException {
        JSONObject jsonObject = new JSONObject(object);
        FileWriter writer = new FileWriter(paramClass.getName() + "_OrgJSON.json" + testString, false);
        writer.write(jsonObject.toString());
        writer.flush();
        writer.close();
    }

    public Person deserialize()throws IOException {
        Person object = new Person();
        FileReader reader = new FileReader(paramClass.getName() + "_OrgJSON.json" + testString);
        Scanner scanner = new Scanner(reader);
        JSONObject jsonObject = new JSONObject(scanner.nextLine());

        object.setName(jsonObject.getString("name"));
        object.setAge(jsonObject.getInt("age"));

        Address address = new Address();
        JSONObject addressJson = jsonObject.getJSONObject("address");
        address.setBuilding(addressJson.getInt("building"));
        address.setStreet(addressJson.getString("street"));
        object.setAddress(address);

        HashMap<String, String> map = new HashMap<String, String>();
        Iterator<String> keys = jsonObject.getJSONObject("friends").keys();
        while (keys.hasNext()) {
            String key = keys.next();
            String value = jsonObject.getJSONObject("friends").getString(key);
            map.put(key, value);
        }
        object.setFriends(map);

        scanner.close();
        reader.close();
        return object;
    }


}
