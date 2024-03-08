package org.example.Tm;

import javafx.scene.control.Button;

public class BookHandOverTm {

    private String id;
    private String title;
    private String autour;
    private String cat;
    private String status;
    private Button button;

    public BookHandOverTm() {
    }

    public BookHandOverTm(String id, String title, String autour, String cat, String status, Button button) {
        this.id = id;
        this.title = title;
        this.autour = autour;
        this.cat = cat;
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

    public String getAutour() {
        return autour;
    }

    public void setAutour(String autour) {
        this.autour = autour;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
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

    @Override
    public String toString() {
        return "BookHandOverTm{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", autour='" + autour + '\'' +
                ", cat='" + cat + '\'' +
                ", status='" + status + '\'' +
                ", button=" + button +
                '}';
    }
}
