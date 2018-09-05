package com.wbg.entity;

public class  Index {
    double jtzj;
    double ztzj;

    public Index() {
    }

    @Override
    public String toString() {
        return "Index{" +
                "jtzj=" + jtzj +
                ", ztzj=" + ztzj +
                ", jtddl=" + jtddl +
                ", jtfkl=" + jtfkl +
                ", jtwfkl=" + jtwfkl +
                ", ztddl=" + ztddl +
                ", ztfkl=" + ztfkl +
                ", ztwfkl=" + ztwfkl +
                '}';
    }

    int jtddl=0;

    public double getJtzj() {
        return jtzj;
    }

    public void setJtzj(double jtzj) {
        this.jtzj = jtzj;
    }

    public double getZtzj() {
        return ztzj;
    }

    public void setZtzj(double ztzj) {
        this.ztzj = ztzj;
    }

    public int getJtddl() {
        return jtddl;
    }

    public void setJtddl(int jtddl) {
        this.jtddl = jtddl;
    }

    public int getJtfkl() {
        return jtfkl;
    }

    public void setJtfkl(int jtfkl) {
        this.jtfkl = jtfkl;
    }

    public int getJtwfkl() {
        return jtwfkl;
    }

    public void setJtwfkl(int jtwfkl) {
        this.jtwfkl = jtwfkl;
    }

    public int getZtddl() {
        return ztddl;
    }

    public void setZtddl(int ztddl) {
        this.ztddl = ztddl;
    }

    public int getZtfkl() {
        return ztfkl;
    }

    public void setZtfkl(int ztfkl) {
        this.ztfkl = ztfkl;
    }

    public int getZtwfkl() {
        return ztwfkl;
    }

    public void setZtwfkl(int ztwfkl) {
        this.ztwfkl = ztwfkl;
    }

    public Index(double jtzj, double ztzj, int jtddl, int jtfkl, int jtwfkl, int ztddl, int ztfkl, int ztwfkl) {
        this.jtzj = jtzj;
        this.ztzj = ztzj;
        this.jtddl = jtddl;
        this.jtfkl = jtfkl;
        this.jtwfkl = jtwfkl;
        this.ztddl = ztddl;
        this.ztfkl = ztfkl;
        this.ztwfkl = ztwfkl;
    }

    int jtfkl=0;
    int jtwfkl=0;
    int ztddl=0;
   int ztfkl=0;
    int ztwfkl;


}
