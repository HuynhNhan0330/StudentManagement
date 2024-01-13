package com.example.studentmanagement.service;

import com.example.studentmanagement.dto.DiemDTO;
import com.example.studentmanagement.dto.LopHocDTO;
import com.example.studentmanagement.model.DiemModel;

import java.util.List;

public interface IDiemService {
    List<DiemModel> findAll();

    List<DiemDTO> findByClass(String maLop);

    List<DiemDTO> findByStudent(String maSV);

    DiemDTO findOne(String maSV, String maMH);

    DiemModel save(DiemModel diemModel);

    DiemDTO update(DiemDTO diemDTO);

    void delete(String maSV, String maMH, String maLoaiDiem);
}
