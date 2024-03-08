package org.example.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


import java.util.List;



@Entity
public class User {

    @Id
    private int phoneNumber;
    private String fullName;
    private String userName;
    private String password;
    private String gmail;


    @OneToMany(mappedBy = "cusID", cascade = CascadeType.ALL)
    private List<BookHandOver> books;

    public User(int phoneNumber, String fullName, String userName, String password, String gmail) {
        this.phoneNumber = phoneNumber;
        this.fullName = fullName;
        this.userName = userName;
        this.password = password;
        this.gmail = gmail;
    }

    public User() {

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

    public List<BookHandOver> getBooks() {
        return books;
    }

    public void setBooks(List<BookHandOver> books) {
        this.books = books;
    }
}
