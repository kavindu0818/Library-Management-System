package org.example.dto;
import org.example.Entity.User;

public class BookHandOverDto {

        private String id;
        private String title;
        private String autour;
        private String catougery;
        private String status;
        private String cusID;
        private User author;

    public BookHandOverDto() {
    }

    public BookHandOverDto(String id, String title, String autour, String catougery, String status, String cusID, User author) {
        this.id = id;
        this.title = title;
        this.autour = autour;
        this.catougery = catougery;
        this.status = status;
        this.cusID = cusID;
        this.author = author;
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

    public String getAutour() {
        return autour;
    }

    public void setAutour(String autour) {
        this.autour = autour;
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

    public String getCusID() {
        return cusID;
    }

    public void setCusID(String cusID) {
        this.cusID = cusID;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "BookHandOverDto{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", autour='" + autour + '\'' +
                ", catougery='" + catougery + '\'' +
                ", status='" + status + '\'' +
                ", cusID='" + cusID + '\'' +
                ", author=" + author +
                '}';
    }
}
