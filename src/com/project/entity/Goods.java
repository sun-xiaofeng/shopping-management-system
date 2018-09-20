package com.project.entity;

import java.math.BigDecimal;
import java.util.Objects;

public class Goods {
    private int gid;
    private String gname;
    private BigDecimal gprice;
    private int gnum;

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
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

    @Override
    public String toString() {
        return "Goods{" +
                "gid=" + gid +
                ", gname='" + gname + '\'' +
                ", gprice=" + gprice +
                ", gnum=" + gnum +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Goods goods = (Goods) o;
        return gid == goods.gid &&
                gnum == goods.gnum &&
                Objects.equals(gname, goods.gname) &&
                Objects.equals(gprice, goods.gprice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gid, gname, gprice, gnum);
    }
}
