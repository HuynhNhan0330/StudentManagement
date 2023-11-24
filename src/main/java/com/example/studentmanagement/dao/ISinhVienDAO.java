package com.example.studentmanagement.dao;

import com.example.studentmanagement.model.SinhVienModel;

import java.util.List;

public interface ISinhVienDAO {

    List<SinhVienModel> findAll();

    String findMaxMaSinhVien();

    SinhVienModel findOne(String maSinhVien);

    String save(SinhVienModel sinhVienModel);

    void update(SinhVienModel sinhVienModel);

    void delete(String maSinhVien);
}
