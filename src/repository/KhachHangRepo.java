/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import Utilities.DBConnection;
import entity.KhachHang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import repository.Lrepo.Ikh;

/**
 *
 * @author ADMIN
 */
public class KhachHangRepo implements Ikh {

    @Override
    public List<KhachHang> findAll() {
        List<KhachHang> customers = new ArrayList();

        try {
            Connection connection = DBConnection.getConnection();
            String query = """
                           select MaKhachHang,TenKhachHang,DiaChi,SoDienThoai,Email,GioiTinh,TrangThai  from KhachHang
                           """;
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                String ma = rs.getString("MaKhachHang");
                String ten = rs.getString("TenKhachHang");
                String diachi = rs.getString("DiaChi");
                String sdt = rs.getString("SoDienThoai");
                String email = rs.getString("Email");

                boolean gioitinh = rs.getBoolean("GioiTinh");
                Integer trangthai = rs.getInt("TrangThai");

                KhachHang customer = new KhachHang();
                customer.setMaKH(ma);
                customer.setTenKH(ten);
                customer.setDiaChi(diachi);
                customer.setSdt(sdt);
                customer.setEmail(email);

                customer.setGioiTinh(gioitinh);
                customer.setTrangThai(trangthai);

                customers.add(customer);
            }

        } catch (Exception ex) {
            System.out.println("Lỗi" + ex.toString());
        }

        return customers;
    }

    @Override
    public List<KhachHang> finma(int tt) {
        List<KhachHang> customers = new ArrayList();
        KhachHang kh = new KhachHang();
        try {
            Connection connection = DBConnection.getConnection();

            String tthai = "trangthai";

            if (tt == -1) {
                tthai = tthai;
            } else {
                tthai = String.valueOf(tt);
            }

            String query = """
                           select MaKhachHang,TenKhachHang,DiaChi,SoDienThoai,Email,GioiTinh,TrangThai  
                           from KhachHang  
                           where trangthai = """ + "" + tthai + "";

            System.out.println(tt);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                String ma = rs.getString("MaKhachHang");
                String ten = rs.getString("TenKhachHang");
                String diachi = rs.getString("DiaChi");
                String sdt = rs.getString("SoDienThoai");
                String email = rs.getString("Email");
                boolean gioitinh = rs.getBoolean("GioiTinh");
                Integer trangthai = rs.getInt("TrangThai");

                KhachHang customer = new KhachHang();
                customer.setMaKH(ma);
                customer.setTenKH(ten);
                customer.setDiaChi(diachi);
                customer.setSdt(sdt);
                customer.setEmail(email);

                customer.setGioiTinh(gioitinh);
                customer.setTrangThai(trangthai);

                customers.add(customer);
            }

        } catch (Exception ex) {
            System.out.println("Lỗi" + ex.toString());
        }

        return customers;
    }

    @Override
    public List<KhachHang> timkiem(String mA) {
        List<KhachHang> customers = new ArrayList();
        KhachHang kh = new KhachHang();

        try {
            Connection connection = DBConnection.getConnection();

            String where_condition = "where (MaKhachHang like '%" + mA + "%' or TenKhachHang like '%" + mA + "%' or DiaChi like '%" + mA + "%')";
            String query = """
                           select MaKhachHang,TenKhachHang,DiaChi,SoDienThoai,Email,GioiTinh,TrangThai
                           from KhachHang 
                           """ + where_condition;

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                String ma = rs.getString("MaKhachHang");
                String ten = rs.getString("TenKhachHang");
                String diachi = rs.getString("DiaChi");
                String sdt = rs.getString("SoDienThoai");
                String email = rs.getString("Email");
                boolean gioitinh = rs.getBoolean("GioiTinh");
                Integer trangthai = rs.getInt("TrangThai");

                KhachHang customer = new KhachHang();
                customer.setMaKH(ma);
                customer.setTenKH(ten);
                customer.setDiaChi(diachi);
                customer.setSdt(sdt);
                customer.setEmail(email);

                customer.setGioiTinh(gioitinh);
                customer.setTrangThai(trangthai);

                customers.add(customer);
            }

        } catch (Exception ex) {
            System.out.println("Lỗi" + ex.toString());
        }

        return customers;
    }

    @Override
    public boolean addDL(KhachHang kh) {
        try {
            Connection connection = DBConnection.getConnection();

            //2.viết câu truy vấn
            String query = "INSERT INTO KhachHang (MaKhachHang,TenKhachHang,DiaChi,SoDienThoai,Email,GioiTinh,TrangThai) VALUES("
                    + "'" + kh.getMaKH() + "'"
                    + ","
                    + "N'" + kh.getTenKH() + "'"
                    + ","
                    + "N'" + kh.getDiaChi() + "'"
                    + ","
                    + "'" + kh.getSdt() + "'"
                    + ","
                    + "'" + kh.getEmail() + "'"
                    + ","
                    + kh.getGioiTinh()
                    + ","
                    + kh.getTrangThai()
                    + ")";
            System.out.println(query);
            Statement st = connection.createStatement();
            //3.thực thi câu lệnh
            int affectedRow = st.executeUpdate(query);
            System.out.println(affectedRow);
            st.close();
            connection.close();
            return true;
        } catch (Exception e) {
            System.out.println("Lỗi");
            return false;
        }
    }

    @Override
    public boolean update(String ma, KhachHang kh) {
        try {
            Connection connection = DBConnection.getConnection();

            //2.viết câu truy vấn
            String query = "UPDATE KhachHang" + " SET" + " " + "TenKhachHang='"
                    + kh.getTenKH() + "'"
                    + "," + "DiaChi="
                    + "'" + kh.getDiaChi() + "'"
                    + "," + "SoDienThoai="
                    + "'" + kh.getSdt() + "'"
                    + "," + "Email="
                    + "'" + kh.getEmail() + "'"
                    + "," + "GioiTinh="
                    + kh.getGioiTinh()
                    + "," + "TrangThai="
                    + kh.getTrangThai()
                    + "WHERE MaKhachHang =" + "'" + ma + "'";
            System.out.println(query);
            Statement st = connection.createStatement();
            //3.thực thi câu lệnh
            int affectedRow = st.executeUpdate(query);
            System.out.println(affectedRow);
            st.close();
            connection.close();
            return true;
        } catch (Exception e) {
            System.out.println("Lỗi" + e.toString());
            return false;
        }
    }

}
