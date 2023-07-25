/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import entity.HoaDon;
import entity.HoaDonChiTiet;
import java.util.List;
import repository.HoaDonRepository;
import service.ServiceImpl.HoaDonServiceImpl;

/**
 *
 * @author thong
 */
public class HoaDonService implements HoaDonServiceImpl {

    private HoaDonRepository hdrepo = new HoaDonRepository();

    @Override
    public List<HoaDon> getListHD() {
        return hdrepo.getListHD();
    }

    @Override
    public List<HoaDon> searchListHD(Long maHD) {
        return hdrepo.searchListHD(maHD);
    }

    @Override
    public List<HoaDon> searchTinhTrang(int tinhTrang) {
        return hdrepo.searchTinhTrang(tinhTrang);
    }

    @Override
    public List<HoaDon> searchNgay(String ngayTao, String ngaythanhToan) {
        return hdrepo.searchNgay(ngayTao, ngaythanhToan);
    }

    @Override
    public List<HoaDonChiTiet> listHDCTGetHD(Long maHoaD) {
        return hdrepo.listHDCTGetHD(maHoaD);
    }
}
