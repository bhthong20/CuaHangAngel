/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author thong
 */
public class ChatLieu {
    private Integer maCL;
    private String tenCL;

    public ChatLieu() {
    }

    public ChatLieu(Integer maCL, String tenCL) {
        this.maCL = maCL;
        this.tenCL = tenCL;
    }

    public ChatLieu(String tenCL) {
        this.tenCL = tenCL;
    }

    public Integer getMaCL() {
        return maCL;
    }

    public void setMaCL(Integer maCL) {
        this.maCL = maCL;
    }

    public String getTenCL() {
        return tenCL;
    }

    public void setTenCL(String tenCL) {
        this.tenCL = tenCL;
    }
    
    
}
