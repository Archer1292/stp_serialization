import data.Address;
import data.Person;
import serializers.GSON;
import serializers.Jackson;
import serializers.OrgJSONforPerson;

import java.util.HashMap;
import java.util.Random;

public class Main {
    public static void main(String[] args){
        Person person = getRandomPerson();
        Metrics.start();
        Jackson jackson = new Jackson<Person>(Person.class);
        try {
            jackson.serialize(person);
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
        GSON gson = new GSON<Person>(Person.class);
        try {
            gson.serialize(person);
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
        OrgJSONforPerson orgJSON = new OrgJSONforPerson();
        try {
            orgJSON.serialize(person);
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

    public static Person getRandomPerson() {
        Random rand = new Random();

        HashMap<String, String> friends = new HashMap<>();
        friends.put(randonNum(),randonString(3,4));
        friends.put(randonNum(),randonString(3,4));
        friends.put(randonNum(),randonString(3,4));

        Person person = new Person();
        person.setName(randonString(5,3));
        person.setAge(rand.nextInt(100));

        Address address = new Address();
        address.setStreet(randonString(5,5));
        address.setBuilding(rand.nextInt(52));
        person.setAddress(address);

        person.setFriends(friends);
        return person;
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
        String string = "+3092";
        for (int i=0; i<7; i++ ){
                string += rand.nextInt(9);
        }
        return string;
    }
}
