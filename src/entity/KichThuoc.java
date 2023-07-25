/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author thong
 */
public class KichThuoc {
    private Integer maKT;
    private String tenKT;

    public Integer getMaKT() {
        return maKT;
    }

    public void setMaKT(Integer maKT) {
        this.maKT = maKT;
    }

    public KichThuoc(String tenKT) {
        this.tenKT = tenKT;
    }

    public String getTenKT() {
        return tenKT;
    }

    public void setTenKT(String tenKT) {
        this.tenKT = tenKT;
    }

    public KichThuoc() {
    }

    public KichThuoc(Integer maKT, String tenKT) {
        this.maKT = maKT;
        this.tenKT = tenKT;
    }
    
    
}
