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

    public BranchTm(String id, String name, String loc, String oT, String cT, String now) {
        this.id = id;
        this.name = name;
        this.loc = loc;
        this.openT = oT;
        this.closeT = cT;
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

    public String getoT() {
        return openT;
    }

    public void setoT(String oT) {
        this.openT = oT;
    }

    public String getcT() {
        return closeT;
    }

    public void setcT(String cT) {
        this.closeT = cT;
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
