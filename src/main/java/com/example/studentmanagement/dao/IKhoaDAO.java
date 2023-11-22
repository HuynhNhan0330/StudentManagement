package com.example.studentmanagement.dao;

import com.example.studentmanagement.model.KhoaModel;

import java.util.List;

public interface IKhoaDAO {
    List<KhoaModel> findAll();

    String findMaxMaKhoa();

    KhoaModel findOne(String maKhoa);

    String save(KhoaModel khoaModel);

    void update(KhoaModel khoaModel);

    void delete(String maKhoa);
}
