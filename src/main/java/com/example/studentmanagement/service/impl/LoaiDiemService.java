package com.example.studentmanagement.service.impl;

import com.example.studentmanagement.jpa.ILoaiDiemJPA;
import com.example.studentmanagement.jpa.impl.LoaiDiemJPA;
import com.example.studentmanagement.model.LoaiDiemModel;
import com.example.studentmanagement.service.ILoaiDiemService;
import com.example.studentmanagement.utils.Helper;

import java.util.List;

public class LoaiDiemService implements ILoaiDiemService {

    private ILoaiDiemJPA loaiDiemJPA;

    public LoaiDiemService() {
        loaiDiemJPA = new LoaiDiemJPA();
    }

    @Override
    public List<LoaiDiemModel> findAll() {
        return loaiDiemJPA.findAll();
    }

    @Override
    public LoaiDiemModel findOne(String maLoaiDiem) {
        return loaiDiemJPA.findOne(maLoaiDiem);
    }

    @Override
    public LoaiDiemModel save(LoaiDiemModel loaiDiem) {
        String newMaLoaiDiem = Helper.generateNewMa(loaiDiemJPA.findMaxMaLoaiDiem(), "LD");
        loaiDiem.setMaLoaiDiem(newMaLoaiDiem);
        String currentMaLoaiDiem = loaiDiemJPA.save(loaiDiem);
        return loaiDiemJPA.findOne(currentMaLoaiDiem);
    }

    @Override
    public LoaiDiemModel update(LoaiDiemModel loaiDiem) {
        loaiDiemJPA.update(loaiDiem);
        return loaiDiemJPA.findOne(loaiDiem.getMaLoaiDiem());
    }

    @Override
    public void delete(String maLoaiDiem) {
        loaiDiemJPA.delete(maLoaiDiem);
    }
}
