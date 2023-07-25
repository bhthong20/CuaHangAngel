/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author thong
 */
public class HoaDon {

    private Long maHD;
    private KhachHang makhachHang;
    private NhanVien manhanVien;
    private String ngayTao;
    private String ngayThanhToan;
    private Integer tinhTrang;
    private String diaChi;
    private String sdt;
    private Double tongTien;
    private Double tienThua;
    private Double thanhToan;
    private String phuongThucThanhToan;
    private String ghiChu;

    public HoaDon() {
    }

    public HoaDon(Long maHD, KhachHang makhachHang, NhanVien manhanVien, String ngayTao, String ngayThanhToan, Integer tinhTrang, Double tongTien, Double tienThua, Double thanhToan, String phuongThucThanhToan,String ghiChu) {
        this.maHD = maHD;
        this.makhachHang = makhachHang;
        this.manhanVien = manhanVien;
        this.ngayTao = ngayTao;
        this.ngayThanhToan = ngayThanhToan;
        this.tinhTrang = tinhTrang;
        this.tongTien = tongTien;
        this.tienThua = tienThua;
        this.thanhToan = thanhToan;
        this.phuongThucThanhToan = phuongThucThanhToan;
        this.ghiChu = ghiChu;
    }

    

    public HoaDon(Long maHD, KhachHang makhachHang, NhanVien manhanVien, String ngayTao) {
        this.maHD = maHD;
        this.makhachHang = makhachHang;
        this.manhanVien = manhanVien;
        this.ngayTao = ngayTao;
    }

    public HoaDon(String ngayThanhToan, Double tongTien) {
        this.ngayThanhToan = ngayThanhToan;
        this.tongTien = tongTien;
    }

    public Double getThanhToan() {
        return thanhToan;
    }

    public void setThanhToan(Double thanhToan) {
        this.thanhToan = thanhToan;
    }

    public HoaDon(Long maHD) {
        this.maHD = maHD;
    }

    public Long getMaHD() {
        return maHD;
    }

    public void setMaHD(Long maHD) {
        this.maHD = maHD;
    }

    public KhachHang getMakhachHang() {
        return makhachHang;
    }

    public void setMakhachHang(KhachHang makhachHang) {
        this.makhachHang = makhachHang;
    }

    public NhanVien getManhanVien() {
        return manhanVien;
    }

    public void setManhanVien(NhanVien manhanVien) {
        this.manhanVien = manhanVien;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(String ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public Integer getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(Integer tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public Double getTongTien() {
        return tongTien;
    }

    public void setTongTien(Double tongTien) {
        this.tongTien = tongTien;
    }

    public Double getTienThua() {
        return tienThua;
    }

    public void setTienThua(Double tienThua) {
        this.tienThua = tienThua;
    }

    public String getPhuongThucThanhToan() {
        return phuongThucThanhToan;
    }

    public void setPhuongThucThanhToan(String phuongThucThanhToan) {
        this.phuongThucThanhToan = phuongThucThanhToan;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
    
}
