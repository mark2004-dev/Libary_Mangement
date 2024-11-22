/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Admin
 */
public class NhanVien {
    private int idNhanVien; // Mã nhân viên (khóa chính)
    private String hoTen; // Họ và tên
    private String gioiTinh; // Giới tính
    private String diaChi; // Địa chỉ
    private String sdt; // Số điện thoại
    private String email; 
    private double luongCoBan; // Lương cơ bản// Phòng ban
     // Trạng thái làm việc (ví dụ: đang làm việc, nghỉ việc)

    public NhanVien() {
    }
    
     public NhanVien(int idNhanVien, String hoTen, String gioiTinh, String diaChi, double luongCoBan) {
        this.idNhanVien = idNhanVien;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.luongCoBan = luongCoBan;
    }
    public NhanVien(int idNhanVien, String hoTen, String gioiTinh, String diaChi, String sdt, String email, double luongCoBan) {
        this.idNhanVien = idNhanVien;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.email = email;
        this.luongCoBan = luongCoBan;
    }

    
    // Getters and setters

    public int getIdNhanVien() {
        return idNhanVien;
    }

    public void setIdNhanVien(int idNhanVien) {
        this.idNhanVien = idNhanVien;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getLuongCoBan() {
        return luongCoBan;
    }

    public void setLuongCoBan(double luongCoBan) {
        this.luongCoBan = luongCoBan;
    }

    @Override
    public String toString() {
        return "NhanVien{" + "idNhanVien=" + idNhanVien + ", hoTen=" + hoTen + ", gioiTinh=" + gioiTinh + ", diaChi=" + diaChi + ", sdt=" + sdt + ", email=" + email + ", luongCoBan=" + luongCoBan + '}';
    }
    
}

