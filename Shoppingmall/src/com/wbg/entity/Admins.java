package com.wbg.entity;

public class Admins {
    int aid;
    String alname;
    String alpwd;
    String astatus;
    String aname;

    public Admins() {
    }

    public Admins(int aid) {
        this.aid = aid;
    }

    @Override
    public String toString() {
        return "Admins{" +
                "aid=" + aid +
                ", alname='" + alname + '\'' +
                ", alpwd='" + alpwd + '\'' +
                ", astatus='" + astatus + '\'' +
                ", aname='" + aname + '\'' +
                '}';
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getAlname() {
        return alname;
    }

    public void setAlname(String alname) {
        this.alname = alname;
    }

    public String getAlpwd() {
        return alpwd;
    }

    public void setAlpwd(String alpwd) {
        this.alpwd = alpwd;
    }

    public String getAstatus() {
        return astatus;
    }

    public void setAstatus(String astatus) {
        this.astatus = astatus;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public Admins(int aid, String alname, String alpwd, String astatus, String aname) {
        this.aid = aid;
        this.alname = alname;
        this.alpwd = alpwd;
        this.astatus = astatus;
        this.aname = aname;
    }
}
