import serializable.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import serializers.GSON;
import serializers.Jackson;
import serializers.OrgJSONforCity;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Bratus Nadja on 5/4/2017
 * @project lab5
 */
public class SerializationTest {
    City city;

    @Before
    public void before() {
        String cityName = "Lviv";
        int population = 2500;
        String countryName = "Ukrain";
        double area = 1334.3;
        Map<String, String> map = new HashMap<String, String>();
        map.put("+38054", "Frankivsk");
        map.put("+38052", "Ternopil");

        City city = new City();
        Country country = new Country();
        city.setName(cityName);
        city.setPopulation(population);
        city.setNeighbors(map);
        country.setName(countryName);
        country.setArea(area);
        city.setCountry(country);

        this.city = city;
    }

    @Test
    public void JacksonTest() {
        try {
            Jackson jackson = new Jackson<City>(City.class, true);
            jackson.serialize(city);
            Assert.assertEquals(city, jackson.deserialize());
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void OrgJSON() {
        try {
            OrgJSONforCity orgJSON = new OrgJSONforCity(true);
            orgJSON.serialize(city);
            Assert.assertEquals(city, orgJSON.deserialize());
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void GSONTest() {
        try {
            GSON gson = new GSON<City>(City.class, true);
            gson.serialize(city);
            Assert.assertEquals(city, gson.deserialize());
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }
}
