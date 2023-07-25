/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import Utilities.DBConnection;
import entity.DangNhap;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class DangNhapRepository {

    public boolean insert(DangNhap dangNhap) {
        int check = 0;
        Connection conn = DBConnection.getConnection();
        String insert
                = "INSERT INTO [dbo].[Account]"
                + "           ([UserName] "
                + "           ,[Pass]) "
                + "      VALUES"
                + "           (?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(insert);

            ps.setObject(1, "no username");
            ps.setObject(2, dangNhap.getPassWord());
            check = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public static ArrayList<DangNhap> getTK() throws SQLException {
        ArrayList<DangNhap> list = new ArrayList<>();
        try {
            Connection conn = DBConnection.getConnection();

            String sql = "SELECT [Id]\n"
                    + "      ,[UserName]\n"
                    + "      ,[Pass]\n"
                    + "  FROM [dbo].[Account]";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next() == true) {

                Integer id = rs.getInt("id");
                String userName = rs.getString(2);
                String pass = rs.getString(3);

                DangNhap taikhoan = new DangNhap(id, userName, pass);
                list.add(taikhoan);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return list;
    }

    
      public  DangNhap getOne(String passWord) throws SQLException {
          DangNhap taikhoan = null;
        try {
            Connection conn = DBConnection.getConnection();

            String sql = "SELECT [Id]\n"
                    + "      ,[UserName]\n"
                    + "      ,[Pass]\n"
                    + "  FROM [dbo].[Account] WHERE Pass =?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1,passWord );
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next() == true) {
                Integer id = rs.getInt("id");
                String userName = rs.getString(2);
                String pass = rs.getString(3);

                taikhoan = new DangNhap(id, userName, pass);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return taikhoan;
    }

     
}
