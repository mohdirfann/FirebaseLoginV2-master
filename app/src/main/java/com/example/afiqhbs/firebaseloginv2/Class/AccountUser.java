package com.example.afiqhbs.firebaseloginv2.Class;

/**
 * Created by AfiqHBS on 21/01/2018.
 */

public class AccountUser {

    public String id;
    public String password;
    public String name;

    public AccountUser() {
    }

    public AccountUser(String id, String password, String name) {
        this.id = id;
        this.password = password;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
