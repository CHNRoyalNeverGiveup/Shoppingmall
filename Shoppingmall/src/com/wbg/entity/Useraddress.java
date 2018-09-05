package com.wbg.entity;

public class Useraddress {
    int udid;
    String addressu;
    int uidu;
    String unameu;

    public Useraddress(String addressu, int uidu, String unameu, String uphoneu) {
        this.addressu = addressu;
        this.uidu = uidu;
        this.unameu = unameu;
        this.uphoneu = uphoneu;
    }

    public Useraddress(int udid) {
        this.udid = udid;
    }

    @Override
    public String toString() {
        return "Useraddress{" +
                "udid=" + udid +
                ", addressu='" + addressu + '\'' +
                ", uidu=" + uidu +
                ", unameu='" + unameu + '\'' +
                ", uphoneu='" + uphoneu + '\'' +
                '}';
    }

    String uphoneu;

    public Useraddress() {
    }

    public Useraddress(int udid, String addressu, int uidu, String unameu, String uphoneu) {
        this.udid = udid;
        this.addressu = addressu;
        this.uidu = uidu;
        this.unameu = unameu;
        this.uphoneu = uphoneu;
    }

    public int getUdid() {
        return udid;
    }

    public void setUdid(int udid) {
        this.udid = udid;
    }

    public String getAddressu() {
        return addressu;
    }

    public void setAddressu(String addressu) {
        this.addressu = addressu;
    }

    public int getUidu() {
        return uidu;
    }

    public void setUidu(int uidu) {
        this.uidu = uidu;
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
}
