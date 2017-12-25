package serialization;

import org.json.simple.parser.ParseException;
import java.io.IOException;

public interface Serializable {
    void bookSerialize(Book book) throws IOException;
    Book bookDeserialize() throws IOException, ParseException;
}
