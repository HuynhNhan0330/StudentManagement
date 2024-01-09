package com.example.studentmanagement.service;

import com.example.studentmanagement.dto.LopHocDTO;
import com.example.studentmanagement.model.LopHocModel;

import java.util.List;
import java.util.Map;

public interface ILopHocService {
    List<LopHocDTO> findAll();

    LopHocDTO findOne(String maLop);

    Map<String, Object> save(LopHocModel lopHocModel);

    LopHocDTO update(LopHocModel lopHocModel);

    void delete(String maLop);
}
