package org.example.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class History {

    @Id
    private String hisId;
    private String bookId;
    private String title;
    private String bookingDate;
    private String handOverDate;
    private String cusId;

    public History() {
    }

    public History(String hisId, String bookId, String title, String bookingDate, String handOverDate, String cusId) {
        this.hisId = hisId;
        this.bookId = bookId;
        this.title = title;
        this.bookingDate = bookingDate;
        this.handOverDate = handOverDate;
        this.cusId = cusId;
    }

    public String getHisId() {
        return hisId;
    }

    public void setHisId(String hisId) {
        this.hisId = hisId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getCusId() {
        return cusId;
    }

    public void setCusId(String cusId) {
        this.cusId = cusId;
    }
}
