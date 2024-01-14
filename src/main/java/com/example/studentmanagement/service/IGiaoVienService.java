package com.example.studentmanagement.service;

import com.example.studentmanagement.dto.GiaoVienDTO;
import com.example.studentmanagement.model.GiaoVienModel;

import java.util.List;
import java.util.Map;

public interface IGiaoVienService {

    List<GiaoVienDTO> findAll();

    GiaoVienDTO findOne(String maGV);

    Map<String, Object> save(GiaoVienDTO giaoVienDTO);

    GiaoVienDTO update(GiaoVienDTO giaoVienDTO);

    Boolean delete(GiaoVienDTO giaoVienDTO);

    GiaoVienDTO findAccount(String maTK);
}
