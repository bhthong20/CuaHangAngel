/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service.ServiceImpl;

import entity.ChucVu;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface ChucVuService {
       List<ChucVu> findAll();

    void insert(ChucVu cv);

    void update(ChucVu cv);

    void delete(String id);
}
