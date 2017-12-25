package serialization;

import org.json.simple.parser.ParseException;
import java.io.IOException;

public class Main {
    public static void main(String args[]){
        Book bookOriginal = new Book((short)200, "myBook", "me");
        bookOriginal.addChapter(new Chapter((short)1, "Introduction", "bla-bla"));
        bookOriginal.addChapter((short)3, "Content", "bla-bla");

        Book bookCopied = bookOriginal.clone();
        Serializable tester;
        long time = 0;

        tester = new JacksonSerialization();
        testSerialization(bookOriginal, bookCopied, tester, time);

        tester = new GSONSerialization();
        testSerialization(bookOriginal, bookCopied, tester, time);

        tester = new JSONSerialization();
        testSerialization(bookOriginal, bookCopied, tester, time);
    }

    private static void testSerialization(Book bookOriginal, Book bookCopied, Serializable tester, long time) {
        System.out.println(tester.getClass().getName());
        for (int i = 0; i < 3; i++) {
            time = System.nanoTime();
            toFile(tester, bookCopied);
            bookCopied = fromFile(tester);
            System.out.println((System.nanoTime() - time) + " nanosec");
            memoryConsumption();
            if (!bookOriginal.equals(bookCopied))
                System.out.println("ERROR");
        }
    }

    private static void toFile(Serializable tester, Book book) {
        try { tester.bookSerialize(book); }
        catch (IOException e) { e.printStackTrace(); }
    }

    private static Book fromFile(Serializable tester) {
        Book book = new Book();
        try { book = tester.bookDeserialize(); }
        catch (IOException | ParseException e) { e.printStackTrace(); }
        return book;
    }

    private static void memoryConsumption() {
        Runtime runtime = Runtime.getRuntime();
        runtime.gc();
        long memory = runtime.totalMemory() - runtime.freeMemory();
        System.out.printf("Memory used: %d B \n", memory);
    }
}
