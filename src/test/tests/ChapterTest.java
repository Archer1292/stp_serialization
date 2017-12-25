package tests;

import serialization.Chapter;
import org.junit.Test;
import static org.junit.Assert.*;

public class ChapterTest {
    @Test
    public void createWIthNegativePage() throws Exception {
        Chapter chapter = new Chapter((short)-10, "Chapter0", "bla");
        assertEquals((short)0, chapter.getPage());
    }
    @Test
    public void equalsEmpty() throws Exception {
        Chapter chapter = new Chapter();
        Chapter chapterSame = new Chapter();
        assertEquals(true, chapter.equals(chapterSame));
    }
    @Test
    public void equals() throws Exception {
        Chapter chapter = new Chapter((short)644, "Chapter5", "To be continued");
        Chapter chapterSame = new Chapter((short)644, "Chapter5", "To be continued");
        Object chapter2 = new Chapter((short)644, "Chapter5", "To be continued");
        Object chapterSame2 = new Chapter((short)644, "Chapter5", "To be continued");
        assertEquals(true, chapter.equals(chapterSame) && chapter2.equals(chapterSame2));
    }
    @Test
    public void notEquals() throws Exception {
        Chapter chapter = new Chapter((short)644, "Chapter5", "To be continued");
        Chapter chapterNotSame = new Chapter((short)200, "Chapter3", "To be continued");
        Object chapter2 = new Chapter((short)644, "Chapter5", "To be continued");
        Object chapterNotSame2 = new Chapter((short)200, "Chapter3", "To be continued");
        assertEquals(false, chapter.equals(chapterNotSame) || chapter2.equals(chapterNotSame2));
    }
    @Test
    public void testEmptyClone() throws Exception {
        Chapter chapter = new Chapter();
        Chapter chapterCloned = chapter.clone();
        assertEquals(true, chapter.equals(chapterCloned));
    }
    @Test
    public void testClone() throws Exception {
        Chapter chapter = new Chapter((short)644, "Chapter5", "To be continued");
        Chapter chapterCloned = chapter.clone();
        assertEquals(true, chapter.equals(chapterCloned));
    }
    @Test
    public void testToString() throws Exception {
        Chapter chapter = new Chapter((short)30, "Chapter2", "bla");
        assertEquals("'Chapter2' at page 30", chapter.toString());
    }
}