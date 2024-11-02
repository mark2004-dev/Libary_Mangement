/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;


import entity.Sach;
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
public class SachDAO implements DAOinterfacee<Sach>{

    @Override
    public Sach findByIdAndPassWork(Sach t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Sach findById(Sach t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Sach> getAll() {
        List<Sach> sach = new ArrayList<>();
        
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = jdbcUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "SELECT * FROM sach " ;
            PreparedStatement st = con.prepareStatement(sql);
            

            // Bước 3: thực thi câu lệnh SQL
            System.out.println(sql);
            ResultSet rs = st.executeQuery();

            // Bước 4:
            while (rs.next()) {

                 int id = rs.getInt("id");
                    String tensach = rs.getString("ten_sach");
                   int namxb = rs.getInt("nam_xuat_ban");
                    float gia = rs.getFloat("gia"); 
                Sach s = new Sach( id,tensach, namxb, gia);
                sach.add(s);
            }

            // Bước 5:
            jdbcUtil.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return sach;
    }

    @Override
    public boolean deleteById(int id) {
        String sql = "DELETE FROM sach WHERE id = ?"; // Câu lệnh xóa

    // Khai báo biến để theo dõi số dòng bị xóa
    boolean rowDeleted = false; 

    try (Connection con = jdbcUtil.getConnection(); // Tạo kết nối
         PreparedStatement statement = con.prepareStatement(sql)) { // Tạo PreparedStatement
         
        statement.setInt(1, id); // Gán giá trị ID vào câu lệnh

        // Thực thi câu lệnh xóa
        int rowsAffected = statement.executeUpdate(); 
        rowDeleted = rowsAffected > 0; // Nếu có dòng bị xóa
    } catch (SQLException e) {
        e.printStackTrace(); // In ra lỗi nếu có
    }

    return rowDeleted; 
    }

    
    
    
}
