/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import Utilities.DBConnection;
import entity.ChatLieu;
import entity.ChiTietSanPham;
import entity.DongSP;
import entity.HoaDon;
import entity.HoaDonChiTiet;
import entity.KHToanCuc;
import entity.KhachHang;
import entity.KichThuoc;
import entity.MauSac;
import entity.NhaSanXuat;
import entity.NhanVien;
import entity.SanPham;
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
public class BanHangRepository {

    public List<KhachHang> getListKHHD() throws SQLException {
        List<KhachHang> listKH = new ArrayList<>();
        String sql = "SELECT * FROM KhachHang";
        Connection conn = DBConnection.getConnection();

        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            listKH.add(new KhachHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getBoolean(6), rs.getInt(7)));
        }
        return listKH;
    }

    public List<HoaDon> getListHDTT() {
        List<HoaDon> listHD = new ArrayList<>();
        String sql = "Select MaHoaDon, NgayTao,NhanVien.MaNhanVien,NhanVien.TenNhanVien, KhachHang.MaKhachHang, KhachHang.TenKhachHang \n"
                + "from HoaDon join NhanVien on HoaDon.IdNV = NhanVien.MaNhanVien\n"
                + "			join KhachHang on HoaDon.IdKH = KhachHang.MaKhachHang\n"
                + "where TinhTrang = 2";
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps;
        KHToanCuc cuc = new KHToanCuc();

        try {
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                NhanVien nhanVien = new NhanVien(rs.getString(3), rs.getString(4));
                KhachHang khachHang = new KhachHang(rs.getString(5), rs.getString(6));
                listHD.add(new HoaDon(rs.getLong(1), khachHang, nhanVien, rs.getString(2)));
                cuc.setMaHDa(rs.getString("MaHoaDon"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(BanHangRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listHD;
    }

    public void addHDTT(HoaDon don) throws SQLException {
        String sql = "Insert into HoaDon(NgayTao,IdNV,IdKH,TinhTrang) values(?,?,?,2)";
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, don.getNgayTao());
        ps.setString(2, don.getManhanVien().getMaNV());
        ps.setString(3, don.getMakhachHang().getMaKH());
        ps.executeUpdate();
    }

    public void updateHDTT(HoaDon don) throws SQLException {
        String sql = "Update HoaDon set NgayTao=? ,IdNV= ?,IdKH=?, TingTrang= 2 where MaHoaDon =?";
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, don.getNgayTao());
        ps.setString(2, don.getManhanVien().getMaNV());
        ps.setString(3, don.getMakhachHang().getMaKH());
        ps.setLong(4, don.getMaHD());
        ps.executeUpdate();
    }

    public void editHDTT(HoaDon don) throws SQLException {
        String sql = "Update HoaDon set IdKH=?, IdNV = ?  , NgayThanhToan = ? , TinhTrang = ?  , TongTien = ? , TienThua = ?, PhuongThucThanhToan = ? ,ThanhToan=?,GhiChu = ?  where MaHoaDon = ?";
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, don.getMakhachHang().getMaKH());
        ps.setString(2, don.getManhanVien().getMaNV());
        ps.setString(3, don.getNgayThanhToan());
        ps.setInt(4, don.getTinhTrang());
        ps.setDouble(5, don.getTongTien());
        ps.setDouble(6, don.getTienThua());
        ps.setString(7, don.getPhuongThucThanhToan());
        ps.setDouble(8, don.getThanhToan());
        ps.setString(9, don.getGhiChu());
        ps.setLong(10, don.getMaHD());
        ps.executeUpdate();
    }

    public void editHDCTTT(HoaDonChiTiet chiTiet) throws SQLException {
        String sql = "update HoaDonChiTiet set TrangThai = 1 where MaHoaDon =?";
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setLong(1, chiTiet.getMaHDCT().getMaHD());
        ps.executeUpdate();
    }

    public void deleteHD(Long maHDTT) throws SQLException {
        String sql = "update HoaDon set TinhTrang = 0 where MaHoaDon = ?";
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setLong(1, maHDTT);
        ps.executeUpdate();
    }

    public void deleteHDCT(Long maHDTT) throws SQLException {
        String sql = "update HoaDonChiTiet set TrangThai = 2 where MaHoaDon = ?";
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setLong(1, maHDTT);
        ps.executeUpdate();
    }

    public List<ChiTietSanPham> getListCTSPTT() {
        List<ChiTietSanPham> listCTSP = new ArrayList<>();
        String sql = "select  MaCTSP, SanPham.Ten,NSX.Ten,DongSP.Ten,ChatLieu.Ten,KichThuoc.Ten,MauSac.Ten,SoLuongTon,GiaBan,GiaTriGiamToiDa\n"
                + "                from ChiTietSP join SanPham on SanPham.Ma = ChiTietSP.MaSP\n"
                + "               				join NSX ON ChiTietSP.MaNsx = NSX.Ma\n"
                + "                			join DongSP ON ChiTietSP.MaDongSP = DongSP.Ma\n"
                + "                			join ChatLieu ON ChiTietSP.MaChatLieu = ChatLieu.Ma\n"
                + "                			join KichThuoc ON ChiTietSP.MaSize = KichThuoc.Ma\n"
                + "                			join MauSac ON ChiTietSP.MaMauSac = MauSac.Ma\n"
                + "							join PhieuGiamGia on PhieuGiamGia.MaSanPham = ChiTietSP.MaCTSP";
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                SanPham pham = new SanPham(rs.getString(2));
                NhaSanXuat nsx1 = new NhaSanXuat(rs.getString(3));
                DongSP dongSP1 = new DongSP(rs.getString(4));
                ChatLieu chatLieu1 = new ChatLieu(rs.getString(5));
                KichThuoc kichThuoc1 = new KichThuoc(rs.getString(6));
                MauSac mauSac1 = new MauSac(rs.getString(7));
                listCTSP.add(new ChiTietSanPham(rs.getString(1), pham, nsx1, mauSac1, dongSP1, chatLieu1, kichThuoc1, rs.getInt(8), rs.getDouble(9), rs.getDouble(10)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BanHangRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listCTSP;
    }

    public void updateCTSP(String maCTSP, int soluongHDC) throws SQLException {
        String sql = "update ChiTietSP set SoLuongTon = (SoLuongTon - ?) where MaCTSP = ?";
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, soluongHDC);
        ps.setString(2, maCTSP);
        ps.executeUpdate();
    }

    public void updateCTSPfromHDCT(String maCTSP, Long maHdCT) throws SQLException {
        String sql = "Update ChiTietSP  set SoLuongTon = SoLuongTon +(select SoLuong from HoaDonChiTiet where MaHDCT = ?) where MaCTSP = ? ";
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setLong(1, maHdCT);
        ps.setString(2, maCTSP);
        ps.executeUpdate();
    }
    public void updateCTSPfromHD(String maCTSP, Long maHd) throws SQLException {
        String sql = "Update ChiTietSP  set SoLuongTon = SoLuongTon +(select SoLuong from HoaDonChiTiet where MaHoaDon = ?) where MaCTSP = ? ";
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setLong(1, maHd);
        ps.setString(2, maCTSP);
        ps.executeUpdate();
    }

    public List<HoaDonChiTiet> getListHDCTTT(Long maHDtt) {
        List<HoaDonChiTiet> listHDCT = new ArrayList<>();
        String sql = "select hdct.MaHDCT ,ctsp.MaCTSP, sp.Ten,hdct.SoLuong,hdct.DonGia \n"
                + "from HoaDonChiTiet as hdct join HoaDon as hd on hdct.MaHoaDon = hd.MaHoaDon\n"
                + "							join ChiTietSP as ctsp on hdct.MaChiTietSP = ctsp.MaCTSP\n"
                + "							join SanPham as sp on ctsp.MaSP = sp.Ma\n"
                + "where hd.MaHoaDon=? and TrangThai = 0 ";
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(sql);
            ps.setLong(1, maHDtt);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ChiTietSanPham ctsp = new ChiTietSanPham(rs.getString("MaCTSP"));
                listHDCT.add(new HoaDonChiTiet(rs.getLong("MaHDCT"), ctsp, rs.getInt("SoLuong"), rs.getDouble("DonGia"), rs.getString("Ten")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BanHangRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listHDCT;
    }

    public void addHDCTTT(HoaDonChiTiet hdct) throws SQLException {
        String sql = "Insert into HoaDonChiTiet(MaHoaDon,MaChiTietSP,SoLuong,DonGia) values(?,?,?,?)";
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setLong(1, hdct.getMaHDCT().getMaHD());
        ps.setString(2, hdct.getMaCTSPCT().getMaCTSP());
        ps.setInt(3, hdct.getSoLuong());
        ps.setDouble(4, hdct.getDonGia());
        ps.executeUpdate();
    }

    public void deleteHDCTTT(Long maHDTT) throws SQLException {
        String sql = "Delete HoaDonChiTiet where MaHoaDon = ?";
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setLong(1, maHDTT);
        ps.executeUpdate();
    }

    public void deletemotHDCT(Long maCTSP) throws SQLException {
        String sql = "Delete HoaDonChiTiet where MaHDCT = ?";
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setLong(1, maCTSP);
        ps.executeUpdate();
    }

    public int getTongTien(Long maHDTT) {
        int max = 0;
        String sql = "select Sum(DonGia * SoLuong) as TongTien \n"
                + "from HoaDonChiTiet join HoaDon on HoaDonChiTiet.MaHoaDon = HoaDon.MaHoaDon\n"
                + "where HoaDonChiTiet.MaHoaDon = ?";
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(sql);
            ps.setLong(1, maHDTT);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                max = rs.getInt("TongTien");
            }

        } catch (SQLException ex) {
            Logger.getLogger(BanHangRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return max;
    }

    public int getKhuyenMai(String maCTSP) {
        int max = 0;
        String sql = "select GiaTriGiamToiDa from PhieuGiamGia where MaSanPham = ?";
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, maCTSP);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                max = rs.getInt("GiaTriGiamToiDa");
            }

        } catch (SQLException ex) {
            Logger.getLogger(BanHangRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return max;
    }

    public List<ChiTietSanPham> searchTenSP(String tenSP) {
        List<ChiTietSanPham> listCTSP = new ArrayList<>();
        String sql = "select  MaCTSP, SanPham.Ten as 'TênSP',NSX.Ten as 'TênNSX',DongSP.Ten as 'TênDongSP',ChatLieu.Ten as 'TênChatLieu',KichThuoc.Ten as 'TênKichThuoc',MauSac.Ten as 'TênMS',SoLuongTon,GiaBan,GiaTriGiamToiDa\n"
                + "from ChiTietSP join SanPham on SanPham.Ma = ChiTietSP.MaSP\n"
                + "				join NSX ON ChiTietSP.MaNsx = NSX.Ma\n"
                + "				join DongSP ON ChiTietSP.MaDongSP = DongSP.Ma\n"
                + "				join ChatLieu ON ChiTietSP.MaChatLieu = ChatLieu.Ma\n"
                + "				join KichThuoc ON ChiTietSP.MaSize = KichThuoc.Ma\n"
                + "				join MauSac ON ChiTietSP.MaMauSac = MauSac.Ma\n"
                + "							join PhieuGiamGia on PhieuGiamGia.MaSanPham = ChiTietSP.MaCTSP\n"
                + "where SanPham.Ten like'" + tenSP + "%'";
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps;

        try {
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                SanPham pham = new SanPham(rs.getString("TênSP"));
                NhaSanXuat nsx1 = new NhaSanXuat(rs.getString("TênNSX"));
                DongSP dongSP1 = new DongSP(rs.getString("TênDongSP"));
                ChatLieu chatLieu1 = new ChatLieu(rs.getString("TênChatLieu"));
                KichThuoc kichThuoc1 = new KichThuoc(rs.getString("TênKichThuoc"));
                MauSac mauSac1 = new MauSac(rs.getString("TênMS"));
                listCTSP.add(new ChiTietSanPham(rs.getString("MaCTSP"), pham, nsx1, mauSac1, dongSP1, chatLieu1, kichThuoc1, rs.getInt("SoLuongTon"), rs.getDouble("GiaBan"), rs.getDouble("GiaTriGiamToiDa")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BanHangRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listCTSP;
    }

    public List<ChiTietSanPham> searchLoaiSP(String loaiSP) {
        List<ChiTietSanPham> listCTSP = new ArrayList<>();
        String sql = "select  MaCTSP, SanPham.Ten as 'TênSP',NSX.Ten as 'TênNSX',DongSP.Ten as 'TênDongSP',ChatLieu.Ten as 'TênChatLieu',KichThuoc.Ten as 'TênKichThuoc',MauSac.Ten as 'TênMS',SoLuongTon,GiaBan,GiaTriGiamToiDa\n"
                + "from ChiTietSP join SanPham on SanPham.Ma = ChiTietSP.MaSP\n"
                + "				join NSX ON ChiTietSP.MaNsx = NSX.Ma\n"
                + "				join DongSP ON ChiTietSP.MaDongSP = DongSP.Ma\n"
                + "				join ChatLieu ON ChiTietSP.MaChatLieu = ChatLieu.Ma\n"
                + "				join KichThuoc ON ChiTietSP.MaSize = KichThuoc.Ma\n"
                + "				join MauSac ON ChiTietSP.MaMauSac = MauSac.Ma\n"
                + "							join PhieuGiamGia on PhieuGiamGia.MaSanPham = ChiTietSP.MaCTSP\n"
                + "where DongSP.Ten = ?";
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, loaiSP);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                SanPham pham = new SanPham(rs.getString("TênSP"));
                NhaSanXuat nsx1 = new NhaSanXuat(rs.getString("TênNSX"));
                DongSP dongSP1 = new DongSP(rs.getString("TênDongSP"));
                ChatLieu chatLieu1 = new ChatLieu(rs.getString("TênChatLieu"));
                KichThuoc kichThuoc1 = new KichThuoc(rs.getString("TênKichThuoc"));
                MauSac mauSac1 = new MauSac(rs.getString("TênMS"));
                listCTSP.add(new ChiTietSanPham(rs.getString("MaCTSP"), pham, nsx1, mauSac1, dongSP1, chatLieu1, kichThuoc1, rs.getInt("SoLuongTon"), rs.getDouble("GiaBan"), rs.getDouble("GiaTriGiamToiDa")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BanHangRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listCTSP;
    }

    public List<DongSP> getlistDongsp() {
        List<DongSP> listDongsp = new ArrayList<>();
        String sql = "select Ten from DongSP";
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                listDongsp.add(new DongSP(rs.getString(1)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BanHangRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listDongsp;
    }

}
