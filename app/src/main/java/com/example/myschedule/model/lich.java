package com.example.myschedule.model;

public class lich {
    private int id;
    private String ngayThangNam;
    private String ngayThang;
    private String lichNgay;

    public lich() {
        this.ngayThangNam = ngayThangNam;
        this.ngayThang = ngayThang;
        this.lichNgay = lichNgay;
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
