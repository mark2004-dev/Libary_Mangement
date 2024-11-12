package DAO;

import entity.Sach;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import view.jdbcUtil;

public class  SachDAO implements DAOinterfacee<Sach> {

    @Override
    public Sach findById(int id) {
        Sach ketQua = null;
        String sql = "SELECT * FROM sach WHERE id=?";

        try (Connection con = jdbcUtil.getConnection();
             PreparedStatement st = con.prepareStatement(sql)) {
            
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                int id1 = rs.getInt("id");
                String tensach = rs.getString("ten_sach");
                int namxb = rs.getInt("nam_xuat_ban");
                double gia = rs.getDouble("gia");
                String tacgia = rs.getString("tac_gia");
                String nhaxb = rs.getString("nha_xuat_ban");
                String theloai = rs.getString("the_loai");
                int soluong = rs.getInt("so_luong");
                 byte[] anh = rs.getBytes("anh");

                ketQua = new Sach(id1, tensach, namxb, gia, tacgia, nhaxb, theloai, soluong,anh);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public List<Sach> getAll() {
        List<Sach> sachList = new ArrayList<>();
        String sql = "SELECT * FROM sach";

        try (Connection con = jdbcUtil.getConnection();
             PreparedStatement st = con.prepareStatement(sql);
             ResultSet rs = st.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String tensach = rs.getString("ten_sach");
                int namxb = rs.getInt("nam_xuat_ban");
                float gia = rs.getFloat("gia");
                int soluong =rs.getInt("so_luong");
                
                Sach s = new Sach(id, tensach, namxb, gia,soluong);
                sachList.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sachList;
    }

    @Override
    public boolean deleteById(int id) {
        String sql = "DELETE FROM sach WHERE id = ?";
        boolean rowDeleted = false;

        try (Connection con = jdbcUtil.getConnection();
             PreparedStatement statement = con.prepareStatement(sql)) {

            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDeleted;
    }

    public boolean updateBook(Sach sach) {
    String sql = "UPDATE sach SET ten_sach = ?, nam_xuat_ban = ?, gia = ?, so_luong = ? WHERE id = ?";

    try (Connection con = jdbcUtil.getConnection();
         PreparedStatement pstmt = con.prepareStatement(sql)) {

        // Cài đặt giá trị cho các tham số trong câu lệnh SQL
        pstmt.setString(1, sach.getTenSach()); // Set tên sách
        pstmt.setInt(2, sach.getNamXuatBan()); // Set năm xuất bản
        pstmt.setDouble(3, sach.getGia()); // Set giá
        pstmt.setInt(4, sach.getSoluong()); // Set số lượng
        pstmt.setInt(5, sach.getId()); // Set ID sách (mặc dù đã có ID nhưng vẫn cần cho WHERE)

        // Thực hiện câu lệnh SQL và trả về kết quả (có cập nhật thành công hay không)
        return pstmt.executeUpdate() > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}


    public boolean save(Sach sach) {
        String sql = "INSERT INTO sach (id, ten_sach, nam_xuat_ban, gia, tac_gia, nha_xuat_ban, the_loai, so_luong) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = jdbcUtil.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setInt(1, sach.getId());
            pstmt.setString(2, sach.getTenSach());
            pstmt.setInt(3, sach.getNamXuatBan());
            pstmt.setDouble(4, sach.getGia());
            pstmt.setString(5, sach.getTacgia());
            pstmt.setString(6, sach.getNhaxb());
            pstmt.setString(7, sach.getTheloai());
            pstmt.setInt(8, sach.getSoluong());

            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Sach> findByAttributes(Integer id, String ten, Integer namXuatBan, Double gia) {
    List<Sach> sachList = new ArrayList<>();
    StringBuilder sql = new StringBuilder("SELECT * FROM sach WHERE 1=1");

    // Thêm điều kiện tìm kiếm vào câu truy vấn nếu tham số không null
    if (id != null) {
        sql.append(" AND id = ?");
    }
    if (ten != null) {
        sql.append(" AND ten_sach LIKE ?");
    }
    if (namXuatBan != null) {
        sql.append(" AND nam_xuat_ban = ?");
    }
    if (gia != null) {
        sql.append(" AND gia = ?");
    }

    try (Connection con = jdbcUtil.getConnection();
         PreparedStatement stmt = con.prepareStatement(sql.toString())) {

        int index = 1;

        // Thiết lập giá trị cho các tham số trong câu truy vấn
        if (id != null) {
            stmt.setInt(index++, id);
        }
        if (ten != null) {
            stmt.setString(index++, "%" + ten + "%");
        }
        if (namXuatBan != null) {
            stmt.setInt(index++, namXuatBan);
        }
        if (gia != null) {
            stmt.setDouble(index++, gia);
        }

        System.out.println("SQL Query: " + stmt.toString()); // In ra câu truy vấn để kiểm tra

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            int bookId = rs.getInt("id");
            String bookName = rs.getString("ten_sach");
            int bookNamXuatBan = rs.getInt("nam_xuat_ban");
            double bookGia = rs.getDouble("gia");

            // Giả định lớp Sach có constructor nhận các tham số này
            Sach sach = new Sach(bookId, bookName, bookNamXuatBan, bookGia);
            sachList.add(sach);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return sachList;
}






    @Override
    public Sach findByIdAndPassWork(Sach t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public boolean delete(int id) {
         String sql = "DELETE FROM sach WHERE id = ?";

    try (Connection con = jdbcUtil.getConnection();
         PreparedStatement pstmt = con.prepareStatement(sql)) {

        pstmt.setInt(1, id);

        return pstmt.executeUpdate() > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
    }
    
    public int getMaxId() {
    String sql = "SELECT MAX(id) FROM sach";
    try (Connection con = jdbcUtil.getConnection();
         PreparedStatement stmt = con.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        if (rs.next()) {
            return rs.getInt(1); // Lấy ID lớn nhất
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return 0; // Nếu không có sách nào, trả về 0
}   
}
