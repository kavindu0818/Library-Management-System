package org.example.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.sql.Time;

@Entity
public class Branch {

    @Id
    private String branchId;
    private String branchName;
    private String location;
    private String openTime;
    private String closeTime;
    private String oORc;

    public Branch() {
    }

    public Branch(String branchId, String branchName, String location, String openTime, String closeTime, String oORc) {
        this.branchId = branchId;
        this.branchName = branchName;
        this.location = location;
        this.openTime = openTime;
        this.closeTime = closeTime;
        this.oORc = oORc;
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    public String getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(String closeTime) {
        this.closeTime = closeTime;
    }

    public String getoORc() {
        return oORc;
    }

    public void setoORc(String oORc) {
        this.oORc = oORc;
    }

    @Override
    public String toString() {
        return "Branch{" +
                "branchId='" + branchId + '\'' +
                ", branchName='" + branchName + '\'' +
                ", location='" + location + '\'' +
                ", openTime=" + openTime +
                ", closeTime=" + closeTime +
                ", oORc='" + oORc + '\'' +
                '}';
    }
}
