/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author thong
 */
public class NhaSanXuat {
    private Integer nhaSanXuat;
    private String tenNhaSanXuat;

    public NhaSanXuat() {
    }

    public NhaSanXuat(Integer nhaSanXuat, String tenNhaSanXuat) {
        this.nhaSanXuat = nhaSanXuat;
        this.tenNhaSanXuat = tenNhaSanXuat;
    }

    public NhaSanXuat(String tenNhaSanXuat) {
        this.tenNhaSanXuat = tenNhaSanXuat;
    }

    public Integer getNhaSanXuat() {
        return nhaSanXuat;
    }

    public void setNhaSanXuat(Integer nhaSanXuat) {
        this.nhaSanXuat = nhaSanXuat;
    }

    public String getTenNhaSanXuat() {
        return tenNhaSanXuat;
    }

    public void setTenNhaSanXuat(String tenNhaSanXuat) {
        this.tenNhaSanXuat = tenNhaSanXuat;
    }
    
}
