package com.wbg.entity;

import java.math.BigDecimal;

public class ShoppingCart {
    int sid;
    String spid;
    int suid;
    String sstatus;
    int sorder;
    int shoppingcount;
    BigDecimal smoney;
    //商品名字
    String pname;
    //图片录取
    String pimg;

    public ShoppingCart(int sid, String spid, int suid, String sstatus, int sorder, int shoppingcount, BigDecimal smoney, String pname, String pimg, int pnumber, BigDecimal pprice) {
        this.sid = sid;
        this.spid = spid;
        this.suid = suid;
        this.sstatus = sstatus;
        this.sorder = sorder;
        this.shoppingcount = shoppingcount;
        this.smoney = smoney;
        this.pname = pname;
        this.pimg = pimg;
        this.pnumber = pnumber;
        this.pprice = pprice;
    }

    int pnumber;

    public int getPnumber() {
        return pnumber;
    }

    public void setPnumber(int pnumber) {
        this.pnumber = pnumber;
    }

    public ShoppingCart(int sid, String spid, int suid, String sstatus, int sorder, int shoppingcount, BigDecimal smoney, String pname, String pimg, BigDecimal pprice) {
        this.sid = sid;
        this.spid = spid;
        this.suid = suid;
        this.sstatus = sstatus;
        this.sorder = sorder;
        this.shoppingcount = shoppingcount;
        this.smoney = smoney;
        this.pname = pname;
        this.pimg = pimg;
        this.pprice = pprice;
    }

    //商品单价
    BigDecimal pprice;

    public ShoppingCart() {
    }

    public ShoppingCart(int sid) {
        this.sid = sid;
    }

    public BigDecimal getPprice() {
        return pprice;
    }

    public void setPprice(BigDecimal pprice) {
        this.pprice = pprice;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPimg() {
        return pimg;
    }

    public void setPimg(String pimg) {
        this.pimg = pimg;
    }

    public ShoppingCart(int sid, String spid, int suid, String sstatus, int sorder, int shoppingcount, BigDecimal smoney, String pname, String pimg) {
        this.sid = sid;
        this.spid = spid;
        this.suid = suid;
        this.sstatus = sstatus;
        this.sorder = sorder;
        this.shoppingcount = shoppingcount;
        this.smoney = smoney;
        this.pname = pname;
        this.pimg = pimg;
    }

    //商品价格
    public ShoppingCart(int sid, String spid, int suid, String sstatus, int shoppingcount, BigDecimal smoney, String pname, String pimg, int pnumber,BigDecimal pprice) {
        this.sid=sid;
        this.spid=spid;
        this.suid=suid;
        this.sstatus=sstatus;
        this.shoppingcount=shoppingcount;
        this.smoney=smoney;
        this.pname=pname;
        this.pimg=pimg;
        this.pnumber=pnumber;
        this.pprice=pprice;


    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSpid() {
        return spid;
    }

    public void setSpid(String spid) {
        this.spid = spid;
    }

    public int getSuid() {
        return suid;
    }

    public void setSuid(int suid) {
        this.suid = suid;
    }

    public String getSstatus() {
        return sstatus;
    }

    public void setSstatus(String sstatus) {
        this.sstatus = sstatus;
    }

    public int getSorder() {
        return sorder;
    }

    public void setSorder(int sorder) {
        this.sorder = sorder;
    }

    public int getShoppingcount() {
        return shoppingcount;
    }

    public void setShoppingcount(int shoppingcount) {
        this.shoppingcount = shoppingcount;
    }

    public BigDecimal getSmoney() {
        return smoney;
    }

    public void setSmoney(BigDecimal smoney) {
        this.smoney = smoney;
    }

    public ShoppingCart(int sid, String spid, int suid, String sstatus,  int shoppingcount, BigDecimal smoney) {
        this.sid = sid;
        this.spid = spid;
        this.suid = suid;
        this.sstatus = sstatus;
        this.shoppingcount = shoppingcount;
        this.smoney = smoney;
    }


    @Override
    public String toString() {
        return "ShoppingCart{" +
                "sid=" + sid +
                ", spid='" + spid + '\'' +
                ", suid=" + suid +
                ", sstatus='" + sstatus + '\'' +
                ", sorder=" + sorder +
                ", shoppingcount=" + shoppingcount +
                ", smoney=" + smoney +
                ", pname='" + pname + '\'' +
                ", pimg='" + pimg + '\'' +
                ", pprice=" + pprice +
                '}';
    }
}
