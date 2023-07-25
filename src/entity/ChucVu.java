/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author thong
 */
public class ChucVu {
    
    private Integer maCV;
    private String tenCV;

    public ChucVu() {
    }

    
    public ChucVu(Integer maCV, String tenCV) {
        this.maCV = maCV;
        this.tenCV = tenCV;
    }

    public Integer getMaCV() {
        return maCV;
    }

    public void setMaCV(Integer maCV) {
        this.maCV = maCV;
    }

    public String getTenCV() {
        return tenCV;
    }

    public void setTenCV(String tenCV) {
        this.tenCV = tenCV;
    }

    @Override
    public String toString() {
        return tenCV;
    }
    
    
}
