/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author thong
 */
public class MauSac {
    private Integer maMS;
    private String tenMS;

    public MauSac() {
    }

    public MauSac(Integer maMS, String tenMS) {
        this.maMS = maMS;
        this.tenMS = tenMS;
    }

    public MauSac(String tenMS) {
        this.tenMS = tenMS;
    }

    
    public Integer getMaMS() {
        return maMS;
    }

    public void setMaMS(Integer maMS) {
        this.maMS = maMS;
    }

    public String getTenMS() {
        return tenMS;
    }

    public void setTenMS(String tenMS) {
        this.tenMS = tenMS;
    }
    
    
}
