package org.example.dto;

public class HistoryDto {

    private String bookId;
    private String title;
    private String bookingDate;
    private String handOverDate;
    private String cusId;
    private String cusName;

    public HistoryDto() {
    }

    public HistoryDto(String bookId, String title, String bookingDate, String handOverDate, String cusId, String cusName) {
        this.bookId = bookId;
        this.title = title;
        this.bookingDate = bookingDate;
        this.handOverDate = handOverDate;
        this.cusId = cusId;
        this.cusName = cusName;
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

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }
}
