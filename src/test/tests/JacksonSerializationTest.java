package tests;

import org.junit.Test;
import serialization.Book;
import serialization.Chapter;
import serialization.JacksonSerialization;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class JacksonSerializationTest {
        @Test
        public void serializationEmpty() throws Exception {
            JacksonSerialization tester = new JacksonSerialization();
            Book book = new Book();
            tester.bookSerialize(book);
            Book bookDeserialized = tester.bookDeserialize();
            assertEquals(true, book.equals(bookDeserialized));
        }
        @Test
        public void serialization() throws Exception {
            ArrayList<Chapter> chapters = new ArrayList<>();
            chapters.add(new Chapter((short)2, "Intro", "Hi!"));
            JacksonSerialization tester = new JacksonSerialization();
            Book book = new Book((short)644, "Chapter5", "To be continued",chapters);
            tester.bookSerialize(book);
            Book bookDeserialized = tester.bookDeserialize();
            assertEquals(true, book.equals(bookDeserialized));
        }
}