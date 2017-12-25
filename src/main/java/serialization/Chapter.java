package serialization;

public class Chapter {
    private short page;
    private String title;
    private String text;

    public String getTitle() {
        return title;
    }
    public String getText() {
        return text;
    }
    public short getPage() {
        return page;
    }

    public Chapter () {this((short)0, "Unknown", "Unknown");}
    public Chapter(short page, String title, String text) {
        if (page > 0)
            this.page = page;
        this.title = title;
        this.text = text;
    }

    public Chapter clone() { return new Chapter(this.page, this.title, this.text); }

    @Override
    public String toString() {
        return "\'" + title + "\' at page " + page;
    }

    public boolean equals(Chapter chapter) {
        return this.page == chapter.page && this.title.equals(chapter.title) && this.text.equals(chapter.text);
    }
    @Override
    public boolean equals(Object object) {
        return (object instanceof Chapter) && (this.equals((Chapter)object));
    }
}
