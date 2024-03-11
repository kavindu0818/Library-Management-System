package org.example.Tm;

import javafx.scene.control.Button;

public class BookHandOverTm {

    private String id;
    private String title;
    private String autour;
    private String bookingDate;
    private String HandOverdate;
    private Button button;

    public BookHandOverTm() {
    }

    public BookHandOverTm(String id, String title, String autour, String bookingDate, String handOverdate, Button button) {
        this.id = id;
        this.title = title;
        this.autour = autour;
        this.bookingDate = bookingDate;
        HandOverdate = handOverdate;
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

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getHandOverdate() {
        return HandOverdate;
    }

    public void setHandOverdate(String handOverdate) {
        HandOverdate = handOverdate;
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
                ", bookingDate='" + bookingDate + '\'' +
                ", HandOverdate='" + HandOverdate + '\'' +
                ", button=" + button +
                '}';
    }
}
