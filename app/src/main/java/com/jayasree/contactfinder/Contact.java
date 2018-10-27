package com.jayasree.contactfinder;

public class Contact {
    int id;
    String taluk="";
    String village="";
    String address="";
    String land_no="";
    String moblie_no="";
    String email="";

    public Contact( int id,String taluk, String village, String address, String land_no, String moblie_no, String email) {
        this.id = id;
        this.taluk = taluk;
        this.village = village;
        this.address = address;
        this.land_no = land_no;
        this.moblie_no = moblie_no;
        this.email = email;
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

    public String getAddress() {
        return address;
    }

    public String getLand_no() {
        return land_no;
    }

    public String getMoblie_no() {
        return moblie_no;
    }

    public String getEmail() {
        return email;
    }
}
