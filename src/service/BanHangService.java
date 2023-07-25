/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import entity.ChiTietSanPham;
import entity.DongSP;
import entity.HoaDon;
import entity.HoaDonChiTiet;
import entity.KhachHang;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import repository.BanHangRepository;
import service.ServiceImpl.BanHangServiceImpl;

/**
 *
 * @author thong
 */
public class BanHangService implements BanHangServiceImpl {

    private final BanHangRepository hdRepo = new BanHangRepository();

    @Override
    public List<KhachHang> getListKHHD() {
        try {
            return hdRepo.getListKHHD();
        } catch (SQLException ex) {
            Logger.getLogger(BanHangService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void addHDTT(HoaDon don) {
        try {
            hdRepo.addHDTT(don);
        } catch (SQLException ex) {
            Logger.getLogger(BanHangService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updateHDTT(HoaDon don) {
        try {
            hdRepo.updateHDTT(don);
        } catch (SQLException ex) {
            Logger.getLogger(BanHangService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<HoaDon> getListHDTT() {
        return hdRepo.getListHDTT();
    }

    @Override
    public List<ChiTietSanPham> getListCTSPTT() {
        return hdRepo.getListCTSPTT();
    }

    @Override
    public void addHDCTTT(HoaDonChiTiet hdct) {
        try {
            hdRepo.addHDCTTT(hdct);
        } catch (SQLException ex) {
            Logger.getLogger(BanHangService.class.getName()).log(Level.SEVERE, null, ex);
        }
;
    }

    @Override
    public List<HoaDonChiTiet> getListHDCTTT(Long maHDtt) {
        return hdRepo.getListHDCTTT(maHDtt);
    }

    @Override
    public int getTongTien(Long maHDTT) {
      return hdRepo.getTongTien(maHDTT);
    }

    @Override
    public void deleteHDCTTT(Long maHDTT) {
        try {
            hdRepo.deleteHDCTTT(maHDTT);
        } catch (SQLException ex) {
            Logger.getLogger(BanHangService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void editHDTT(HoaDon don) {
        try {
            hdRepo.editHDTT(don);
        } catch (SQLException ex) {
            Logger.getLogger(BanHangService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deleteHD(Long maHDTT) {
        try {
            hdRepo.deleteHD(maHDTT);
        } catch (SQLException ex) {
            Logger.getLogger(BanHangService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deletemotHDCT(Long maCTSP) {
        try {
            hdRepo.deletemotHDCT(maCTSP);
        } catch (SQLException ex) {
            Logger.getLogger(BanHangService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<ChiTietSanPham> searchTenSP(String tenSP) {
       return hdRepo.searchTenSP(tenSP);
    }

    @Override
    public List<DongSP> getlistDongsp() {
        return hdRepo.getlistDongsp();
    }

    @Override
    public List<ChiTietSanPham> searchLoaiSP(String loaiSP) {
        return hdRepo.searchLoaiSP(loaiSP);
    }

    @Override
    public void editHDCTTT(HoaDonChiTiet chiTiet) {
        try {
            hdRepo.editHDCTTT(chiTiet);
        } catch (SQLException ex) {
            Logger.getLogger(BanHangService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updateCTSP( String maCTSP, int soluongHDC) {
        try {
            hdRepo.updateCTSP( maCTSP, soluongHDC);
        } catch (SQLException ex) {
            Logger.getLogger(BanHangService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int getKhuyenMai(String maCTSP) {
       return hdRepo.getKhuyenMai(maCTSP);
    }

    @Override
    public void deleteHDCT(Long maHDTT) {
        try {
            hdRepo.deleteHDCT(maHDTT);
        } catch (SQLException ex) {
            Logger.getLogger(BanHangService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updateCTSPfromHDCT(String maCTSP, Long maHdCT) {
        try {
            hdRepo.updateCTSPfromHDCT(maCTSP, maHdCT);
        } catch (SQLException ex) {
            Logger.getLogger(BanHangService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updateCTSPfromHD(String maCTSP, Long maHd) {
        try {
            hdRepo.updateCTSPfromHD(maCTSP, maHd);
        } catch (SQLException ex) {
            Logger.getLogger(BanHangService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
}
