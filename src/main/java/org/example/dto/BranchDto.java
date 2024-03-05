package org.example.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.sql.Time;


public class BranchDto {

    private String branchId;
    private String branchName;
    private String location;
    private Time openTime;
    private Time closeTime;
    private String oORc;

    public BranchDto() {
    }

    public BranchDto(String branchId, String branchName, String location, Time openTime, Time closeTime, String oORc) {
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

    public Time getOpenTime() {
        return openTime;
    }

    public void setOpenTime(Time openTime) {
        this.openTime = openTime;
    }

    public Time getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Time closeTime) {
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
