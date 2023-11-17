package com.example.studentmanagement.dao;

import com.example.studentmanagement.model.LoaiDiem;

import java.util.List;

public interface ILoaiDiemDAO {
    List<LoaiDiem> findAll();

    String findMaxMaLoaiDiem();

    LoaiDiem findOne(String maLoaiDiem);

    String save(LoaiDiem loaiDiem);

    void update(LoaiDiem loaiDiem);

    void delete(String maLoaiDiem);
}
