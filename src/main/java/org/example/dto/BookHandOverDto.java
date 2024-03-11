package org.example.dto;
import org.example.Entity.User;

public class BookHandOverDto {

    private String id;
    private String title;
    private String autour;
    private String bookingDate;
    private String handOverDate;
    private int cusID;
    public BookHandOverDto() {
    }

    public BookHandOverDto(String id, String title, String autour, String bookingDate, String handOverDate, int cusID) {
        this.id = id;
        this.title = title;
        this.autour = autour;
        this.bookingDate = bookingDate;
        this.handOverDate = handOverDate;
        this.cusID = cusID;
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

    public String getHandOverDate() {
        return handOverDate;
    }

    public void setHandOverDate(String handOverDate) {
        this.handOverDate = handOverDate;
    }

    public int getCusID() {
        return cusID;
    }

    public void setCusID(int cusID) {
        this.cusID = cusID;
    }

    @Override
    public String toString() {
        return "BookHandOverDto{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", autour='" + autour + '\'' +
                ", bookingDate='" + bookingDate + '\'' +
                ", handOverDate='" + handOverDate + '\'' +
                ", cusID=" + cusID +
                '}';
    }
}