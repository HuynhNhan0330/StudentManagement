package com.example.studentmanagement.jpa;

import com.example.studentmanagement.dto.GiaoVienDTO;
import com.example.studentmanagement.model.GiaoVienModel;

import java.util.List;

public interface IGiaoVienJPA {
    List<GiaoVienDTO> findAll();

    String findMaxMaGiaoVien();

    GiaoVienDTO findOne(String maGV);

    String save(GiaoVienDTO giaoVienDTO);

    void update(GiaoVienDTO giaoVienDTO);

    void delete(String maGV);
}
