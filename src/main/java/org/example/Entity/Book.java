package org.example.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Book {

    @Id
    private String id;
    private String title;
    private String author;
    private String catougery;
    private String status;

    public Book() {
    }

    public Book(String id, String title, String author, String catougery, String status) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.catougery = catougery;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", catougery='" + catougery + '\'' +
                ", status='" + status + '\'' +
                '}';
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

    public String getCatougery() {
        return catougery;
    }

    public void setCatougery(String catougery) {
        this.catougery = catougery;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
