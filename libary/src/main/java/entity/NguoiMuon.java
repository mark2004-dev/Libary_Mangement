/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Admin
 */
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class NguoiMuon {
    private int idNguoiMuon;
    private String tenNguoiMuon;
    private LocalDate ngayMuon;
    private LocalDate ngayTra;
    private String trangThai;
    private int soLuongMuon;
    List<Sach> sach ;

    // Constructor

    public NguoiMuon(int idNguoiMuon, String tenNguoiMuon, LocalDate ngayMuon, LocalDate ngayTra, String trangThai, int soLuongMuon, List<Sach> sach) {
        this.idNguoiMuon = idNguoiMuon;
        this.tenNguoiMuon = tenNguoiMuon;
        this.ngayMuon = ngayMuon;
        this.ngayTra = ngayTra;
        this.trangThai = trangThai;
        this.soLuongMuon = soLuongMuon;
        this.sach = sach;
    }
    public NguoiMuon(int idNguoiMuon, String tenNguoiMuon, LocalDate ngayMuon, LocalDate ngayTra, String trangThai, int soLuongMuon) {
    this.idNguoiMuon = idNguoiMuon;
    this.tenNguoiMuon = tenNguoiMuon;
    this.ngayMuon = ngayMuon;
    this.ngayTra = ngayTra;
    this.trangThai = trangThai;
    this.soLuongMuon = soLuongMuon;
    this.sach = new ArrayList<>(); // Khởi tạo danh sách rỗng
}


    public List<Sach> getSach() {
        return sach;
    }

    public void setSach(List<Sach> sach) {
        this.sach = sach;
    }
    

    // Getters and Setters
    public int getIdNguoiMuon() {
        return idNguoiMuon;
    }

    public void setIdNguoiMuon(int idNguoiMuon) {
        this.idNguoiMuon = idNguoiMuon;
    }

    public String getTenNguoiMuon() {
        return tenNguoiMuon;
    }

    public void setTenNguoiMuon(String tenNguoiMuon) {
        this.tenNguoiMuon = tenNguoiMuon;
    }

    public LocalDate getNgayMuon() {
        return ngayMuon;
    }

    public void setNgayMuon(LocalDate ngayMuon) {
        this.ngayMuon = ngayMuon;
    }

    public LocalDate getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(LocalDate ngayTra) {
        this.ngayTra = ngayTra;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public int getSoLuongMuon() {
        return soLuongMuon;
    }

    public void setSoLuongMuon(int soLuongMuon) {
        this.soLuongMuon = soLuongMuon;
    }

    @Override
    public String toString() {
        return "NguoiMuon{" +
                "idNguoiMuon=" + idNguoiMuon +
                ", tenNguoiMuon='" + tenNguoiMuon + '\'' +
                ", ngayMuon=" + ngayMuon +
                ", ngayTra=" + ngayTra +
                ", trangThai='" + trangThai + '\'' +
                ", soLuongMuon=" + soLuongMuon +
                '}';
    }
}

