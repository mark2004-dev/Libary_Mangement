/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;


import entity.nguoidung;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static view.PasswordUtils.hashPassword;
import view.jdbcUtil;

/**
 *
 * @author Admin
 */
public class nguoidungDAO implements DAOinterfacee<nguoidung> {

    @Override
    public nguoidung findByIdAndPassWork(nguoidung t) {
        nguoidung ketQua = null;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = jdbcUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "SELECT * FROM nguoidung WHERE tentk=? and matkhau=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getTentk());
            String hashedPassword = hashPassword(t.getMatkhau());
             st.setString(2, hashedPassword);
            // Bước 3: thực thi câu lệnh SQL
         
            ResultSet rs = st.executeQuery();

            // Bước 4:
            while (rs.next()) {

                String tenDangNhap = rs.getString("tentk");
                String matKhau = rs.getString("matkhau");
                String email = rs.getString("email");
                String sdt = rs.getString("sodienthoai");

                ketQua = new nguoidung(tenDangNhap, email, matKhau, sdt);
            }

            // Bước 5:
            jdbcUtil.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return ketQua;
    }

  
    public nguoidung findByten(String tentk) {
        nguoidung ketQua = null;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = jdbcUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "SELECT * FROM nguoidung WHERE tentk=? ";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1,tentk);
            

            // Bước 3: thực thi câu lệnh SQL
            System.out.println(sql);
            ResultSet rs = st.executeQuery();

            // Bước 4:
            while (rs.next()) {

                String tenDangNhap = rs.getString("tentk");
                String matKhau = rs.getString("matkhau");
                String email = rs.getString("email");
                String sdt = rs.getString("sodienthoai");

                ketQua = new nguoidung(tenDangNhap, email, matKhau, sdt);
            }
            jdbcUtil.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public List<nguoidung> getAll() {
    List<nguoidung> danhSachNguoiDung = new ArrayList<>();
    try {
        // Bước 1: Tạo kết nối đến CSDL
        Connection con = jdbcUtil.getConnection();

        // Bước 2: Tạo câu lệnh SQL để truy vấn tất cả người dùng
        String sql = "SELECT * FROM nguoidung";
        PreparedStatement st = con.prepareStatement(sql);

        // Bước 3: Thực thi câu lệnh SQL
        System.out.println(sql);
        ResultSet rs = st.executeQuery();

        // Bước 4: Lấy dữ liệu từ ResultSet và thêm vào danh sách
        while (rs.next()) {
            int id= rs.getInt("manguoidung");
            String tenDangNhap = rs.getString("tentk");
            String matKhau = rs.getString("matkhau");
            String email = rs.getString("email");
            String sdt = rs.getString("sodienthoai");

            nguoidung nguoiDung = new nguoidung(id,tenDangNhap, email, matKhau, sdt);
            danhSachNguoiDung.add(nguoiDung);
        }

        // Đóng kết nối
        jdbcUtil.closeConnection(con);
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return danhSachNguoiDung;
}
    public boolean update(nguoidung nguoiDung) {
    boolean ketQua = false;
    try {
        // Bước 1: Tạo kết nối đến CSDL
        Connection con = jdbcUtil.getConnection();

        // Bước 2: Tạo câu lệnh SQL để cập nhật thông tin người dùng
        String sql = "UPDATE nguoidung SET tentk=?, matkhau=?, email=?, sodienthoai=? WHERE manguoidung=?";
        PreparedStatement st = con.prepareStatement(sql);

        // Bước 3: Thiết lập giá trị cho các tham số trong câu lệnh SQL
        st.setString(1, nguoiDung.getTentk());
        st.setString(2, nguoiDung.getMatkhau());
        st.setString(3, nguoiDung.getEmail());
        st.setString(4, nguoiDung.getSodienthoai());
        st.setInt(5,nguoiDung.getManguoidung());

        // Bước 4: Thực thi câu lệnh SQL
        int rowsAffected = st.executeUpdate();

        // Kiểm tra nếu có bản ghi nào được cập nhật
        if (rowsAffected > 0) {
            ketQua = true;
        }

        // Đóng kết nối
        jdbcUtil.closeConnection(con);
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return ketQua;
}


    
        
    // Trả về true nếu xóa thành công, ngược lại false
    public boolean delete(int manguoidung) {
    boolean ketQua = false;
    Connection con = null;
    PreparedStatement st = null;
    
    try {
        // Bước 1: Tạo kết nối đến CSDL
        con = jdbcUtil.getConnection();

        // Bước 2: Tạo câu lệnh SQL để xóa người dùng theo manguoidung
        String sql = "DELETE FROM nguoidung WHERE manguoidung = ?";
        st = con.prepareStatement(sql);

        // Bước 3: Thiết lập tham số cho câu lệnh SQL
        st.setInt(1, manguoidung);

        // Bước 4: Thực thi câu lệnh SQL
        int rowsAffected = st.executeUpdate();

        // Kiểm tra nếu có bản ghi nào bị xóa
        if (rowsAffected > 0) {
            ketQua = true; // Thành công nếu xóa được ít nhất một bản ghi
        }

    } catch (SQLException e) {
        e.printStackTrace(); // In lỗi nếu có
    } finally {
        // Đóng kết nối sau khi hoàn thành
        
        jdbcUtil.closeConnection(con);
    }
    return ketQua; // Trả về true nếu xóa thành công, false nếu không
}

    
    public boolean save(nguoidung nguoiDung) {
    boolean ketQua = false;
    Connection con = null;
    PreparedStatement st = null;
    try {
        // Bước 1: Tạo kết nối đến CSDL
        con = jdbcUtil.getConnection();

        // Bước 2: Kiểm tra xem người dùng đã tồn tại chưa
        String checkExistSql = "SELECT COUNT(*) FROM nguoidung WHERE tentk=?";
        st = con.prepareStatement(checkExistSql);
        st.setString(1, nguoiDung.getTentk());

        // Thực thi câu lệnh và lấy kết quả
        ResultSet rs = st.executeQuery();
        boolean isExist = false;
        if (rs.next()) {
            isExist = rs.getInt(1) > 0;
        }

        // Bước 3: Thêm mới hoặc cập nhật người dùng
        if (isExist) {
            // Nếu người dùng đã tồn tại, thực hiện cập nhật
            String updateSql = "UPDATE nguoidung SET matkhau=?, email=?, sodienthoai=? WHERE tentk=?";
            st = con.prepareStatement(updateSql);
            st.setString(1, nguoiDung.getMatkhau());
            st.setString(2, nguoiDung.getEmail());
            st.setString(3, nguoiDung.getSodienthoai());
            st.setString(4, nguoiDung.getTentk());

            // Thực thi câu lệnh cập nhật
            int rowsAffected = st.executeUpdate();
            ketQua = rowsAffected > 0;  // Nếu có dòng được cập nhật, trả về true
        } else {
            // Nếu người dùng chưa tồn tại, thực hiện thêm mới
            String insertSql = "INSERT INTO nguoidung (tentk, matkhau, email, sodienthoai) VALUES (?, ?, ?, ?)";
            st = con.prepareStatement(insertSql);
            st.setString(1, nguoiDung.getTentk());
            st.setString(2, nguoiDung.getMatkhau());
            st.setString(3, nguoiDung.getEmail());
            st.setString(4, nguoiDung.getSodienthoai());

            // Thực thi câu lệnh thêm mới
            int rowsAffected = st.executeUpdate();
            ketQua = rowsAffected > 0;  // Nếu có dòng được thêm mới, trả về true
        }
        
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        // Đóng kết nối và statement
        jdbcUtil.closeConnection(con);
    }
    return ketQua;
}

    
    @Override
    public boolean deleteById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public nguoidung findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

    
   

