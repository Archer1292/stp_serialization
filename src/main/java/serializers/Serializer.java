package serializers;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;

public abstract class Serializer<T> {
    protected Class<T> paramClass;

    Serializer(Class<T> paramClass) {
        this.paramClass = paramClass;
    }

    public abstract void serialize(T serializableObject) throws IOException;
    public abstract T deserialize() throws IOException;

}