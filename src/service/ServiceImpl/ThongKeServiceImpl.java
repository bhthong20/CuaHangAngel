/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service.ServiceImpl;

import entity.HoaDon;
import entity.HoaDonChiTiet;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author thong
 */
public interface ThongKeServiceImpl {

    List<HoaDonChiTiet> getListTK();

    BigDecimal getListDoangThu();

    int getLisKhachHang();

    int getListhoaDon();

    List<HoaDonChiTiet> searchDoanhThu();

    List<HoaDonChiTiet> searchHoaDon();

    List<HoaDonChiTiet> searchSoLuong();
    
    List<HoaDonChiTiet> searchTenSP(String tenSP);
    
    List<HoaDon> bieuDo();
}
