package com.example.studentmanagement.service;

import com.example.studentmanagement.model.DiemModel;

import java.util.List;

public interface IDiemService {
    List<DiemModel> findAll();

    DiemModel findOne(String maSV, String maMH, String maLoaiDiem);

    DiemModel save(DiemModel diemModel);

    DiemModel update(DiemModel diemModel);

    void delete(String maSV, String maMH, String maLoaiDiem);
}
