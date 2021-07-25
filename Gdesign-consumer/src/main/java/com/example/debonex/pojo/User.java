package com.example.debonex.pojo;

/**
 * @author Debonet
 */
public class User {
    private String uid;
    private String password;

    public User(String username, String password) {
        this.uid = username;
        this.password = password;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
