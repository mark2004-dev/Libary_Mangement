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
                    String trangThai = rs.getString("trang_thai");
                    int soLuong = rs.getInt("so_luong_muon");
                    
                NguoiMuon s = new NguoiMuon(id,ten,ngayMuon, ngayTra, trangThai,soLuong);
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
}
