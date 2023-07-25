/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import Utilities.DBConnection;
import entity.ChucVu;
import entity.DangNhap;
import entity.NhanVien;

import java.sql.Connection;
import java.sql.Statement;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class NhanVienRepository {

    List<ChucVu> listCV = new ArrayList<>();

    public List<NhanVien> getAllNhanVien() {
        List<NhanVien> listNV = new ArrayList<>();
        Connection conn = DBConnection.getConnection();
        String query = "SELECT [MaNhanVien]\n"
                + "      ,[TenNhanVien]\n"
                + "      ,[GioiTinh]\n"
                + "      ,[NgaySinh]\n"
                + "      ,[DiaChi]\n"
                + "      ,[Sdt]\n"
                + "      ,[Email]\n"
                + "      ,Account.Pass\n"
                + "	  ,Account.UserName\n"
                + "	  ,ChucVu.Ma\n"
                + "      ,ChucVu.Ten\n"
                + "      ,TrangThai\n"
                + " FROM NhanVien JOIN ChucVu ON NhanVien.MaCV = ChucVu.Ma\n"
                + "\n"
                + " JOIN Account ON NhanVien.MatKhau = Account.Id";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DangNhap dn = new DangNhap(rs.getString(9),rs.getString(8));
                ChucVu cv = new ChucVu(rs.getInt(10), rs.getString(11));

                listNV.add(new NhanVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), dn, cv, rs.getInt(12)));
            }

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return listNV;
    }

    public List<ChucVu> getCV() {

        listCV = new ArrayList<>();
        Connection conn = DBConnection.getConnection();
        String select = "SELECT * FROM ChucVu";
        try {
            PreparedStatement ps = conn.prepareStatement(select);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                listCV.add(new ChucVu(rs.getInt(1), rs.getString(2)));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listCV;
    }

    public boolean insert(NhanVien nv) {
        int check = 0;
        Connection conn = DBConnection.getConnection();
        String insert = "INSERT INTO [dbo].[NhanVien]\n"
                + "           ([MaNhanVien]\n"
                + "           ,[TenNhanVien]\n"
                + "           ,[GioiTinh]\n"
                + "           ,[NgaySinh]\n"
                + "           ,[DiaChi]\n"
                + "           ,[Sdt]\n"
                + "           ,[Email]\n"
                + "           ,[MatKhau]\n"
                + "           ,[MaCV]\n"
                + "           ,[TrangThai])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(insert);

            ps.setObject(1, nv.getMaNV());
            ps.setObject(2, nv.getTenNV());
            ps.setObject(3, nv.getGioiTinh());
            ps.setObject(4, nv.getNgaySinh());

            ps.setObject(5, nv.getDiaChi());
            ps.setObject(6, nv.getSdt());
            ps.setObject(7, nv.getEmail());
            ps.setObject(8, nv.getDangNhap().getId());
            ps.setObject(9, nv.getChucVu().getMaCV());

            ps.setObject(10, nv.getTrangThai());
            check = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public String update(NhanVien nv, String ma) {
        Connection conn = DBConnection.getConnection();
        String update = "UPDATE [dbo].[NhanVien]\n"
                + "   SET [MaNhanVien] = ? \n"
                + "      ,[TenNhanVien] =? \n"
                + "      ,[GioiTinh] = ? \n"
                + "      ,[NgaySinh] = ? \n"
                + "      ,[DiaChi] = ? \n"
                + "      ,[Sdt] = ? \n"
                + "      ,[Email] = ? \n"
                + "      ,[MatKhau] = ? \n"
                + "      ,[MaCV] = ? \n"
                + "      ,[TrangThai] = ? \n"
                + " WHERE MaNhanVien =?";
        try {
            PreparedStatement ps = conn.prepareStatement(update);

            ps.setObject(1, nv.getMaNV());
            ps.setObject(2, nv.getTenNV());
            ps.setObject(3, nv.getGioiTinh());
            ps.setString(4, nv.getNgaySinh());

            ps.setObject(5, nv.getDiaChi());
            ps.setObject(6, nv.getSdt());
            ps.setObject(7, nv.getEmail());
            ps.setObject(8, nv.getDangNhap().getId());
            ps.setObject(9, nv.getChucVu().getMaCV());

            ps.setObject(10, nv.getTrangThai());
            ps.setObject(11, ma);
            ps.executeUpdate();
            return "Sửa thành công";
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienRepository.class.getName()).log(Level.SEVERE, null, ex);
            return "Sủa không thành công";
        }
    }

    public void delete(String ma) throws SQLException {
        Connection conn = DBConnection.getConnection();
        String update = "DELETE FROM NhanVien  WHERE MaNhanVien = ?";
        PreparedStatement ps = conn.prepareStatement(update);
        ps.setObject(1, ma);
        ps.executeUpdate();
    }

    public NhanVien getOne(String maNhanVien) {
        NhanVien nv = null;
        Connection conn = DBConnection.getConnection();
        String query = "SELECT [MaNhanVien]\n"
                + "      ,[TenNhanVien]\n"
                + "      ,[GioiTinh]\n"
                + "      ,[NgaySinh]\n"
                + "      ,[DiaChi]\n"
                + "      ,[Sdt]\n"
                + "      ,[Email]\n"
                + "      ,c.Pass\n"
                + "	  ,c.UserName\n"
                + "	  ,b.Ma\n"
                + "      ,b.Ten\n"
                + "      ,TrangThai\n"
                + " FROM NhanVien a JOIN ChucVu b ON a.MaCV = b.Ma\n"
                + "\n"
                + "   JOIN Account c ON a.MatKhau = c.Id  "
                + "   WHERE a.MaNhanVien =?";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setObject(1, maNhanVien);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DangNhap dn = new DangNhap(rs.getString(8),rs.getString(9));
                ChucVu cv = new ChucVu(rs.getInt(10), rs.getString(11));
                nv = new NhanVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), dn, cv, rs.getInt(12));
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return nv;
    }

    public static void main(String[] args) {
        System.out.println(new NhanVienRepository().getOne("D01"));
    }

}
