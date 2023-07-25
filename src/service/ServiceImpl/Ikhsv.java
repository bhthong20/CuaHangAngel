/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lsevice;

import entity.KhachHang;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface Ikhsv {
    
   
    public List<KhachHang> getAll();
    public List<KhachHang> fincbo(int tt);
    public boolean add(KhachHang kh);
    public boolean update(String ma ,KhachHang kh);
    public List<KhachHang> timkiem(String mA);
}
