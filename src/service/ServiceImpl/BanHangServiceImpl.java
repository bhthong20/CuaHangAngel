/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service.ServiceImpl;

import entity.ChiTietSanPham;
import entity.DongSP;
import entity.HoaDon;
import entity.HoaDonChiTiet;
import entity.KhachHang;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author thong
 */
public interface BanHangServiceImpl {

    List<KhachHang> getListKHHD();

    List<HoaDon> getListHDTT();

    List<ChiTietSanPham> getListCTSPTT();

    List<DongSP> getlistDongsp();

    List<ChiTietSanPham> searchLoaiSP(String loaiSP);

    List<ChiTietSanPham> searchTenSP(String tenSP);

    void addHDTT(HoaDon don);

    void updateHDTT(HoaDon don);

    void editHDTT(HoaDon don);

    void deleteHD(Long maHDTT);

    void addHDCTTT(HoaDonChiTiet hdct);

    void deleteHDCTTT(Long maHDTT);

    void deletemotHDCT(Long maCTSP);

    List<HoaDonChiTiet> getListHDCTTT(Long maHDtt);

    int getTongTien(Long maHDTT);

    int getKhuyenMai(String maCTSP);

    void editHDCTTT(HoaDonChiTiet chiTiet);

    void updateCTSP(String maCTSP, int soluongHDC);

    void deleteHDCT(Long maHDTT);

    void updateCTSPfromHDCT(String maCTSP, Long maHdCT);
    
    void updateCTSPfromHD(String maCTSP, Long maHd);
}
