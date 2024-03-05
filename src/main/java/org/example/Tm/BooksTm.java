package org.example.Tm;

public class BooksTm {

    private String id;
    private String title;
    private String author;
    private String Category;
    private String status;

    public BooksTm() {
    }

    public BooksTm(String id, String title, String author, String category, String status) {
        this.id = id;
        this.title = title;
        this.author = author;
        Category = category;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Books{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", Category='" + Category + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
