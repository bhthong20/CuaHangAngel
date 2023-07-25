/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author thong
 */
public class DangNhap {
    
    private Integer id;
    private String userName;
    private String passWord;
    private String chucVu;
    private String maNv;
    private String tenNV;

    public DangNhap() {
    }

    public DangNhap(String userName, String passWord, String chucVu, String maNv, String tenNV) {
        this.userName = userName;
        this.passWord = passWord;
        this.chucVu = chucVu;
        this.maNv = maNv;
        this.tenNV = tenNV;
    }

    public DangNhap(Integer id, String userName, String passWord) {
        this.id = id;
        this.userName = userName;
        this.passWord = passWord;
    }

    public DangNhap(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    public DangNhap(String passWord) {
        this.passWord = passWord;
    }

    
    
    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public String getMaNv() {
        return maNv;
    }

    public void setMaNv(String maNv) {
        this.maNv = maNv;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }
    
    

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

   
    
    
}
