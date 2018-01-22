package com.example.afiqhbs.firebaseloginv2.Class;

/**
 * Created by AfiqHBS on 21/01/2018.
 */

public class User {

    public String name;
    public String dateIn;
    public String late;
    public String address;
    public String dateOut;
    public String key;
    public String remarks;

    public User() {
    }

    public User(String name, String dateIn, String late, String address, String dateOut, String key, String remarks) {
        this.name = name;
        this.dateIn = dateIn;
        this.late = late;
        this.address = address;
        this.dateOut = dateOut;
        this.key = key;
        this.remarks = remarks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateIn() {
        return dateIn;
    }

    public void setDateIn(String dateIn) {
        this.dateIn = dateIn;
    }

    public String getLate() {
        return late;
    }

    public void setLate(String late) {
        this.late = late;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDateOut() {
        return dateOut;
    }

    public void setDateOut(String dateOut) {
        this.dateOut = dateOut;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
