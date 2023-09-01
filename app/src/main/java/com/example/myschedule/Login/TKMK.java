package com.example.myschedule.Login;

public class TKMK {
    private String Username, Password, hoten;

    public TKMK() {
    }

    public TKMK(String username, String password, String hoten) {
        Username = username;
        Password = password;
        this.hoten = hoten;
    }

    public TKMK(String username, String password) {
        Username = username;
        Password = password;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }
}
