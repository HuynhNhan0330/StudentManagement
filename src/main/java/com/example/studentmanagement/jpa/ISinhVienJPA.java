package com.example.studentmanagement.jpa;

import com.example.studentmanagement.dto.SinhVienDTO;
import com.example.studentmanagement.model.SinhVienModel;

import java.util.List;

public interface ISinhVienJPA {

    List<SinhVienDTO> findAll();

    String findMaxMaSinhVien();

    SinhVienDTO findOne(String maSinhVien);

    String save(SinhVienDTO sinhVienDTO);

    void update(SinhVienDTO sinhVienDTO);

    Boolean delete(String maSinhVien);

    SinhVienDTO findAccount(String maTK);
}
