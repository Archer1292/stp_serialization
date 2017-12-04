import serializable.City;
import serializable.Country;
import serializers.GSON;
import serializers.Jackson;
import serializers.OrgJSONforCity;

import java.util.HashMap;
import java.util.Random;

/**
 * @author Bratus Nadja on 12/4/2017
 * @project lab5
 */


public class Main {
    public static void main(String[] args){
        City country = getRandomCyity();
        Metrics.start();
        Jackson jackson = new Jackson<City>(City.class);
        try {
            jackson.serialize(country);
            jackson.deserialize();
            //System.out.format("%s, %d, %s, %d", person1_getFromJson.getName(), person1_getFromJson.getAge(), person1_getFromJson.getAddress().getStreet(),  person1_getFromJson.getAddress().getBuilding());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Metrics.stop();
        System.out.println("Jackson serializer");
        System.out.format("Memory used %f MB\n", Metrics.getMemory());
        System.out.format("Time used %f s\n\n", Metrics.getTime());
        Metrics.clear();

        Metrics.start();
        GSON gson = new GSON<City>(City.class);
        try {
            gson.serialize(country);
            gson.deserialize();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Metrics.stop();
        System.out.println("Google GSON serializer");
        System.out.format("Memory used %f MB\n", Metrics.getMemory());
        System.out.format("Time used %f s\n\n", Metrics.getTime());
        Metrics.clear();

        Metrics.start();
        OrgJSONforCity orgJSON = new OrgJSONforCity();
        try {
            orgJSON.serialize(country);
            orgJSON.deserialize();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Metrics.stop();
        System.out.println("orgJSON serializer");
        System.out.format("Memory used %f MB\n", Metrics.getMemory());
        System.out.format("Time used %f s\n\n", Metrics.getTime());
        Metrics.clear();
    }

    public static City getRandomCyity() {
        Random rand = new Random();

        HashMap<String, String> neighbors = new HashMap<>();
        neighbors.put(randonNum(),randonString(3,4));
        neighbors.put(randonNum(),randonString(3,4));
        neighbors.put(randonNum(),randonString(3,4));

        City city = new City();
        city.setName(randonString(5,3));
        city.setPopulation(rand.nextInt(100));

        Country address = new Country();
        address.setName(randonString(5,5));
        address.setArea(rand.nextDouble()*3-287-590.0);
        city.setCountry(address);

        city.setNeighbors(neighbors);
        return city;
    }

    public static String randonString(int consLength, int varLength) {
        Random rand = new Random();
        String string = "";
        int length = rand.nextInt(varLength) + consLength;
        for (int i=0; i<length; i++ ){
            if (i == 0) {
                string += (char)(rand.nextInt(26) + 'A');
            } else {
                string += (char)(rand.nextInt(26) + 'a');
            }
        }
        return string;
    }

    public static String randonNum() {
        Random rand = new Random();
        String string = "+3";
        for (int i=0; i<3; i++ ){
            string += rand.nextInt(9);
        }
        return string;
    }
}
