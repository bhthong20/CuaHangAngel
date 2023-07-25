/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import Utilities.DBConnection;
import entity.ChiTietSanPham;
import entity.HoaDon;
import entity.HoaDonChiTiet;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thong
 */
public class ThongKeRpository {

    public List<HoaDonChiTiet> getListTK() {
        List<HoaDonChiTiet> listTK = new ArrayList<>();
        String sql = "select sp.Ten as'Ten', COUNT(hd.MaHoaDon) as 'hoadonbanra',SUM(SoLuong) as 'slbanra',ctsp.GiaBan,ctsp.GiaNhap,SUM(SoLuong*GiaBan) as'thanhtien'\n"
                + "from HoaDonChiTiet as hdct join HoaDon as hd on hdct.MaHoaDon = hd.MaHoaDon\n"
                + "							join ChiTietSP as ctsp on hdct.MaChiTietSP = ctsp.MaCTSP\n"
                + "							join SanPham as sp on ctsp.MaSP = sp.Ma\n"
                + "where hdct.TrangThai=1\n"
                + "Group by  sp.Ten,ctsp.GiaBan,ctsp.GiaNhap";
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                ChiTietSanPham ctsp = new ChiTietSanPham(rs.getDouble("GiaNhap"), rs.getDouble("GiaBan"));

                listTK.add(new HoaDonChiTiet(ctsp, rs.getInt("slbanra"), rs.getString("Ten"), rs.getInt("hoadonbanra"), rs.getDouble("thanhtien")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BanHangRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listTK;
    }

    public BigDecimal getListDoangThu() {
        BigDecimal max = null;
        String sql = "select Sum(ThanhToan) as 'thanhtien' from HoaDon\n"
                + "where TinhTrang = 1";
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                max = rs.getBigDecimal("thanhtien");
            }
        } catch (SQLException ex) {
            Logger.getLogger(BanHangRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return max;
    }

    public int getListhoaDon() {
        int max = 0;
        String sql = "select COUNT(MaHoaDon)as'hoaDon' from HoaDon\n"
                + "where TinhTrang = 1";
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                max = rs.getInt("hoaDon");
            }
        } catch (SQLException ex) {
            Logger.getLogger(BanHangRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return max;
    }

    public int getLisKhachHang() {
        int max = 0;
        String sql = "select COUNT(IdKH)as'So' from HoaDon\n"
                + "where TinhTrang = 1";
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                max = rs.getInt("So");
            }
        } catch (SQLException ex) {
            Logger.getLogger(BanHangRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return max;
    }

    public List<HoaDonChiTiet> searchSoLuong() {
        List<HoaDonChiTiet> listTK = new ArrayList<>();
        String sql = "select sp.Ten as'Ten', COUNT(hd.MaHoaDon) as 'hoadonbanra',SUM(SoLuong) as 'slbanra',ctsp.GiaBan,ctsp.GiaNhap,SUM(SoLuong*GiaBan) as'thanhtien'\n"
                + "from HoaDonChiTiet as hdct join HoaDon as hd on hdct.MaHoaDon = hd.MaHoaDon\n"
                + "           					join ChiTietSP as ctsp on hdct.MaChiTietSP = ctsp.MaCTSP\n"
                + "							join SanPham as sp on ctsp.MaSP = sp.Ma\n"
                + "where hdct.TrangThai=1 \n"
                + "Group by  sp.Ten,ctsp.GiaBan,ctsp.GiaNhap\n"
                + "order by slbanra desc";
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                ChiTietSanPham ctsp = new ChiTietSanPham(rs.getDouble("GiaNhap"), rs.getDouble("GiaBan"));

                listTK.add(new HoaDonChiTiet(ctsp, rs.getInt("slbanra"), rs.getString("Ten"), rs.getInt("hoadonbanra"), rs.getDouble("thanhtien")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BanHangRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listTK;
    }

    public List<HoaDonChiTiet> searchDoanhThu() {
        List<HoaDonChiTiet> listTK = new ArrayList<>();
        String sql = "select sp.Ten as'Ten', COUNT(hd.MaHoaDon) as 'hoadonbanra',SUM(SoLuong) as 'slbanra',ctsp.GiaBan,ctsp.GiaNhap,SUM(SoLuong*GiaBan) as'thanhtien'\n"
                + "from HoaDonChiTiet as hdct join HoaDon as hd on hdct.MaHoaDon = hd.MaHoaDon\n"
                + "           					join ChiTietSP as ctsp on hdct.MaChiTietSP = ctsp.MaCTSP\n"
                + "							join SanPham as sp on ctsp.MaSP = sp.Ma\n"
                + "where hdct.TrangThai=1\n"
                + "Group by  sp.Ten,ctsp.GiaBan,ctsp.GiaNhap\n"
                + "order by thanhtien desc";
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                ChiTietSanPham ctsp = new ChiTietSanPham(rs.getDouble("GiaNhap"), rs.getDouble("GiaBan"));

                listTK.add(new HoaDonChiTiet(ctsp, rs.getInt("slbanra"), rs.getString("Ten"), rs.getInt("hoadonbanra"), rs.getDouble("thanhtien")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BanHangRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listTK;
    }

    public List<HoaDonChiTiet> searchHoaDon() {
        List<HoaDonChiTiet> listTK = new ArrayList<>();
        String sql = "select sp.Ten as'Ten', COUNT(hd.MaHoaDon) as 'hoadonbanra',SUM(SoLuong) as 'slbanra',ctsp.GiaBan,ctsp.GiaNhap,SUM(SoLuong*GiaBan) as'thanhtien'\n"
                + "from HoaDonChiTiet as hdct join HoaDon as hd on hdct.MaHoaDon = hd.MaHoaDon\n"
                + "           					join ChiTietSP as ctsp on hdct.MaChiTietSP = ctsp.MaCTSP\n"
                + "							join SanPham as sp on ctsp.MaSP = sp.Ma\n"
                + "where hdct.TrangThai=1\n"
                + "Group by  sp.Ten,ctsp.GiaBan,ctsp.GiaNhap\n"
                + "order by hoadonbanra desc";
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                ChiTietSanPham ctsp = new ChiTietSanPham(rs.getDouble("GiaNhap"), rs.getDouble("GiaBan"));

                listTK.add(new HoaDonChiTiet(ctsp, rs.getInt("slbanra"), rs.getString("Ten"), rs.getInt("hoadonbanra"), rs.getDouble("thanhtien")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BanHangRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listTK;
    }

    public List<HoaDonChiTiet> searchTenSP(String tenSP) {
        List<HoaDonChiTiet> listTK = new ArrayList<>();
        String sql = "select sp.Ten as'Ten', COUNT(hd.MaHoaDon) as 'hoadonbanra',SUM(SoLuong) as 'slbanra',ctsp.GiaBan,ctsp.GiaNhap,SUM(SoLuong*GiaBan) as'thanhtien'\n"
                + "from HoaDonChiTiet as hdct join HoaDon as hd on hdct.MaHoaDon = hd.MaHoaDon\n"
                + "           					join ChiTietSP as ctsp on hdct.MaChiTietSP = ctsp.MaCTSP\n"
                + "							join SanPham as sp on ctsp.MaSP = sp.Ma\n"
                + "where hdct.TrangThai=1 and Ten like'" + tenSP + "%'\n"
                + "Group by  sp.Ten,ctsp.GiaBan,ctsp.GiaNhap";
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps;

        try {
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                ChiTietSanPham ctsp = new ChiTietSanPham(rs.getDouble("GiaNhap"), rs.getDouble("GiaBan"));
                listTK.add(new HoaDonChiTiet(ctsp, rs.getInt("slbanra"), rs.getString("Ten"), rs.getInt("hoadonbanra"), rs.getDouble("thanhtien")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BanHangRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listTK;
    }

    public List<HoaDon> bieuDo() {
        List<HoaDon> listHD = new ArrayList<>();
        String sql = "select EOMONTH(NgayThanhToan), SUM(TongTien)\n"
                + "from HoaDon\n"
                + "WHERE TinhTrang = 1\n"
                + "Group by  EOMONTH(NgayThanhToan)";
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps;

        try {
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                listHD.add(new HoaDon(rs.getString(1), rs.getDouble(2)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BanHangRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listHD;
    }
}
