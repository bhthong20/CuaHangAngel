/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;


import Utilities.DBConnection;
import java.sql.Connection;

import entity.ChucVu;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Admin
 */


public class ChucVuRepository {
 private Connection conn;
 public  ChucVuRepository(){

         this.conn = DBConnection.getConnection();
 }
 public List<ChucVu> fillAll(){
      List<ChucVu> ds = new ArrayList<>();
        
        String sql = "SELECT ma,ten FROM ChucVu";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
               
                Integer ma = rs.getInt("ma");
                String ten = rs.getString("ten");
                ChucVu cv = new ChucVu(ma, ten);
                ds.add(cv);
               
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return ds; 
 }
}
