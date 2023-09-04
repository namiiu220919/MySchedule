package com.example.myschedule.model;

public class lich {
    private int id;
    private String ngayThangNam;
    private String ngayThang;
    private String lichNgay;

    public lich(String ngayThangNam, String ngayThang, String lichNgay) {
        this.ngayThangNam = ngayThangNam;
        this.ngayThang = ngayThang;
        this.lichNgay = lichNgay;
    }

    public lich() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNgayThangNam() {
        return ngayThangNam;
    }

    public void setNgayThangNam(String ngayThangNam) {
        this.ngayThangNam = ngayThangNam;
    }

    public String getNgayThang() {
        return ngayThang;
    }

    public void setNgayThang(String ngayThang) {
        this.ngayThang = ngayThang;
    }

    public String getLichNgay() {
        return lichNgay;
    }

    public void setLichNgay(String lichNgay) {
        this.lichNgay = lichNgay;
    }
}
