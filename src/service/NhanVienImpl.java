/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;



import Utilities.DBConnection;
import entity.ChucVu;
import entity.DangNhap;
import entity.NhanVien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import repository.NhanVienRepository;
import service.ServiceImpl.NhanVienService;



/**
 *
 * @author Admin
 */
public class NhanVienImpl implements NhanVienService{
    private NhanVienRepository repo = new NhanVienRepository();

  





    @Override
    public void sua(NhanVien nv, String maNV) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

  
    @Override
    public List<NhanVien> getAllNhanVien() {
   return repo.getAllNhanVien();
    }

    @Override
    public List<ChucVu> getALLCV() {
        return repo.getCV();
   }

//    @Override
//    public void them(NhanVien nv) {
//   NhanVien nhanVien = new NhanVien( nv.getMaNV(), nv.getTenNV(), nv.getGioiTinh(), nv.getNgaySinh(), nv.getDiaChi(), nv.getSdt(), nv.getEmail(), nv.getDangNhap()., nv.getChucVu(), nv.getTrangThai());
//        repo.insert(nhanVien);  
//    }

    @Override
    public void xoa(NhanVien nv, String ma) {
     try {
            repo.delete(ma);
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienImpl.class.getName()).log(Level.SEVERE, null, ex);
        } }

    @Override
    public String them(NhanVien nv) {
         if (repo.insert(nv)) {
            return "Add thành công";
        }
        return "Add thất bại";
    }    }




   
 

 

