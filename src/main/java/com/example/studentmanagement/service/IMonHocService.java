package com.example.studentmanagement.service;

import com.example.studentmanagement.model.MonHocModel;

import java.util.List;

public interface IMonHocService {
    List<MonHocModel> findAll();

    MonHocModel findOne(String maMH);

    MonHocModel save(MonHocModel monHocModel);

    MonHocModel update(MonHocModel monHocModel);

    void delete(String maMH);
}
