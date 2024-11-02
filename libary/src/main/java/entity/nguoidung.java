/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Admin
 */
public class nguoidung {
        int manguoidung;
        String tentk;
        String email;
        String matkhau;
        String sodienthoai;

    public nguoidung() {
    }

    public nguoidung(String tentk, String email, String matkhau, String sodienthoai) {
        this.tentk = tentk;
        this.email = email;
        this.matkhau = matkhau;
        this.sodienthoai = sodienthoai;
    }

    public nguoidung(int manguoidung, String tentk, String email, String matkhau, String sodienthoai) {
        this.manguoidung = manguoidung;
        this.tentk = tentk;
        this.email = email;
        this.matkhau = matkhau;
        this.sodienthoai = sodienthoai;
    }

    public int getManguoidung() {
        return manguoidung;
    }

    public void setManguoidung(int manguoidung) {
        this.manguoidung = manguoidung;
    }

    public String getTentk() {
        return tentk;
    }

    public void setTentk(String tentk) {
        this.tentk = tentk;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public String getSodienthoai() {
        return sodienthoai;
    }

    public void setSodienthoai(String sodienthoai) {
        this.sodienthoai = sodienthoai;
    }

    @Override
    public String toString() {
        return "nguoidung{" + "manguoidung=" + manguoidung + ", tentk=" + tentk + ", email=" + email + ", matkhau=" + matkhau + ", sodienthoai=" + sodienthoai + '}';
    }
        
    
}
