/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service.ServiceImpl;

import entity.HoaDon;
import entity.HoaDonChiTiet;
import java.util.List;

/**
 *
 * @author thong
 */
public interface HoaDonServiceImpl {

    List<HoaDon> getListHD();

    List<HoaDon> searchListHD(Long maHD);

    List<HoaDon> searchTinhTrang(int tinhTrang);

    List<HoaDon> searchNgay(String ngayTao, String ngaythanhToan);
    
    List<HoaDonChiTiet> listHDCTGetHD(Long maHoaD);
}
