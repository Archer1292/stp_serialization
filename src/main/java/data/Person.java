package data;

import java.util.Map;

public class Person {
    private String name;
    private int age;
    private Address address;
    private Map<String, String> friends;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setFriends(Map<String, String> friends) {
        this.friends = friends;
    }

    public Map<String, String> getFriends() {
        return friends;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Person)) {
            return false;
        }

        Person person = (Person) o;

        return name.equals(name) && age == person.age && friends.equals(person.friends) && address.equals(person.address);
    }
}
