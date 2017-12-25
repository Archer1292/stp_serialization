package tests;

import org.junit.Test;
import serialization.Book;
import serialization.Chapter;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BookTest {
    @Test
    public void createWIthNegativePage() throws Exception {
        Book book = new Book((short)-10, "The Book", "Me");
        assertEquals((short)0, book.getPageCount());
    }
    @Test
    public void equalsEmpty() throws Exception {
        Book book = new Book();
        Book bookSame = new Book();
        assertEquals(true, book.equals(bookSame));
    }
    @Test
    public void equals() throws Exception {
        ArrayList<Chapter> chapters = new ArrayList<>();
        chapters.add(new Chapter((short)2, "Intro", "Hi!"));
        Book book = new Book((short)914, "The Book", "Me", chapters);
        Book bookSame = new Book((short)914, "The Book", "Me", chapters);
        Object book2 = new Book((short)914, "The Book", "Me", chapters);
        Object bookSame2 = new Book((short)914, "The Book", "Me", chapters);
        assertEquals(true, book.equals(bookSame) && book2.equals(bookSame2));
    }
    @Test
    public void notEquals() throws Exception {
        ArrayList<Chapter> chapters = new ArrayList<>();
        chapters.add(new Chapter((short)2, "Intro", "Hi!"));
        Book book = new Book((short)914, "The Book", "Me", chapters);
        Book bookNotSame = new Book((short)914, "The Book 2", "Me", chapters);
        Object book2 = new Book((short)914, "The Book", "Me", chapters);
        Object bookNotSame2 = new Book((short)914, "The Book 2", "Me", chapters);
        assertEquals(false, book.equals(bookNotSame) || book2.equals(bookNotSame2));
    }
    @Test
    public void notEqualsWithChapters() throws Exception {
        ArrayList<Chapter> chapters = new ArrayList<>();
        chapters.add(new Chapter((short)2, "Intro", "Hi!"));
        chapters.add(new Chapter((short)5, "Chapter1", "It was..!"));
        Book book = new Book((short)914, "The Book", "Me", chapters);

        ArrayList<Chapter> chaptersNotSame = new ArrayList<>();
        chaptersNotSame.add(new Chapter((short)2, "Intro", "Hi!"));
        chaptersNotSame.add(new Chapter((short)5, "Chapter1", "It is..!"));
        Book bookNotSame = new Book((short)914, "The Book", "Me", chaptersNotSame);
        assertEquals(false, book.equals(bookNotSame));
    }
    @Test
    public void testEmptyClone() throws Exception {
        Book book = new Book();
        Book bookCloned = book.clone();
        assertEquals(true, book.equals(bookCloned));
    }
    @Test
    public void testClone() throws Exception {
        ArrayList<Chapter> chapters = new ArrayList<>();
        chapters.add(new Chapter((short)2, "Intro", "Hi!"));
        Book book = new Book((short)644, "Chapter5", "To be continued", chapters);
        Book bookCloned = book.clone();
        assertEquals(true, book.equals(bookCloned));
    }
    @Test
    public void testToString() throws Exception {
        ArrayList<Chapter> chapters = new ArrayList<>();
        chapters.add(new Chapter((short)2, "Intro", "Hi!"));
        Book book = new Book((short)192, "The Book", "Me", chapters);
        assertEquals("'The Book' written by Me, 1 chapter(s), 192p.", book.toString());
    }
}