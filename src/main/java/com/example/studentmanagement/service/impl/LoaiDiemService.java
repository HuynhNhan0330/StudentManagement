package com.example.studentmanagement.service.impl;

import com.example.studentmanagement.dao.ILoaiDiemDAO;
import com.example.studentmanagement.dao.impl.LoaiDiemDAO;
import com.example.studentmanagement.model.LoaiDiem;
import com.example.studentmanagement.service.ILoaiDiemService;

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
        String newMaLoaiDiem = loaiDiemDAO.save(loaiDiem);
        return loaiDiemDAO.findOne(newMaLoaiDiem);
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
