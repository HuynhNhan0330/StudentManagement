package com.example.studentmanagement.service;

import com.example.studentmanagement.dto.SinhVienDTO;
import com.example.studentmanagement.model.SinhVienModel;

import java.util.List;

public interface ISinhVienService {

    List<SinhVienModel> findAll();

    SinhVienModel findOne(String maSinhVien);

    SinhVienModel save(SinhVienModel sinhVienModel);

    SinhVienModel update(SinhVienModel sinhVienModel);

    void delete(String maSinhVien);
}
