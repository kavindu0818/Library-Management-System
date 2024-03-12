package org.example.Tm;

public class UserTm {
    private String phone;
    private String full;
    private String gmail;
    private String userName;
    private String pass;

    public UserTm() {
    }

    public UserTm(String phone, String full, String gmail, String userName, String pass) {
        this.phone = phone;
        this.full = full;
        this.gmail = gmail;
        this.userName = userName;
        this.pass = pass;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFull() {
        return full;
    }

    public void setFull(String full) {
        this.full = full;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
