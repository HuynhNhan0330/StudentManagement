package com.example.studentmanagement.jpa;

import com.example.studentmanagement.model.MonHocModel;

import java.util.List;

public interface IMonHocJPA {
    List<MonHocModel> findAll();

    String findMaxMaMonHoc();

    MonHocModel findOne(String maMH);

    String save(MonHocModel monHocModel);

    void update(MonHocModel monHocModel);

    Boolean delete(String maMH);

    Boolean checkSubjectName(String tenMH);
}
