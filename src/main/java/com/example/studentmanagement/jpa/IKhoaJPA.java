package com.example.studentmanagement.jpa;

import com.example.studentmanagement.model.KhoaModel;

import java.util.List;

public interface IKhoaJPA {
    List<KhoaModel> findAll();

    String findMaxMaKhoa();

    KhoaModel findOne(String maKhoa);

    String save(KhoaModel khoaModel);

    void update(KhoaModel khoaModel);

    Boolean delete(String maKhoa);

    Boolean checkFacultyName(String tenKhoa);
}
