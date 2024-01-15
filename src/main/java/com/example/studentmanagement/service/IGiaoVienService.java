package com.example.studentmanagement.service;

import com.example.studentmanagement.dto.GiaoVienDTO;

import java.util.List;
import java.util.Map;

public interface IGiaoVienService {

    List<GiaoVienDTO> findAll();

    GiaoVienDTO findOne(String maGV);

    Map<String, Object> save(GiaoVienDTO giaoVienDTO);

    Map<String, Object> update(GiaoVienDTO giaoVienDTO);

    Boolean delete(GiaoVienDTO giaoVienDTO);

    GiaoVienDTO findAccount(String maTK);
}
