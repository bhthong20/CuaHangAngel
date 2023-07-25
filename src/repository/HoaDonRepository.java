/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import Utilities.DBConnection;
import entity.ChiTietSanPham;
import entity.HoaDon;
import entity.HoaDonChiTiet;
import entity.KhachHang;
import entity.NhanVien;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thong
 */
public class HoaDonRepository {
    
    public List<HoaDon> getListHD() {
        List<HoaDon> listHD = new ArrayList<>();
        String sql = "select MaHoaDon, KhachHang.MaKhachHang as 'maKH',KhachHang.TenKhachHang as'TenKH',NhanVien.MaNhanVien as'maNV', NhanVien.TenNhanVien as'tenNV',NgayTao,NgayThanhToan,TongTien,ThanhToan,TienThua,PhuongThucThanhToan,TinhTrang,GhiChu\n"
                + "from HoaDon join NhanVien on HoaDon.IdNV = NhanVien.MaNhanVien\n"
                + "			join KhachHang on HoaDon.IdKH = KhachHang.MaKhachHang";
        Connection conn = DBConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhachHang hang = new KhachHang(rs.getString("maKH"), rs.getString("TenKH"));
                NhanVien nhanVien = new NhanVien(rs.getString("maNV"), rs.getString("tenNV"));
                listHD.add(new HoaDon(rs.getLong("MaHoaDon"), hang, nhanVien, rs.getString("NgayTao"), rs.getString("NgayThanhToan"), rs.getInt("TinhTrang"), rs.getDouble("TongTien"), rs.getDouble("TienThua"), rs.getDouble("ThanhToan"), rs.getString("PhuongThucThanhToan"),rs.getString("GhiChu")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listHD;
    }
    
    public List<HoaDon> searchListHD(Long maHD) {
        List<HoaDon> listHD = new ArrayList<>();
        String sql = "select MaHoaDon, KhachHang.MaKhachHang as 'maKH',KhachHang.TenKhachHang as'TenKH',NhanVien.MaNhanVien as'maNV', NhanVien.TenNhanVien as'tenNV',NgayTao,NgayThanhToan,TongTien,ThanhToan,TienThua,PhuongThucThanhToan,TinhTrang,GhiChu\n"
                + "from HoaDon join NhanVien on HoaDon.IdNV = NhanVien.MaNhanVien\n"
                + "			join KhachHang on HoaDon.IdKH = KhachHang.MaKhachHang\n"
                + "where MaHoaDon = ?";
        Connection conn = DBConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, maHD);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhachHang hang = new KhachHang(rs.getString("maKH"), rs.getString("TenKH"));
                NhanVien nhanVien = new NhanVien(rs.getString("maNV"), rs.getString("tenNV"));
                listHD.add(new HoaDon(rs.getLong("MaHoaDon"), hang, nhanVien, rs.getString("NgayTao"), rs.getString("NgayThanhToan"), rs.getInt("TinhTrang"), rs.getDouble("TongTien"), rs.getDouble("TienThua"), rs.getDouble("ThanhToan"), rs.getString("PhuongThucThanhToan"),rs.getString("GhiChu")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listHD;
    }
    
    public List<HoaDon> searchTinhTrang(int tinhTrang) {
        List<HoaDon> listHD = new ArrayList<>();
        String sql = "select MaHoaDon, KhachHang.MaKhachHang as 'maKH',KhachHang.TenKhachHang as'TenKH',NhanVien.MaNhanVien as'maNV', NhanVien.TenNhanVien as'tenNV',NgayTao,NgayThanhToan,TongTien,ThanhToan,TienThua,PhuongThucThanhToan,TinhTrang,GhiChu  \n"
                + "from HoaDon join NhanVien on HoaDon.IdNV = NhanVien.MaNhanVien\n"
                + "			join KhachHang on HoaDon.IdKH = KhachHang.MaKhachHang\n"
                + "where TinhTrang = ?";
        Connection conn = DBConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, tinhTrang);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhachHang hang = new KhachHang(rs.getString("maKH"), rs.getString("TenKH"));
                NhanVien nhanVien = new NhanVien(rs.getString("maNV"), rs.getString("tenNV"));
                listHD.add(new HoaDon(rs.getLong("MaHoaDon"), hang, nhanVien, rs.getString("NgayTao"), rs.getString("NgayThanhToan"), rs.getInt("TinhTrang"), rs.getDouble("TongTien"), rs.getDouble("TienThua"), rs.getDouble("ThanhToan"), rs.getString("PhuongThucThanhToan"),rs.getString("GhiChu")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listHD;
    }
    
    public List<HoaDon> searchNgay(String ngayTao, String ngaythanhToan) {
        List<HoaDon> listHD = new ArrayList<>();
        String sql = "select MaHoaDon, KhachHang.MaKhachHang as 'maKH',KhachHang.TenKhachHang as'TenKH',NhanVien.MaNhanVien as'maNV', NhanVien.TenNhanVien as'tenNV',NgayTao,NgayThanhToan,TongTien,ThanhToan,TienThua,PhuongThucThanhToan,TinhTrang,GhiChu  \n"
                + "from HoaDon join NhanVien on HoaDon.IdNV = NhanVien.MaNhanVien\n"
                + "			join KhachHang on HoaDon.IdKH = KhachHang.MaKhachHang\n"
                + "where  NgayTao between ? and ? ";
        Connection conn = DBConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ngayTao);
            ps.setString(2, ngaythanhToan);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhachHang hang = new KhachHang(rs.getString("maKH"), rs.getString("TenKH"));
                NhanVien nhanVien = new NhanVien(rs.getString("maNV"), rs.getString("tenNV"));
                listHD.add(new HoaDon(rs.getLong("MaHoaDon"), hang, nhanVien, rs.getString("NgayTao"), rs.getString("NgayThanhToan"), rs.getInt("TinhTrang"), rs.getDouble("TongTien"), rs.getDouble("TienThua"), rs.getDouble("ThanhToan"), rs.getString("PhuongThucThanhToan"),rs.getString("GhiChu")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listHD;
    }
    
    public List<HoaDonChiTiet> listHDCTGetHD(Long maHoaD) {
        List<HoaDonChiTiet> chiTiets = new ArrayList<>();
        String sql = "select MaHDCT,hdct.MaHoaDon,MaChiTietSP,sp.Ten,SoLuong,DonGia,sum(SoLuong*DonGia) as thanhtien\n"
                + "from HoaDonChiTiet as hdct join HoaDon as hd on hdct.MaHoaDon = hd.MaHoaDon\n"
                + "						join ChiTietSP as ctsp on hdct.MaChiTietSP = ctsp.MaCTSP\n"
                + "						join SanPham as sp on ctsp.MaSP = sp.Ma\n"
                + "where hdct.MaHoaDon = ?\n"
                + "group by MaHDCT,hdct.MaHoaDon,MaChiTietSP,SoLuong,DonGia,sp.Ten";
        Connection conn = DBConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, maHoaD);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon don = new HoaDon(rs.getLong("MaHoaDon"));
                ChiTietSanPham chiTietSanPham = new ChiTietSanPham(rs.getString("MaChiTietSP"));
                chiTiets.add(new HoaDonChiTiet(rs.getLong("MaHDCT"), don, chiTietSanPham, rs.getInt("SoLuong"), rs.getDouble("DonGia"), rs.getString("Ten"), rs.getDouble("thanhtien")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return chiTiets;
    }
}
