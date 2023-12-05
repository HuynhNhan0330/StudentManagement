package com.example.studentmanagement.service;

import com.example.studentmanagement.model.GiaoVienModel;

import java.util.List;

public interface IGiaoVienService {

    List<GiaoVienModel> findAll();

    GiaoVienModel findOne(String maGV);

    GiaoVienModel save(GiaoVienModel giaoVienModel);

    GiaoVienModel update(GiaoVienModel giaoVienModel);

    void delete(String maGV);
}
