package serialization;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

public class Book {
    private short pageCount;
    final private String name;
    final private String author;
    final private List<Chapter> chapters;
    private Map<String, Object> map;

    public short getPageCount() {
        return pageCount;
    }
    public String getName() {
        return name;
    }
    public String getAuthor() {
        return author;
    }
    public List<Chapter> getChapters() {
        return chapters;
    }
    public Map<String, Object> getMap() {
        return map;
    }

    public Book() {this((short) 0, "Unknown", "Unknown");}
    public Book(short pageCount, String name, String author) {
        this(pageCount, name, author, null);
    }
    public Book(short pageCount, String name, String author, List<Chapter> chapters) {
        if (pageCount > 0)
            this.pageCount = pageCount;
        this.name = name;
        this.author =  author;
        if (chapters == null)
            this.chapters = new ArrayList<>();
        else
            this.chapters = chapters;
        initMap();
    }
    @SuppressWarnings("unchecked")
    private void initMap() {
        map = new HashMap();
        map.put("pageCount", pageCount);
        map.put("name", name);
        map.put("author", author);
    }

    public void addChapter(Chapter chapter) {
        chapters.add(chapter);
    }
    public void addChapter(short page, String name, String text) {
        addChapter(new Chapter(page, name, text));
    }

    @Override
    public String toString() {
        return "\'" + name + "\' written by " + author + ", " + chapters.size() + " chapter(s), " + pageCount + "p.";
    }

    public Book clone() {
        ArrayList<Chapter> chapters = new ArrayList<>();
        for (Chapter chapter:this.chapters)
            chapters.add(chapter.clone());
        return new Book(this.pageCount, this.name, this.author, chapters);
    }

    public boolean equals(Book book) {
        if (this.pageCount == book.pageCount && this.name.equals(book.name) && this.author.equals(book.author)
            && this.chapters.size() == book.chapters.size() && this.map.equals(book.getMap())) {
            for (int i = 0; i < this.chapters.size(); i++)
                if (!chapters.get(i).equals(book.chapters.get(i)))
                    return false;
            return true;
        }

        return false;
    }
    @Override
    public boolean equals(Object object) {
        return (object instanceof Book) && (this.equals((Book)object));
    }
}
