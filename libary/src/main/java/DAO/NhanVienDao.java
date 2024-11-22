/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import entity.NhanVien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import view.jdbcUtil;

/**
 *
 * @author Admin
 */
public class NhanVienDao {

    public List<NhanVien> getAll() {
        List<NhanVien> NhanViens = new ArrayList<>();

        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = jdbcUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "SELECT * FROM nhan_vien ";
            PreparedStatement st = con.prepareStatement(sql);

            // Bước 3: thực thi câu lệnh SQL
            System.out.println(sql);
            ResultSet rs = st.executeQuery();

            // Bước 4:
            while (rs.next()) {

                int id = rs.getInt("idNhanVien");
                String ten = rs.getString("hoTen");
                String gioiTinh = rs.getString("gioiTinh");
            
                String diaChi = rs.getString("diaChi");
                
                Double luongCoBan = rs.getDouble("luongCoBan");
                NhanVien s = new NhanVien(id, ten, gioiTinh,  diaChi, luongCoBan);
                NhanViens.add(s);
                System.out.println("ID: " + id + ", Tên: " + ten + ", Giới tính: " + gioiTinh + 
        ", Địa chỉ: " + diaChi + ", Lương cơ bản: " + luongCoBan);
            }

            // Bước 5:
            jdbcUtil.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return NhanViens;
    }

    public boolean save(NhanVien nhanVien) {
        String sql = "INSERT INTO nhan_vien (hoTen, gioiTinh, diaChi, sdt, email, luongCoBan) VALUES (?, ?, ?, ?, ?, ? )";

        try (Connection con = jdbcUtil.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setString(1, nhanVien.getHoTen());
            pstmt.setString(2, nhanVien.getGioiTinh());
            pstmt.setString(3, nhanVien.getDiaChi());
            pstmt.setString(4, nhanVien.getSdt());
            pstmt.setString(5, nhanVien.getEmail());
            pstmt.setDouble(6, nhanVien.getLuongCoBan());

            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public NhanVien findById(int id) {
        String sql = "SELECT * FROM nhan_vien WHERE idNhanVien = ?";
        NhanVien nhanVien = null;

        try (Connection con = jdbcUtil.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setInt(1, id);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    nhanVien = new NhanVien();
                    nhanVien.setIdNhanVien(rs.getInt("idNhanVien"));
                    nhanVien.setHoTen(rs.getString("hoTen"));
                    nhanVien.setGioiTinh(rs.getString("gioiTinh"));
                    nhanVien.setDiaChi(rs.getString("diaChi"));
                    nhanVien.setSdt(rs.getString("sdt"));
                    nhanVien.setEmail(rs.getString("email"));
                    nhanVien.setLuongCoBan(rs.getDouble("luongCoBan"));

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return nhanVien;
    }

    public boolean update(NhanVien nhanVien) {
        String sql = "UPDATE nhan_vien SET hoTen = ?, gioiTinh = ?, diaChi = ?, sdt = ?, email = ?, luongCoBan = ? WHERE idNhanVien = ?";

        try (Connection con = jdbcUtil.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setString(1, nhanVien.getHoTen());
            pstmt.setString(2, nhanVien.getGioiTinh());
            pstmt.setString(3, nhanVien.getDiaChi());
            pstmt.setString(4, nhanVien.getSdt());
            pstmt.setString(5, nhanVien.getEmail());
            pstmt.setDouble(6, nhanVien.getLuongCoBan());

            pstmt.setInt(7, nhanVien.getIdNhanVien());

            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
public boolean delete(int idNhanVien) {
    String sql = "DELETE FROM nhan_vien WHERE idNhanVien = ?";

    try (Connection con = jdbcUtil.getConnection();
         PreparedStatement pstmt = con.prepareStatement(sql)) {

        pstmt.setInt(1, idNhanVien);

        return pstmt.executeUpdate() > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}

}
