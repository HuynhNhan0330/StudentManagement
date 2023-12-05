package com.example.studentmanagement.jpa;

import com.example.studentmanagement.model.SinhVienModel;

import java.util.List;

public interface ISinhVienJPA {

    List<SinhVienModel> findAll();

    String findMaxMaSinhVien();

    SinhVienModel findOne(String maSinhVien);

    String save(SinhVienModel sinhVienModel);

    void update(SinhVienModel sinhVienModel);

    void delete(String maSinhVien);
}
