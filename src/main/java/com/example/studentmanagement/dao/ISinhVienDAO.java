package com.example.studentmanagement.dao;

import com.example.studentmanagement.model.SinhVien;

import java.util.List;

public interface ISinhVienDAO {

    List<SinhVien> findAll();

    String findMaxMaSinhVien();

    SinhVien findOne(String maSinhVien);

    String save(SinhVien sinhVien);

    void update(SinhVien sinhVien);

    void delete(String maSinhVien);
}
