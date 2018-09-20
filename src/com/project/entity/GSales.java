package com.project.entity;


import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class GSales {
    private int gsid;
    private int gid;
    private int sid;
    private Date sdate;
    private int snum;


    private String gname;
    private BigDecimal gprice;
    private int gnum;
    private int gsnum; // 单钟商品销量总和


    public int getGsid() {
        return gsid;
    }

    public void setGsid(int gsid) {
        this.gsid = gsid;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public Date getSdate() {
        return sdate;
    }

    public void setSdate(Date sdate) {
        this.sdate = sdate;
    }

    public int getSnum() {
        return snum;
    }

    public void setSnum(int snum) {
        this.snum = snum;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public BigDecimal getGprice() {
        return gprice;
    }

    public void setGprice(BigDecimal gprice) {
        this.gprice = gprice;
    }

    public int getGnum() {
        return gnum;
    }

    public void setGnum(int gnum) {
        this.gnum = gnum;
    }

    public int getGsnum() {
        return gsnum;
    }

    public void setGsnum(int gsnum) {
        this.gsnum = gsnum;
    }

    @Override
    public String toString() {
        return "GSales{" +
                "gsid=" + gsid +
                ", gid=" + gid +
                ", sid=" + sid +
                ", sdate=" + sdate +
                ", snum=" + snum +
                ", gname='" + gname + '\'' +
                ", gprice=" + gprice +
                ", gnum=" + gnum +
                ", gsnum=" + gsnum +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GSales gSales = (GSales) o;
        return gsid == gSales.gsid &&
                gid == gSales.gid &&
                sid == gSales.sid &&
                snum == gSales.snum &&
                gnum == gSales.gnum &&
                gsnum == gSales.gsnum &&
                Objects.equals(sdate, gSales.sdate) &&
                Objects.equals(gname, gSales.gname) &&
                Objects.equals(gprice, gSales.gprice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gsid, gid, sid, sdate, snum, gname, gprice, gnum, gsnum);
    }
}
