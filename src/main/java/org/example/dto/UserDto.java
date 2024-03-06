package org.example.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


public class UserDto {


    private int phoneNumber;
    private String fullName;
    private String userName;
    private String password;
    private String gmail;

    public UserDto() {
    }

    public UserDto(int phoneNumber, String fullName, String userName, String password, String gmail) {
        this.phoneNumber = phoneNumber;
        this.fullName = fullName;
        this.userName = userName;
        this.password = password;
        this.gmail = gmail;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    @Override
    public String toString() {
        return "User{" +
                "phoneNumber=" + phoneNumber +
                ", fullName='" + fullName + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", gmail='" + gmail + '\'' +
                '}';
    }
}
