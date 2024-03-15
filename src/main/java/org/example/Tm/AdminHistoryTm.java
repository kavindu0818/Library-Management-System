package org.example.Tm;

public class AdminHistoryTm {
    private String id;
    private String title;
    private String bDate;
    private String hDate;
    private String cId;
    private String cName;

    public AdminHistoryTm() {
    }

    public AdminHistoryTm(String id, String title, String bDate, String hDate, String cId, String cName) {
        this.id = id;
        this.title = title;
        this.bDate = bDate;
        this.hDate = hDate;
        this.cId = cId;
        this.cName = cName;
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

    public String getbDate() {
        return bDate;
    }

    public void setbDate(String bDate) {
        this.bDate = bDate;
    }

    public String gethDate() {
        return hDate;
    }

    public void sethDate(String hDate) {
        this.hDate = hDate;
    }

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }
}
