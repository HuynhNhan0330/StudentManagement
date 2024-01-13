package com.example.studentmanagement.service;

import com.example.studentmanagement.dto.LopHocDTO;
import com.example.studentmanagement.model.ChiTietDangKyModel;

import java.util.List;
import java.util.Map;

public interface IChiTietDangKyService {
    List<ChiTietDangKyModel> findAll();

    ChiTietDangKyModel findOne(String maSV, String maLop);

    Map<String, Object> save(String maSV, LopHocDTO lopHocDTO);

    ChiTietDangKyModel update(ChiTietDangKyModel chiTietDangKyModel);

    void delete(String maSV, LopHocDTO lopHocDTO);
}
