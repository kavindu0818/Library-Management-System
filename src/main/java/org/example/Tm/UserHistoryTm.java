package org.example.Tm;

public class UserHistoryTm {

    private String bookId;
    private String title;
    private String bookingDate;
    private String handOverDate;

    public UserHistoryTm() {
    }

    public UserHistoryTm(String bookId, String title, String bookingDate, String handOverDate) {
        this.bookId = bookId;
        this.title = title;
        this.bookingDate = bookingDate;
        this.handOverDate = handOverDate;
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
}
