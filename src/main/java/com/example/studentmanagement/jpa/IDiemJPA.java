package com.example.studentmanagement.jpa;

import com.example.studentmanagement.model.ChiTietDangKyModel;
import com.example.studentmanagement.model.DiemModel;

import java.util.List;

public interface IDiemJPA {
    List<DiemModel> findAll();

    DiemModel findOne(String maSV, String maMH, String maLoaiDiem);

    String[] save(DiemModel diemModel);

    void update(DiemModel diemModel);

    void delete(String maSV, String maMH, String maLoaiDiem);
}
