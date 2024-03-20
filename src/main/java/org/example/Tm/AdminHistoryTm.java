package org.example.Tm;

import java.util.Date;

public class AdminHistoryTm {
    private String id;
    private String title;
    private String bookingDate;
    private String handOverDate;
    private String customerId;
    private String customerName;

    public AdminHistoryTm() {
    }

    public AdminHistoryTm(String id, String title, String bookingDate, String handOverDate, String customerId, String customerName) {
        this.id = id;
        this.title = title;
        this.bookingDate = bookingDate;
        this.handOverDate = handOverDate;
        this.customerId = customerId;
        this.customerName = customerName;
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

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

}
