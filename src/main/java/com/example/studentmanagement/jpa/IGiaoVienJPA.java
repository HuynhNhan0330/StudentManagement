package com.example.studentmanagement.jpa;

import com.example.studentmanagement.model.GiaoVienModel;

import java.util.List;

public interface IGiaoVienJPA {
    List<GiaoVienModel> findAll();

    String findMaxMaGiaoVien();

    GiaoVienModel findOne(String maGV);

    String save(GiaoVienModel giaoVienModel);

    void update(GiaoVienModel giaoVienModel);

    void delete(String maGV);
}
