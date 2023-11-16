package com.example.studentmanagement.service;

import com.example.studentmanagement.model.LoaiDiem;

import java.util.List;

public interface ILoaiDiemService {

    List<LoaiDiem> findAll();

    LoaiDiem findOne(String maLoaiDiem);

    LoaiDiem save(LoaiDiem loaiDiem);

    LoaiDiem update(LoaiDiem loaiDiem);

    void delete(String maLoaiDiem);
}
