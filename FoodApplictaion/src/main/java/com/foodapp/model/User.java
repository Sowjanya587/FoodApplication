package com.foodapp.model;

public class User {
    private int uid;
    private String name;
    private String email;
    private String mobileno;
    private String password;
    private String address;

    // Getters and Setters
    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // Constructor
    public User(int uid, String name, String email, String mobileno, String password, String address) {
        this.uid = uid;
        this.name = name;
        this.email = email;
        this.mobileno = mobileno;
        this.password = password;
        this.address = address;
    }

    public User() {}

    @Override
    public String toString() {
        return "User [uid=" + uid + ", name=" + name + ", email=" + email + ", mobileno=" + mobileno + ", password=" + password + ", address=" + address + "]";
    }
}
