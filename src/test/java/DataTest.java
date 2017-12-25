import data.Address;
import data.Person;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class DataTest {
    @Test

    public void PersonTest() {
        String name = "Den";
        int age = 25;
        String street = "Street";
        int building = 13;
        Map<String,String> map = new HashMap<String,String>();
        map.put("+3805487248","Joe");
        map.put("+3809865458","Rick");

        Person person = new Person();
        Address address = new Address();
        person.setName(name);
        person.setAge(age);
        person.setFriends(map);
        address.setStreet(street);
        address.setBuilding(building);
        person.setAddress(address);

        Assert.assertEquals(name, person.getName());
        Assert.assertEquals(age, person.getAge());
        Assert.assertEquals(map, person.getFriends());
        Assert.assertEquals(address, person.getAddress());
        Assert.assertEquals(street, address.getStreet());
        Assert.assertEquals(building, address.getBuilding());

        Assert.assertNotEquals(street, person.getAddress());
        Assert.assertEquals(address, address);
        Assert.assertNotEquals(street, address.getBuilding());
        Assert.assertEquals(person, person);
    }
}
