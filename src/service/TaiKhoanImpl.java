/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import entity.DangNhap;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import repository.DangNhapRepository;
import service.ServiceImpl.TaiKhoanInterface;

/**
 *
 * @author Admin
 */
public class TaiKhoanImpl implements TaiKhoanInterface{
    private  DangNhapRepository rp = new DangNhapRepository();

    @Override
    public ArrayList<DangNhap> getList() {
        try {
               return rp.getTK();
        } catch (SQLException ex) {
           Logger.getLogger(TaiKhoanImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
}
}