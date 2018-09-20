package com.project.entity;

import java.util.Objects;

public class Salesman {
    private int sid;
    private String sname;
    private String spassword;

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSpassword() {
        return spassword;
    }

    public void setSpassword(String spassword) {
        this.spassword = spassword;
    }

    @Override
    public String toString() {
        return "Salesman{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", spassword='" + spassword + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Salesman salesman = (Salesman) o;
        return sid == salesman.sid &&
                Objects.equals(sname, salesman.sname) &&
                Objects.equals(spassword, salesman.spassword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid, sname, spassword);
    }
}
