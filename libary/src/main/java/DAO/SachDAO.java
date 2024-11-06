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
                
                Sach s = new Sach(id, tensach, namxb, gia);
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
        String sql = "UPDATE sach SET ten_sach = ?, nam_xuat_ban = ?, gia = ? WHERE id = ?";

        try (Connection con = jdbcUtil.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setString(1, sach.getTenSach());
            pstmt.setInt(2, sach.getNamXuatBan());
            pstmt.setDouble(3, sach.getGia());
            pstmt.setInt(4, sach.getId());

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

    public List<Sach> findByName(String name) {
        List<Sach> sachList = new ArrayList<>();
        String sql = "SELECT * FROM sach WHERE ten_sach LIKE ?";

        try (Connection con = jdbcUtil.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, "%" + name + "%");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String tenSach = rs.getString("ten_sach");
                int namXuatBan = rs.getInt("nam_xuat_ban");
                double gia = rs.getDouble("gia");

                Sach sach = new Sach(id, tenSach, namXuatBan, gia);
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
