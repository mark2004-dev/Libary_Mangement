/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import entity.NguoiMuon;
import entity.Sach;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import view.jdbcUtil;

/**
 *
 * @author Admin
 */
public class NguoiMuonDAO {
    public List<NguoiMuon> getAll() {
        List<NguoiMuon> nguoimuon = new ArrayList<>();
        
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = jdbcUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "SELECT * FROM nguoi_muon " ;
            PreparedStatement st = con.prepareStatement(sql);
            

            // Bước 3: thực thi câu lệnh SQL
            System.out.println(sql);
            ResultSet rs = st.executeQuery();

            // Bước 4:
            while (rs.next()) {

                 int id = rs.getInt("id");
                    String ten = rs.getString("ten_nguoi_muon");
                    LocalDate ngayMuon = rs.getDate("ngay_muon").toLocalDate();
                    LocalDate ngayTra = rs.getDate("ngay_tra") != null ? rs.getDate("ngay_tra").toLocalDate() : null;
                    
                    int soLuong = rs.getInt("so_luong_muon");
                    String queQuan = rs.getString("queQuan");
                    String sdt = rs.getString("sdt");
                    String gmail = rs.getString("Gmail");
                NguoiMuon s = new NguoiMuon(id,ten,ngayMuon, ngayTra,soLuong,queQuan,sdt,gmail);
                nguoimuon.add(s);
            }

            // Bước 5:
            jdbcUtil.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return nguoimuon;
    }
    
    public boolean save(NguoiMuon nguoi) {
    String sql = "INSERT INTO nguoi_muon (id, ten_nguoi_muon, ngay_muon, ngay_tra, so_luong_muon, queQuan, sdt, Gmail) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

    try (Connection con = jdbcUtil.getConnection();
         PreparedStatement pstmt = con.prepareStatement(sql)) {

        pstmt.setInt(1, nguoi.getIdNguoiMuon());
        pstmt.setString(2, nguoi.getTenNguoiMuon());
        pstmt.setDate(3, nguoi.getNgayMuon() != null ? java.sql.Date.valueOf(nguoi.getNgayMuon()) : null);
        pstmt.setDate(4, nguoi.getNgayTra() != null ? java.sql.Date.valueOf(nguoi.getNgayTra()) : null);
       
        pstmt.setInt(6, nguoi.getSoLuongMuon());
        pstmt.setString(7, nguoi.getQueQuan());
        pstmt.setString(8, nguoi.getSdt());
        pstmt.setString(9, nguoi.getGmail());

        return pstmt.executeUpdate() > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}
    public NguoiMuon findById(int id) {
    NguoiMuon ketQua = null;
    String sql = "SELECT * FROM nguoi_muon WHERE id = ?";

    try (Connection con = jdbcUtil.getConnection();
         PreparedStatement st = con.prepareStatement(sql)) {
        
        st.setInt(1, id);
        ResultSet rs = st.executeQuery();

        if (rs.next()) {
            int idNguoiMuon = rs.getInt("id");
            String tenNguoiMuon = rs.getString("ten_nguoi_muon");
            LocalDate ngayMuon = rs.getDate("ngay_muon") != null ? rs.getDate("ngay_muon").toLocalDate() : null;
            LocalDate ngayTra = rs.getDate("ngay_tra") != null ? rs.getDate("ngay_tra").toLocalDate() : null;
            String trangThai = rs.getString("trang_thai");
            int soLuongMuon = rs.getInt("so_luong_muon");

            // Khởi tạo đối tượng NguoiMuon với dữ liệu từ cơ sở dữ liệu
            ketQua = new NguoiMuon(idNguoiMuon, tenNguoiMuon, ngayMuon, ngayTra, soLuongMuon);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return ketQua;
}

    public boolean updateNguoiMuon(NguoiMuon nguoiMuon) {
    String sql = "UPDATE nguoi_muon SET ten_nguoi_muon = ?, ngay_muon = ?, ngay_tra = ?, so_luong_muon = ?, queQuan = ?, sdt = ?, Gmail = ? WHERE id = ?";

    try (Connection con = jdbcUtil.getConnection();
         PreparedStatement st = con.prepareStatement(sql)) {

        // Cập nhật các giá trị vào câu lệnh SQL
        st.setString(1, nguoiMuon.getTenNguoiMuon());
        st.setObject(2, nguoiMuon.getNgayMuon()); // LocalDate có thể sử dụng setObject để lưu vào SQL
        st.setObject(3, nguoiMuon.getNgayTra());
        
        st.setInt(4, nguoiMuon.getSoLuongMuon());
        st.setString(5, nguoiMuon.getQueQuan());
        st.setString(6, nguoiMuon.getSdt());
        st.setString(7, nguoiMuon.getGmail());
        st.setInt(8, nguoiMuon.getIdNguoiMuon());

        // Thực thi câu lệnh SQL
        int rowsUpdated = st.executeUpdate();

        // Kiểm tra nếu có ít nhất 1 bản ghi được cập nhật
        return rowsUpdated > 0;

    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}
    public boolean deleteNguoiMuon(int id) {
    String sql = "DELETE FROM nguoi_muon WHERE id = ?";

    try (Connection con = jdbcUtil.getConnection(); 
         PreparedStatement st = con.prepareStatement(sql)) {

        // Set ID vào câu lệnh SQL
        st.setInt(1, id);

        // Thực thi câu lệnh DELETE
        int rowsAffected = st.executeUpdate();

        // Kiểm tra xem có bản ghi nào bị xóa hay không
        return rowsAffected > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}





}
