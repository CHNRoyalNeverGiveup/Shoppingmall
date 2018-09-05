package com.wbg.entity;

public class ProductType {
    int tid;
    String tname;
    String tstatus;

    public ProductType() {
    }

    public ProductType(int tid) {
        this.tid = tid;
    }

    @Override
    public String toString() {
        return "ProductType{" +
                "tid=" + tid +
                ", tname='" + tname + '\'' +
                ", tstatus='" + tstatus + '\'' +
                '}';
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTstatus() {
        return tstatus;
    }

    public void setTstatus(String tstatus) {
        this.tstatus = tstatus;
    }

    public ProductType(int tid, String tname, String tstatus) {
        this.tid = tid;
        this.tname = tname;
        this.tstatus = tstatus;
    }
}
