package com.wbg.entity;

public class  Users {
    int uid;
    String uLName;
    String uLPwd;
    String uEmail;
    String uName;
    String uTel;
    String ustatus;

    public Users() {
    }

    public Users(int uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "users{" +
                "uid=" + uid +
                ", uLName='" + uLName + '\'' +
                ", uLPwd='" + uLPwd + '\'' +
                ", uEmail='" + uEmail + '\'' +
                ", uName='" + uName + '\'' +
                ", uTel='" + uTel + '\'' +
                ", ustatus='" + ustatus + '\'' +
                '}';
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
    public String getuLName() {
        return uLName;
    }

    public void setuLName(String uLName) {
        this.uLName = uLName;
    }

    public String getuLPwd() {
        return uLPwd;
    }

    public void setuLPwd(String uLPwd) {
        this.uLPwd = uLPwd;
    }

    public String getuEmail() {
        return uEmail;
    }

    public void setuEmail(String uEmail) {
        this.uEmail = uEmail;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuTel() {
        return uTel;
    }

    public void setuTel(String uTel) {
        this.uTel = uTel;
    }

    public String getUstatus() {
        return ustatus;
    }

    public void setUstatus(String ustatus) {
        this.ustatus = ustatus;
    }

    public Users(int uid, String uLName, String uLPwd, String uEmail, String uName, String uTel, String ustatus) {
        this.uid = uid;
        this.uLName = uLName;
        this.uLPwd = uLPwd;
        this.uEmail = uEmail;
        this.uName = uName;
        this.uTel = uTel;
        this.ustatus = ustatus;
    }
}
