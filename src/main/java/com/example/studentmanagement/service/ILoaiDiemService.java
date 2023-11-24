package com.example.studentmanagement.service;

import com.example.studentmanagement.model.LoaiDiemModel;

import java.util.List;

public interface ILoaiDiemService {

    List<LoaiDiemModel> findAll();

    LoaiDiemModel findOne(String maLoaiDiem);

    LoaiDiemModel save(LoaiDiemModel loaiDiem);

    LoaiDiemModel update(LoaiDiemModel loaiDiem);

    void delete(String maLoaiDiem);
}
