package com.example.studentmanagement.service;

import com.example.studentmanagement.model.MonHocModel;

import java.util.List;
import java.util.Map;

public interface IMonHocService {
    List<MonHocModel> findAll();

    MonHocModel findOne(String maMH);

    Map<String, Object> save(MonHocModel monHocModel);

    MonHocModel update(MonHocModel monHocModel);

    Boolean delete(String maMH);
}
