/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import Utilities.DBConnection;
import entity.DangNhap;
import entity.KHToanCuc;
import java.sql.Connection;
import javax.swing.JFrame;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import view.TrangChu;
import view.TrangChu2;

/**
 *
 * @author thong
 */
public class LoginRepository {

    public boolean login(String username, String pass, JFrame frame) {
        boolean ketQua = false;
        String sql = "select UserName, Pass, ChucVu.Ten, NhanVien.TenNhanVien, NhanVien.MaNhanVien \n"
                + "from Account join NhanVien on Account.Id = NhanVien.MatKhau\n"
                + "			join ChucVu on NhanVien.MaCV = ChucVu.Ma\n"
                + "where UserName = ? AND Pass = ?";
        Connection conn = DBConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, username);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                DangNhap dangNhap = new DangNhap(rs.getString("UserName"), rs.getString("Pass"), rs.getString("Ten"), rs.getString("MaNhanVien"), rs.getString("TenNhanVien"));
                KHToanCuc cuc = new KHToanCuc();
                cuc.setMaNVTC(rs.getString("MaNhanVien"));
                cuc.setTenNVTC(rs.getString("TenNhanVien"));
                if (dangNhap.getChucVu().equalsIgnoreCase("Quản lý")) {
                    TrangChu chu = new TrangChu();
                    frame.setVisible(false);
                    chu.setVisible(true);
                } else {
                    TrangChu2 chu2 = new TrangChu2();
                    frame.setVisible(false);
                    chu2.setVisible(true);
                }
                ketQua = true;
            } else {
                ketQua = false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ketQua;

    }
}
