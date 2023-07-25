/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository.Lrepo;

import entity.KhachHang;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface Ikh {
    
    
     public List<KhachHang> findAll();
     public List<KhachHang> finma(int tt);
     public List<KhachHang> timkiem(String mA);
     public boolean addDL(KhachHang kh);
     public boolean update(String ma, KhachHang kh);
}
