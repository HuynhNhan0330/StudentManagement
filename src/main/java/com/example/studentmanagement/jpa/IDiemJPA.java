package com.example.studentmanagement.jpa;

import com.example.studentmanagement.dto.DiemDTO;
import com.example.studentmanagement.dto.LopHocDTO;
import com.example.studentmanagement.model.DiemModel;

import java.util.List;

public interface IDiemJPA {
    List<DiemModel> findAll();

    List<DiemDTO> findByClass(LopHocDTO lopHocDTO);

    List<DiemDTO> findByStudent(String maSV);

    DiemDTO findOne(String maSV, String maMH);

    String[] save(DiemModel diemModel);

    void update(DiemModel diemModel);

    void delete(String maSV, String maMH, String maLoaiDiem);
}
