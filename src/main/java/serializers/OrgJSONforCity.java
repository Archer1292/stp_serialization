package serializers;

import serializable.*;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Bratus Nadja on 1/4/2017
 * @project lab5
 */
public class OrgJSONforCity {
    private Class paramClass;

    public OrgJSONforCity() {
        this.paramClass = City.class;
    }

    private String testString = "";

    public OrgJSONforCity(boolean isTest) {
        this();
        if (isTest) {
            testString = "_test";
        }
    }

    public void serialize(City object) throws IOException {
        JSONObject jsonObject = new JSONObject(object);
        FileWriter writer = new FileWriter(paramClass.getName() + "_OrgJSON.json" + testString, false);
        writer.write(jsonObject.toString());
        writer.flush();
        writer.close();
    }

    public City deserialize()throws IOException {
        City object = new City();
        FileReader reader = new FileReader(paramClass.getName() + "_OrgJSON.json" + testString);
        Scanner scanner = new Scanner(reader);
        JSONObject jsonObject = new JSONObject(scanner.nextLine());

        object.setName(jsonObject.getString("name"));
        object.setPopulation(jsonObject.getInt("population"));

        Country country = new Country();
        JSONObject addressJson = jsonObject.getJSONObject("country");
        country.setArea(addressJson.getDouble("area"));
        country.setName(addressJson.getString("name"));
        object.setCountry(country);

        HashMap<String, String> map = new HashMap<String, String>();
        Iterator<String> keys = jsonObject.getJSONObject("neighbors").keys();
        while (keys.hasNext()) {
            String key = keys.next();
            String value = jsonObject.getJSONObject("neighbors").getString(key);
            map.put(key, value);
        }
        object.setNeighbors(map);

        scanner.close();
        reader.close();
        return object;
    }


}
