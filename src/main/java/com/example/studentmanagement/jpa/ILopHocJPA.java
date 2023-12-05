package com.example.studentmanagement.jpa;

import com.example.studentmanagement.model.LopHocModel;

import java.util.List;

public interface ILopHocJPA {
    List<LopHocModel> findAll();

    String findMaxMaLopHoc();

    LopHocModel findOne(String maLop);

    String save(LopHocModel lopHocModel);

    void update(LopHocModel lopHocModel);

    void delete(String maLop);
}
