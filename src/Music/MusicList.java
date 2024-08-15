package Music;

public class MusicList {

    private int id;
    private String author;
    private String name;
    private String description;
    private int categorization;

    public String getAuthor() {
        return author;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getCategorization() {
        return categorization;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategorization(int categorization) {
        this.categorization = categorization;
    }
    @Override
    public String toString() {
        return
                "노래 제목 : " + name +
                ",  그룹명 : " + author +
                ",  노래 설명 : " + description;
    }
}

