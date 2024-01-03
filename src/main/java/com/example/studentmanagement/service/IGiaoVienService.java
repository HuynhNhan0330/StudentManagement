package com.example.studentmanagement.service;

import com.example.studentmanagement.dto.GiaoVienDTO;
import com.example.studentmanagement.model.GiaoVienModel;

import java.util.List;

public interface IGiaoVienService {

    List<GiaoVienDTO> findAll();

    GiaoVienDTO findOne(String maGV);

    GiaoVienDTO save(GiaoVienDTO giaoVienDTO);

    GiaoVienDTO update(GiaoVienDTO giaoVienDTO);

    void delete(String maGV);
}
