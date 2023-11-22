package com.example.studentmanagement.service.impl;

import com.example.studentmanagement.dao.IKhoaDAO;
import com.example.studentmanagement.dao.impl.KhoaDAO;
import com.example.studentmanagement.model.KhoaModel;
import com.example.studentmanagement.service.IKhoaService;
import com.example.studentmanagement.utils.Helper;

import java.util.List;

public class KhoaService implements IKhoaService {

    private IKhoaDAO khoaDAO;

    public KhoaService() {
        khoaDAO = new KhoaDAO();
    }

    @Override
    public List<KhoaModel> findAll() {
        return khoaDAO.findAll();
    }

    @Override
    public KhoaModel findOne(String maKhoa) {
        return khoaDAO.findOne(maKhoa);
    }

    @Override
    public KhoaModel save(KhoaModel khoaModel) {
        String newMaKhoa = Helper.generateNewMa(khoaDAO.findMaxMaKhoa(), "KH");
        khoaModel.setMaKhoa(newMaKhoa);
        String currentMaKhoa = khoaDAO.save(khoaModel);
        return khoaDAO.findOne(currentMaKhoa);
    }

    @Override
    public KhoaModel update(KhoaModel khoaModel) {
        khoaDAO.update(khoaModel);
        return khoaDAO.findOne(khoaModel.getMaKhoa());
    }

    @Override
    public void delete(String maKhoa) {
        khoaDAO.delete(maKhoa);
    }
}
