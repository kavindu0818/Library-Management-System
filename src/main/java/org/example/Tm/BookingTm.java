package org.example.Tm;

import javafx.scene.control.Button;

public class BookingTm {

    private String id;
    private String title;
    private String authour;
    private String catougery;
    private String status;
    private Button button;

    public BookingTm() {}
    public BookingTm(String id, String title, String authour, String catougery, String status, Button button) {
        this.id = id;
        this.title = title;
        this.authour = authour;
        this.catougery = catougery;
        this.status = status;
        this.button = button;
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

    public String getAuthour() {
        return authour;
    }

    public void setAuthour(String authour) {
        this.authour = authour;
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

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }
}
