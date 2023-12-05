package com.example.studentmanagement.service;

import com.example.studentmanagement.model.ChiTietDangKyModel;

import java.util.List;

public interface IChiTietDangKyService {
    List<ChiTietDangKyModel> findAll();

    ChiTietDangKyModel findOne(String maSV, String maLop);

    ChiTietDangKyModel save(ChiTietDangKyModel chiTietDangKyModel);

    ChiTietDangKyModel update(ChiTietDangKyModel chiTietDangKyModel);

    void delete(String maSV, String maLop);
}
