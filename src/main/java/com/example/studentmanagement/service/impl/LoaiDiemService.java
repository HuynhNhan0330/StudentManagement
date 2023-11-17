package com.example.studentmanagement.service.impl;

import com.example.studentmanagement.dao.ILoaiDiemDAO;
import com.example.studentmanagement.dao.impl.LoaiDiemDAO;
import com.example.studentmanagement.model.LoaiDiem;
import com.example.studentmanagement.service.ILoaiDiemService;
import com.example.studentmanagement.utils.Helper;

import java.util.List;

public class LoaiDiemService implements ILoaiDiemService {

    private ILoaiDiemDAO loaiDiemDAO;

    public LoaiDiemService() {
        loaiDiemDAO = new LoaiDiemDAO();
    }

    @Override
    public List<LoaiDiem> findAll() {
        return loaiDiemDAO.findAll();
    }

    @Override
    public LoaiDiem findOne(String maLoaiDiem) {
        return loaiDiemDAO.findOne(maLoaiDiem);
    }

    @Override
    public LoaiDiem save(LoaiDiem loaiDiem) {
        String newMaLoaiDiem = Helper.generateNewMa(loaiDiemDAO.findMaxMaLoaiDiem(), "LD");
        loaiDiem.setMaLoaiDiem(newMaLoaiDiem);
        String currentMaLoaiDiem = loaiDiemDAO.save(loaiDiem);
        return loaiDiemDAO.findOne(currentMaLoaiDiem);
    }

    @Override
    public LoaiDiem update(LoaiDiem loaiDiem) {
        loaiDiemDAO.update(loaiDiem);
        return loaiDiemDAO.findOne(loaiDiem.getMaLoaiDiem());
    }

    @Override
    public void delete(String maLoaiDiem) {
        loaiDiemDAO.delete(maLoaiDiem);
    }
}
