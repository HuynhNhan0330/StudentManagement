package com.example.studentmanagement.jpa;

import com.example.studentmanagement.model.ChiTietDangKyModel;
import com.example.studentmanagement.model.GiaoVienModel;

import java.util.List;

public interface IChiTietDangKyJPA {
    List<ChiTietDangKyModel> findAll();

    ChiTietDangKyModel findOne(String maSV, String maLop);

    String[] save(ChiTietDangKyModel chiTietDangKyModel);

    void update(ChiTietDangKyModel chiTietDangKyModel);

    void delete(String maSV, String maLop);
}
