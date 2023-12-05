package com.example.studentmanagement.service;

import com.example.studentmanagement.model.LopHocModel;

import java.util.List;

public interface ILopHocService {
    List<LopHocModel> findAll();

    LopHocModel findOne(String maLop);

    LopHocModel save(LopHocModel lopHocModel);

    LopHocModel update(LopHocModel lopHocModel);

    void delete(String maLop);
}
