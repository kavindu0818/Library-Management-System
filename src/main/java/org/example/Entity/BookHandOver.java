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
    private String bookingDate;
    private String HandOverDate;


  @ManyToOne
  @JoinColumn(name = "userId", nullable = false)
    private User cusID;

    public BookHandOver() {

    }

    public BookHandOver(String id, String title, String autour, String bookingDate, String handOverDate, User cusID) {
        this.id = id;
        this.title = title;
        this.autour = autour;
        this.bookingDate = bookingDate;
        HandOverDate = handOverDate;
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
        return HandOverDate;
    }

    public void setHandOverDate(String handOverDate) {
        HandOverDate = handOverDate;
    }

    public User getCusID() {
        return cusID;
    }

    public void setCusID(User cusID) {
        this.cusID = cusID;
    }
}
