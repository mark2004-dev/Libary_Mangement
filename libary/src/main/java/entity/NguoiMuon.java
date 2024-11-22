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
    
    private int soLuongMuon;
    List<Sach> sach ;
    private String queQuan;
    private String sdt;
    private String Gmail;

    // Constructor

    
    
    

    public NguoiMuon(String tenNguoiMuon, LocalDate ngayMuon, LocalDate ngayTra, String queQuan, String sdt, String Gmail,int soLuongMuon) {
        this.tenNguoiMuon = tenNguoiMuon;
        this.ngayMuon = ngayMuon;
        this.ngayTra = ngayTra;
        this.queQuan = queQuan;
        this.sdt = sdt;
        this.Gmail = Gmail;
        this.soLuongMuon=soLuongMuon;
    }
    
    public NguoiMuon(int idNguoiMuon, String tenNguoiMuon, LocalDate ngayMuon, LocalDate ngayTra, int soLuongMuon, String queQuan, String sdt, String Gmail) {
        this.idNguoiMuon = idNguoiMuon;
        this.tenNguoiMuon = tenNguoiMuon;
        this.ngayMuon = ngayMuon;
        this.ngayTra = ngayTra;
        
        this.soLuongMuon = soLuongMuon;
        this.queQuan = queQuan;
        this.sdt = sdt;
        this.Gmail = Gmail;
    }

    public NguoiMuon(int idNguoiMuon, String tenNguoiMuon, LocalDate ngayMuon, LocalDate ngayTra, int soLuongMuon) {
    this.idNguoiMuon = idNguoiMuon;
    this.tenNguoiMuon = tenNguoiMuon;
    this.ngayMuon = ngayMuon;
    this.ngayTra = ngayTra;
    
    this.soLuongMuon = soLuongMuon;
    // Các trường khác như 'queQuan', 'sdt', 'Gmail' có thể được bỏ qua hoặc set giá trị mặc định nếu cần
}

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getGmail() {
        return Gmail;
    }

    public void setGmail(String Gmail) {
        this.Gmail = Gmail;
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
                
                ", soLuongMuon=" + soLuongMuon +
                '}';
    }
}

