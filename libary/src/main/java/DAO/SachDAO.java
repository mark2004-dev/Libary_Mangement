/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;


import entity.Sach;
import entity.nguoidung;
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
    public Sach findById(int id) {
        Sach ketQua = null;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = jdbcUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "SELECT * FROM sach WHERE id=? ";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);
            

            // Bước 3: thực thi câu lệnh SQL
            System.out.println(sql);
            ResultSet rs = st.executeQuery();

            // Bước 4:
            while (rs.next()) {

                int id1 = rs.getInt("id");
                String tensach = rs.getString("ten_sach");
                int namxb = rs.getInt("nam_xuat_ban");
                double gia = rs.getDouble("gia");
                String tacgia =rs.getString("tac_gia");
                String nhaxb =rs.getString("nha_xuat_ban");
                String theloai =rs.getString("the_loai");
                int soluong = rs.getInt("so_luong");

                ketQua = new Sach(id1, tensach, namxb, gia,tacgia,nhaxb,theloai,soluong);
            }
            jdbcUtil.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ketQua;
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
     public boolean updateBook(Sach sach) {
        String sql = "UPDATE sach SET ten_sach = ?, nam_xuat_ban = ?, gia = ? WHERE id = ?";
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            // Kết nối đến cơ sở dữ liệu
            con = jdbcUtil.getConnection();
            pstmt = con.prepareStatement(sql);

            // Thiết lập giá trị cho các tham số trong câu lệnh SQL
            pstmt.setString(1, sach.getTenSach());
            pstmt.setInt(2, sach.getNamXuatBan());
            pstmt.setDouble(3, sach.getGia());
            pstmt.setInt(4, sach.getId());

            // Thực thi câu lệnh SQL và kiểm tra kết quả
            int rowsAffected = pstmt.executeUpdate();

            // Nếu có ít nhất một dòng được cập nhật, trả về true
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Trả về false nếu có lỗi xảy ra
        } finally {
            // Đảm bảo đóng các tài nguyên
            try {
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
     public boolean save(Sach sach) {
        String sql = "INSERT INTO sach (id, ten_sach, nam_xuat_ban, gia) VALUES (?, ?, ?, ?,?,?,?)";
        try (Connection con = jdbcUtil.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
             
            // Thiết lập các tham số cho PreparedStatement
            pstmt.setInt(1, sach.getId());
            pstmt.setString(2, sach.getTenSach());
            pstmt.setInt(3, sach.getNamXuatBan());
            pstmt.setDouble(4, sach.getGia());
            pstmt.setString(5, sach.getTacgia());
            pstmt.setString(6, sach.getNhaxb());
            pstmt.setString(7, sach.getTheloai());
            
            
            // Thực thi câu lệnh SQL
            int rowsInserted = pstmt.executeUpdate();
            return rowsInserted > 0; // Trả về true nếu có dòng nào được thêm vào
        } catch (SQLException e) {
            e.printStackTrace(); // In ra thông tin lỗi nếu có
            return false; // Trả về false nếu có lỗi
        }
    }
    
    
    // Phương thức xóa sách theo ID
    public boolean delete(int id) {
        Connection con = null;
        PreparedStatement pstmt = null;
        boolean deleted = false;

        try {
            // Kết nối đến cơ sở dữ liệu
            con = jdbcUtil.getConnection();

            // Tạo câu lệnh SQL xóa
            String sql = "DELETE FROM sach WHERE id = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, id);

            // Thực thi câu lệnh SQL
            int rowsAffected = pstmt.executeUpdate();
            deleted = (rowsAffected > 0); // Nếu có ít nhất 1 dòng bị ảnh hưởng thì xóa thành công
        } catch (SQLException e) {
            e.printStackTrace(); // In ra lỗi cho quá trình gỡ lỗi
        } finally {
            // Đóng các tài nguyên
            jdbcUtil.closeConnection(con);
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return deleted; // Trả về true nếu xóa thành công, false nếu không
    }
public List<Sach> findByName(String name) {
    List<Sach> sachList = new ArrayList<>();
    Connection con = jdbcUtil.getConnection();

    try {
        String sql = "SELECT * FROM sach WHERE ten_sach LIKE ?"; // Truy vấn tìm kiếm theo tên sách
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, "%" + name + "%"); // Sử dụng LIKE để tìm kiếm không phân biệt chữ hoa chữ thường
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            int id = rs.getInt("id");
            String tenSach = rs.getString("ten_sach");
            int namXuatBan = rs.getInt("nam_xuat_ban");
            double gia = rs.getDouble("gia");

            Sach sach = new Sach(id, tenSach, namXuatBan, gia);
            sachList.add(sach); // Thêm sách vào danh sách kết quả
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        jdbcUtil.closeConnection(con); // Đóng kết nối
    }
    return sachList; // Trả về danh sách sách tìm được
}

    
    
    
}
