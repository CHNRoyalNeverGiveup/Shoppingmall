package com.wbg.entity;

import java.math.BigDecimal;
import java.util.Date;

public class OrderIndormation {
    BigDecimal smoney;
    String addressu;
    String unameu;

    public BigDecimal getSmoney() {
        return smoney;
    }

    public void setSmoney(BigDecimal smoney) {
        this.smoney = smoney;
    }

    String uphoneu;

    public OrderIndormation(BigDecimal smoney, String addressu, String unameu, String uphoneu, String oid, int ouid, Date otime, Date osuretime, BigDecimal omoney, String ostatus, int address, int sid, String spid, int suid, String sstatus, int shoppingcount, String pid, String pname, int ptid, String pimg, BigDecimal pprice, String pstatus, int pnumber, String detailed) {
        this.smoney = smoney;
        this.addressu = addressu;
        this.unameu = unameu;
        this.uphoneu = uphoneu;
        this.oid = oid;
        this.ouid = ouid;
        this.otime = otime;
        this.osuretime = osuretime;
        this.omoney = omoney;
        this.ostatus = ostatus;
        this.address = address;
        this.sid = sid;
        this.spid = spid;
        this.suid = suid;
        this.sstatus = sstatus;
        this.shoppingcount = shoppingcount;
        this.pid = pid;
        this.pname = pname;
        this.ptid = ptid;
        this.pimg = pimg;
        this.pprice = pprice;
        this.pstatus = pstatus;
        this.pnumber = pnumber;
        this.detailed = detailed;
    }

    public OrderIndormation(String addressu, String unameu, String uphoneu, String oid, int ouid, Date otime, Date osuretime, BigDecimal omoney, String ostatus, int address, int sid, String spid, int suid, String sstatus, int shoppingcount, String pid, String pname, int ptid, String pimg, BigDecimal pprice, String pstatus, int pnumber, String detailed) {
        this.addressu = addressu;
        this.unameu = unameu;
        this.uphoneu = uphoneu;
        this.oid = oid;
        this.ouid = ouid;
        this.otime = otime;
        this.osuretime = osuretime;
        this.omoney = omoney;
        this.ostatus = ostatus;
        this.address = address;
        this.sid = sid;
        this.spid = spid;
        this.suid = suid;
        this.sstatus = sstatus;
        this.shoppingcount = shoppingcount;
        this.pid = pid;
        this.pname = pname;
        this.ptid = ptid;
        this.pimg = pimg;
        this.pprice = pprice;
        this.pstatus = pstatus;
        this.pnumber = pnumber;
        this.detailed = detailed;
    }

    public String getAddressu() {
        return addressu;
    }

    public void setAddressu(String addressu) {
        this.addressu = addressu;
    }

    public String getUnameu() {
        return unameu;
    }

    public void setUnameu(String unameu) {
        this.unameu = unameu;
    }

    public String getUphoneu() {
        return uphoneu;
    }

    public void setUphoneu(String uphoneu) {
        this.uphoneu = uphoneu;
    }

    @Override
    public String toString() {
        return "OrderIndormation{" +
                "oid='" + oid + '\'' +
                ", ouid=" + ouid +
                ", otime=" + otime +
                ", osuretime=" + osuretime +
                ", omoney=" + omoney +
                ", ostatus='" + ostatus + '\'' +
                ", address=" + address +
                ", sid=" + sid +
                ", spid='" + spid + '\'' +
                ", suid=" + suid +
                ", sstatus='" + sstatus + '\'' +
                ", shoppingcount=" + shoppingcount +
                ", pid='" + pid + '\'' +
                ", pname='" + pname + '\'' +
                ", ptid=" + ptid +
                ", pimg='" + pimg + '\'' +
                ", pprice=" + pprice +
                ", pstatus='" + pstatus + '\'' +
                ", pnumber=" + pnumber +
                ", detailed='" + detailed + '\'' +
                '}';
    }

    String oid;
    int ouid;
    Date otime;
    Date osuretime;
    BigDecimal omoney;
    String ostatus;
    int  address;

    int sid;
    String spid;
    int suid;
    String sstatus;
    int shoppingcount;

    String pid;
    String pname;
    int ptid;
    String pimg;
    BigDecimal pprice;
    String pstatus;
    int pnumber;
    String detailed;

    public OrderIndormation(String oid, int ouid, Date otime, Date osuretime, BigDecimal omoney, String ostatus, int address, int sid, String spid, int suid, String sstatus,  int shoppingcount, String pid, String pname, int ptid, String pimg, BigDecimal pprice, String pstatus, int pnumber, String detailed) {
        this.oid = oid;
        this.ouid = ouid;
        this.otime = otime;
        this.osuretime = osuretime;
        this.omoney = omoney;
        this.ostatus = ostatus;
        this.address = address;
        this.sid = sid;
        this.spid = spid;
        this.suid = suid;
        this.sstatus = sstatus;
        this.shoppingcount = shoppingcount;
        this.pid = pid;
        this.pname = pname;
        this.ptid = ptid;
        this.pimg = pimg;
        this.pprice = pprice;
        this.pstatus = pstatus;
        this.pnumber = pnumber;
        this.detailed = detailed;
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



    public int getShoppingcount() {
        return shoppingcount;
    }

    public void setShoppingcount(int shoppingcount) {
        this.shoppingcount = shoppingcount;
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

    public OrderIndormation() {
    }
    public OrderIndormation(int ouid,BigDecimal omoney, int address) {
        this.ouid = ouid;
        this.omoney = omoney;
        this.address = address;
    }

    public OrderIndormation(String oid, int ouid, Date otime, Date osuretime, BigDecimal omoney, String ostatus, int address) {
        this.oid = oid;
        this.ouid = ouid;
        this.otime = otime;
        this.osuretime = osuretime;
        this.omoney = omoney;
        this.ostatus = ostatus;
        this.address = address;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public int getOuid() {
        return ouid;
    }

    public void setOuid(int ouid) {
        this.ouid = ouid;
    }

    public Date getOtime() {
        return otime;
    }

    public void setOtime(Date otime) {
        this.otime = otime;
    }

    public Date getOsuretime() {
        return osuretime;
    }

    public void setOsuretime(Date osuretime) {
        this.osuretime = osuretime;
    }

    public BigDecimal getOmoney() {
        return omoney;
    }

    public void setOmoney(BigDecimal omoney) {
        this.omoney = omoney;
    }

    public String getOstatus() {
        return ostatus;
    }

    public void setOstatus(String ostatus) {
        this.ostatus = ostatus;
    }

    public int getAddress() {
        return address;
    }

    public void setAddress(int address) {
        this.address = address;
    }
}
