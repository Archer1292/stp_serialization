import data.Address;
import data.Person;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import serializers.GSON;
import serializers.Jackson;
import serializers.OrgJSONforPerson;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SerializationTest {
    Person person;

    @Before
    public void before() {
        String name = "Den";
        int age = 25;
        String street = "Street";
        int building = 13;
        Map<String, String> map = new HashMap<String, String>();
        map.put("+3805487248", "Joe");
        map.put("+3809865458", "Rick");

        Person person = new Person();
        Address address = new Address();
        person.setName(name);
        person.setAge(age);
        person.setFriends(map);
        address.setStreet(street);
        address.setBuilding(building);
        person.setAddress(address);

        this.person = person;
    }

    @Test
    public void JacksonTest() {
        try {
            Jackson jackson = new Jackson<Person>(Person.class, true);
            jackson.serialize(person);
            Assert.assertEquals(person, jackson.deserialize());
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void OrgJSON() {
        try {
            OrgJSONforPerson orgJSON = new OrgJSONforPerson(true);
            orgJSON.serialize(person);
            Assert.assertEquals(person, orgJSON.deserialize());
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void GSONTest() {
        try {
            GSON gson = new GSON<Person>(Person.class, true);
            gson.serialize(person);
            Assert.assertEquals(person, gson.deserialize());
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }
}
