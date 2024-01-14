package com.example.studentmanagement.service;

import com.example.studentmanagement.dto.SinhVienDTO;

import java.util.List;
import java.util.Map;

public interface ISinhVienService {

    List<SinhVienDTO> findAll();

    SinhVienDTO findOne(String maSinhVien);

    Map<String, Object> save(SinhVienDTO sinhVienDTO);

    Map<String, Object> update(SinhVienDTO sinhVienDTO);

    Boolean delete(SinhVienDTO sinhVienDTO);

    SinhVienDTO findAccount(String maTK);
}
