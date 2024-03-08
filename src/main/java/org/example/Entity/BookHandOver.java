package org.example.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class BookHandOver {

    @Id
    private String id;
    private String title;
    private String autour;
    private String catougery;
    private String status;
    private String cusID;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User author;

    public BookHandOver() {
    }

    public BookHandOver(String id, String title, String autour, String catougery, String status, int cusID) {
        this.id = id;
        this.title = title;
        this.autour = autour;
        this.catougery = catougery;
        this.status = status;
        this.cusID = String.valueOf(cusID);
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

    public int getCusID() {
        return Integer.parseInt(cusID);
    }

    public void setCusID(int cusID) {
        this.cusID = String.valueOf(cusID);
    }

    @Override
    public String toString() {
        return "BookHandOver{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", autour='" + autour + '\'' +
                ", catougery='" + catougery + '\'' +
                ", status='" + status + '\'' +
                ", cusID='" + cusID + '\'' +
                '}';
    }
}
