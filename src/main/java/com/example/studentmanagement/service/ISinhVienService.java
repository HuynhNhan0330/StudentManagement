package com.example.studentmanagement.service;

import com.example.studentmanagement.dto.SinhVienDTO;
import com.example.studentmanagement.model.SinhVienModel;

import java.util.List;
import java.util.Map;

public interface ISinhVienService {

    List<SinhVienDTO> findAll();

    SinhVienDTO findOne(String maSinhVien);

    Map<String, Object> save(SinhVienDTO sinhVienDTO);

    SinhVienDTO update(SinhVienDTO sinhVienDTO);

    Boolean delete(SinhVienDTO sinhVienDTO);
}
