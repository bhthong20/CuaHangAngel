/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author thong
 */
public class PhieuGiamGia {

    private String maPhieu;
    private String tenPhieu;
    private String ngayBatDau;
    private String ngayKetThuc;
    private Double giaTriGiam;
    private Boolean hinhThucGiam;
    private String moTa;
    private Integer trangThai;
    private ChiTietSanPham ctsp;

    public PhieuGiamGia(String maPhieu, String tenPhieu, String ngayBatDau, String ngayKetThuc, Double giaTriGiam, Boolean hinhThucGiam, String moTa, Integer trangThai, ChiTietSanPham ctsp) {
        this.maPhieu = maPhieu;
        this.tenPhieu = tenPhieu;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.giaTriGiam = giaTriGiam;
        this.hinhThucGiam = hinhThucGiam;
        this.moTa = moTa;
        this.trangThai = trangThai;
        this.ctsp = ctsp;
    }

    public PhieuGiamGia() {
    }

    public PhieuGiamGia(Boolean hinhThucGiam) {
        this.hinhThucGiam = hinhThucGiam;
    }

    
    
    public String getMaPhieu() {
        return maPhieu;
    }

    public void setMaPhieu(String maPhieu) {
        this.maPhieu = maPhieu;
    }

    public String getTenPhieu() {
        return tenPhieu;
    }

    public void setTenPhieu(String tenPhieu) {
        this.tenPhieu = tenPhieu;
    }

    public String getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(String ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public String getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(String ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public Double getGiaTriGiam() {
        return giaTriGiam;
    }

    public void setGiaTriGiam(Double giaTriGiam) {
        this.giaTriGiam = giaTriGiam;
    }

    public Boolean getHinhThucGiam() {
        return hinhThucGiam;
    }

    public void setHinhThucGiam(Boolean hinhThucGiam) {
        this.hinhThucGiam = hinhThucGiam;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public Integer getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
    }

    public ChiTietSanPham getCtsp() {
        return ctsp;
    }

    public void setCtsp(ChiTietSanPham ctsp) {
        this.ctsp = ctsp;
    }
    
    
}
