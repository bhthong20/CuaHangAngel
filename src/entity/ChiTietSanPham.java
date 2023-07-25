/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author thong
 */
public class ChiTietSanPham {
    
    private String maCTSP;
    private SanPham sanPham;
    private NhaSanXuat nsx;
    private MauSac mauSac;
    private DongSP dongSP;
    private ChatLieu chatLieu;
    private KichThuoc kichThuoc;
    private String moTa;
    private Integer soLuongTon;
    private Double giaNhap;
    private Double giaBan;
    private String anhSp;
    private Double khuyenMai;

    public ChiTietSanPham() {
    }

    public ChiTietSanPham(String maCTSP) {
        this.maCTSP = maCTSP;
    }

    public ChiTietSanPham( Double giaNhap, Double giaBan) {
       
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
    }

    public ChiTietSanPham(String maCTSP, SanPham sanPham, NhaSanXuat nsx, MauSac mauSac, DongSP dongSP, ChatLieu chatLieu, KichThuoc kichThuoc, String moTa, Integer soLuongTon, Double giaNhap, Double giaBan, String anhSp, Double khuyenMai) {
        this.maCTSP = maCTSP;
        this.sanPham = sanPham;
        this.nsx = nsx;
        this.mauSac = mauSac;
        this.dongSP = dongSP;
        this.chatLieu = chatLieu;
        this.kichThuoc = kichThuoc;
        this.moTa = moTa;
        this.soLuongTon = soLuongTon;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.anhSp = anhSp;
        this.khuyenMai = khuyenMai;
    }

    
  

    public ChiTietSanPham(String maCTSP, SanPham sanPham, NhaSanXuat nsx, MauSac mauSac, DongSP dongSP, ChatLieu chatLieu, KichThuoc kichThuoc, Integer soLuongTon, Double giaBan,Double khuyenMai) {
        this.maCTSP = maCTSP;
        this.sanPham = sanPham;
        this.nsx = nsx;
        this.mauSac = mauSac;
        this.dongSP = dongSP;
        this.chatLieu = chatLieu;
        this.kichThuoc = kichThuoc;
        this.soLuongTon = soLuongTon;
        this.giaBan = giaBan;
        this.khuyenMai = khuyenMai;
    }

    public Double getKhuyenMai() {
        return khuyenMai;
    }

    public void setKhuyenMai(Double khuyenMai) {
        this.khuyenMai = khuyenMai;
    }
    
    
    public String getMaCTSP() {
        return maCTSP;
    }

    public void setMaCTSP(String maCTSP) {
        this.maCTSP = maCTSP;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }

    public NhaSanXuat getNsx() {
        return nsx;
    }

    public void setNsx(NhaSanXuat nsx) {
        this.nsx = nsx;
    }

    public MauSac getMauSac() {
        return mauSac;
    }

    public void setMauSac(MauSac mauSac) {
        this.mauSac = mauSac;
    }

    public DongSP getDongSP() {
        return dongSP;
    }

    public void setDongSP(DongSP dongSP) {
        this.dongSP = dongSP;
    }

    public ChatLieu getChatLieu() {
        return chatLieu;
    }

    public void setChatLieu(ChatLieu chatLieu) {
        this.chatLieu = chatLieu;
    }

    public KichThuoc getKichThuoc() {
        return kichThuoc;
    }

    public void setKichThuoc(KichThuoc kichThuoc) {
        this.kichThuoc = kichThuoc;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public Integer getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(Integer soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    public Double getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(Double giaNhap) {
        this.giaNhap = giaNhap;
    }

    public Double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(Double giaBan) {
        this.giaBan = giaBan;
    }

    public String getAnhSp() {
        return anhSp;
    }

    public void setAnhSp(String anhSp) {
        this.anhSp = anhSp;
    }
    
    
}
