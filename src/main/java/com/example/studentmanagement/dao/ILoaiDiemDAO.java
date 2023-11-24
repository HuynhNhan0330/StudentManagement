package com.example.studentmanagement.dao;

import com.example.studentmanagement.model.LoaiDiemModel;

import java.util.List;

public interface ILoaiDiemDAO {
    List<LoaiDiemModel> findAll();

    String findMaxMaLoaiDiem();

    LoaiDiemModel findOne(String maLoaiDiem);

    String save(LoaiDiemModel loaiDiem);

    void update(LoaiDiemModel loaiDiem);

    void delete(String maLoaiDiem);
}
