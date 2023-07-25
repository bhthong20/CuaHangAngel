/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import entity.ChucVu;
import java.util.ArrayList;
import java.util.List;
import repository.ChucVuRepository;
import service.ServiceImpl.ChucVuService;

/**
 *
 * @author Admin
 */
public class ChucVuServiceImpl implements ChucVuService{
 private ChucVuRepository cvRepo;
    
    public ChucVuServiceImpl()
    {
        this.cvRepo = new ChucVuRepository();
    }
    @Override
    public List<ChucVu> findAll() {
          List<ChucVu> ds = new ArrayList<>();
        List<ChucVu> list = this.cvRepo.fillAll();
        
        for (ChucVu cv: list) {
            ChucVu vModel = new ChucVu(
              cv.getMaCV(), cv.getTenCV());
            ds.add(vModel);   }
   return ds;
    }
    
    @Override
    public void insert(ChucVu cv) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(ChucVu cv) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
