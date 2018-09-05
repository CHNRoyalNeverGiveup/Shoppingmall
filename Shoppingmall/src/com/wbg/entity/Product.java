package com.wbg.entity;

import java.math.BigDecimal;

public class Product {
    String pid;
    String pname;
    int ptid;
    String pimg;
    BigDecimal pprice;
    String pstatus;
    int pnumber;
    String detailed;
    String tname;

    public String getTname() {
        return tname;
    }

    public Product(String pid, String pname, int ptid, String pimg, BigDecimal pprice, String pstatus, int pnumber, String detailed, String tname) {
        this.pid = pid;
        this.pname = pname;
        this.ptid = ptid;
        this.pimg = pimg;
        this.pprice = pprice;
        this.pstatus = pstatus;
        this.pnumber = pnumber;
        this.detailed = detailed;
        this.tname = tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public Product() {
    }

    public Product(String pid) {
        this.pid = pid;
    }

    @Override
    public String toString() {
        return "Product{" +
                "pid='" + pid + '\'' +
                ", pname='" + pname + '\'' +
                ", ptid=" + ptid +
                ", pimg='" + pimg + '\'' +
                ", pprice=" + pprice +
                ", pstatus='" + pstatus + '\'' +
                ", pnumber=" + pnumber +
                ", detailed='" + detailed + '\'' +
                '}';
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public int getPtid() {
        return ptid;
    }

    public void setPtid(int ptid) {
        this.ptid = ptid;
    }

    public String getPimg() {
        return pimg;
    }

    public void setPimg(String pimg) {
        this.pimg = pimg;
    }

    public BigDecimal getPprice() {
        return pprice;
    }

    public void setPprice(BigDecimal pprice) {
        this.pprice = pprice;
    }

    public String getPstatus() {
        return pstatus;
    }

    public void setPstatus(String pstatus) {
        this.pstatus = pstatus;
    }

    public int getPnumber() {
        return pnumber;
    }

    public void setPnumber(int pnumber) {
        this.pnumber = pnumber;
    }

    public String getDetailed() {
        return detailed;
    }

    public void setDetailed(String detailed) {
        this.detailed = detailed;
    }

    public Product(String pid, String pname, int ptid, String pimg, BigDecimal pprice, String pstatus, int pnumber, String detailed) {
        this.pid = pid;
        this.pname = pname;
        this.ptid = ptid;
        this.pimg = pimg;
        this.pprice = pprice;
        this.pstatus = pstatus;
        this.pnumber = pnumber;
        this.detailed = detailed;
    }

}
