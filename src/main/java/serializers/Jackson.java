package serializers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Jackson<T> extends Serializer<T>{
    private ObjectMapper mapper;

    public Jackson(Class<T> paramClass) {
        super(paramClass);
        mapper = new ObjectMapper();
    }

    private String testString = "";

    public Jackson(Class<T> paramClass, boolean isTest) {
        this(paramClass);
        if (isTest) {
            testString = "_test";
        }
    }

    @Override
    public void serialize(T object) throws IOException {
        mapper.writeValue(new File(paramClass.getName() + "_Jackson.json" + testString), object);
    }

    @Override
    public T deserialize()throws IOException {
        T object = null;
        object = mapper.readValue(new File(paramClass.getName() + "_Jackson.json" + testString), paramClass);
        return object;
    }
}
