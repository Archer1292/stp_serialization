package serializable;

import java.util.Map;

/**
 * @author Bratus Nadja on 1/4/2017
 * @project lab5
 */
public class City { 
    private String name;
    private int population;
    private Country country;
    private Map<String, String> neighbors;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Country getCountry() {
        return country;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getPopulation() {
        return population;
    }

    public void setNeighbors(Map<String, String> neighbors) {
        this.neighbors = neighbors;
    }

    public Map<String, String> getNeighbors() {
        return neighbors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof City)) {
            return false;
        }

        City person = (City) o;

        return name.equals(name) && population == person.population && neighbors.equals(person.neighbors) && country.equals(person.country);
    }
}
