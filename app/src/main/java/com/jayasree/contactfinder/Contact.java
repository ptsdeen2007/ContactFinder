package com.jayasree.contactfinder;

public class Contact {
    int id;
    String taluk="";
    String village="";
    String land_no="";
    String moblie_no="";

    public Contact( int id,String taluk, String village, String land_no, String moblie_no) {
        this.id = id;
        this.taluk = taluk;
        this.village = village;
        this.land_no = land_no;
        this.moblie_no = moblie_no;
    }

    public int getId() {
        return id;
    }

    public String getTaluk() {
        return taluk;
    }

    public String getVillage() {
        return village;
    }

    public String getLand_no() {
        return land_no;
    }

    public String getMoblie_no() {
        return moblie_no;
    }
}
