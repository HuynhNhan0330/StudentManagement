package com.example.studentmanagement.service.impl;

import com.example.studentmanagement.dao.INganhDAO;
import com.example.studentmanagement.dao.impl.NganhDAO;
import com.example.studentmanagement.model.NganhModel;
import com.example.studentmanagement.service.IKhoaService;
import com.example.studentmanagement.service.INganhService;
import com.example.studentmanagement.utils.Helper;

import java.util.List;

public class NganhService implements INganhService {

    private INganhDAO nganhDAO;
    private IKhoaService khoaService;

    public NganhService() {
        nganhDAO = new NganhDAO();
        khoaService = new KhoaService();
    }

    @Override
    public List<NganhModel> findAll() {
        return nganhDAO.findAll();
    }

    @Override
    public NganhModel findOne(String maNganh) {
        return nganhDAO.findOne(maNganh);
    }

    @Override
    public NganhModel save(NganhModel nganhModel) {
        String newMaNganh = Helper.generateNewMa(nganhDAO.findMaxMaNganh(), "NG");
        nganhModel.setMaNganh(newMaNganh);
        nganhDAO.save(nganhModel);
        return nganhDAO.findOne(newMaNganh);
    }

    @Override
    public NganhModel update(NganhModel nganhModel) {
        nganhDAO.update(nganhModel);
        return nganhDAO.findOne(nganhModel.getMaNganh());
    }

    @Override
    public void delete(String maNganh) {
        nganhDAO.delete(maNganh);
    }
}
