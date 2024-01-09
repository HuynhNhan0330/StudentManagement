package com.example.studentmanagement.service;

import com.example.studentmanagement.dto.SinhVienDTO;
import com.example.studentmanagement.model.PhongHocModel;

import java.util.List;

public interface IPhongHocService {
    List<PhongHocModel> findAll();
}
