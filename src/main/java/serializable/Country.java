package serializable;

/**
 * @author Bratus Nadja on 1/4/2017
 * @project lab5
 */
public class Country {
    private String name;
    private double area;

    public void setArea(double area) {
        this.area = area;
    }

    public double getArea() {
        return area;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Country)) {
            return false;
        }

        Country address = (Country) o;

        return name.equals(address.name) && area == address.area;
    }
}
