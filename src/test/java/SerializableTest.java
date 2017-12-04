import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import serializable.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Bratus Nadja on 2/4/2017
 * @project lab5
 */


public class SerializableTest {
    @Test

    public void PersonTest() {
        String countryName = "Ukrain";
        double area = 603549d;
        String cityName = "Kyiv";
        int population = 23000;
        Map<String,String> map = new HashMap<String,String>();
        map.put("+38045","Konotop");
        map.put("+38043","Brovary");

        Country country = new Country();
        country.setName(countryName);
        country.setArea(area);

        City city = new City();
        city.setName(cityName);
        city.setPopulation(population);
        city.setCountry(country);
        city.setNeighbors(map);

        Assert.assertEquals(countryName, country.getName());
        Assert.assertEquals(area, country.getArea(),0.0000001);

        Assert.assertEquals(cityName, city.getName());
        Assert.assertEquals(population, city.getPopulation());
        Assert.assertEquals(map, city.getNeighbors());
        Assert.assertNotEquals(countryName, city.getCountry());
        Assert.assertEquals(city, city);
        Assert.assertNotEquals(area, city.getCountry());
        Assert.assertEquals(country, country);
    }
}