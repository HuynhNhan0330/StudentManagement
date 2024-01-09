package com.example.studentmanagement.jpa;

import com.example.studentmanagement.dto.LopHocDTO;
import com.example.studentmanagement.model.LopHocModel;

import java.util.List;

public interface ILopHocJPA {
    List<LopHocDTO> findAll();

    String findMaxMaLopHoc();

    LopHocDTO findOne(String maLop);

    String save(LopHocModel lopHocModel);

    void update(LopHocModel lopHocModel);

    void delete(String maLop);
}
