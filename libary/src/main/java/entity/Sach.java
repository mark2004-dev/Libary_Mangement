/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Admin
 */
public class Sach {
    private int id; // ID tự tăng
    private String tenSach;
    private int namXuatBan;
    private double gia;
    private String tacgia;
    private String nhaxb;
    private String theloai;
    private int soluong;
    
    // Constructor không tham số
    public Sach() {}

    // Constructor có tham số
    public Sach(int id, String tenSach, int namXuatBan, double gia) {
        this.id = id;
        this.tenSach = tenSach;
        this.namXuatBan = namXuatBan;
        this.gia = gia;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    

    public Sach(int id, String tenSach, int namXuatBan, double gia, String tacgia, String nhaxb, String theloai, int soluong) {
        this.id = id;
        this.tenSach = tenSach;
        this.namXuatBan = namXuatBan;
        this.gia = gia;
        this.tacgia = tacgia;
        this.nhaxb = nhaxb;
        this.theloai = theloai;
        this.soluong = soluong;
    }

    

    
    public Sach(int id, String tenSach, int namXuatBan, double gia, String tacgia, String nhaxb, String theloai) {
        this.id = id;
        this.tenSach = tenSach;
        this.namXuatBan = namXuatBan;
        this.gia = gia;
        this.tacgia = tacgia;
        this.nhaxb = nhaxb;
        this.theloai = theloai;
    }

    public String getTacgia() {
        return tacgia;
    }

    public void setTacgia(String tacgia) {
        this.tacgia = tacgia;
    }

    public String getNhaxb() {
        return nhaxb;
    }

    public void setNhaxb(String nhaxb) {
        this.nhaxb = nhaxb;
    }

    public String getTheloai() {
        return theloai;
    }

    public void setTheloai(String theloai) {
        this.theloai = theloai;
    }
    

    // Getter và Setter cho từng thuộc tính
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public int getNamXuatBan() {
        return namXuatBan;
    }

    public void setNamXuatBan(int namXuatBan) {
        this.namXuatBan = namXuatBan;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    @Override
    public String toString() {
        return "Sach{" +
                "id=" + id +
                ", tenSach='" + tenSach + '\'' +
                ", namXuatBan=" + namXuatBan +
                ", gia=" + gia +
                '}';
    }
}

