package org.example.Tm;

public class BranchTm {

    private String id;
    private String name;
    private String loc;
    private String openT;
    private String closeT;
    private String now;

    public BranchTm() {
    }

    public BranchTm(String id, String name, String loc, String openT, String closeT, String now) {
        this.id = id;
        this.name = name;
        this.loc = loc;
        this.openT = openT;
        this.closeT = closeT;
        this.now = now;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public String getOpenT() {
        return openT;
    }

    public void setOpenT(String openT) {
        this.openT = openT;
    }

    public String getCloseT() {
        return closeT;
    }

    public void setCloseT(String closeT) {
        this.closeT = closeT;
    }

    public String getNow() {
        return now;
    }

    public void setNow(String now) {
        this.now = now;
    }

    @Override
    public String toString() {
        return "BranchTm{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", loc='" + loc + '\'' +
                ", oT='" + openT + '\'' +
                ", cT='" + closeT + '\'' +
                ", now='" + now + '\'' +
                '}';
    }
}
