package com.example.studentmanagement.service;

import com.example.studentmanagement.dto.SinhVienDTO;
import com.example.studentmanagement.model.SinhVien;

import java.util.List;

public interface ISinhVienService {

    List<SinhVien> findAll();

    SinhVien findOne(String maSinhVien);

    SinhVien save(SinhVienDTO sinhVienDTO);

    SinhVien update(SinhVienDTO sinhVienDTO);

    void delete(String maSinhVien);
}
