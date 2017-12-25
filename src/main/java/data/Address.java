package data;

public class Address {
    private String street;
    private int building;

    public void setBuilding(int building) {
        this.building = building;
    }

    public int getBuilding() {
        return building;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreet() {
        return street;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Address)) {
            return false;
        }

        Address address = (Address) o;

        return street.equals(address.street) && building == address.building;
    }
}
