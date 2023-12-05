package com.example.studentmanagement.service.impl;

import com.example.studentmanagement.jpa.INganhJPA;
import com.example.studentmanagement.jpa.impl.NganhJPA;
import com.example.studentmanagement.model.NganhModel;
import com.example.studentmanagement.service.IKhoaService;
import com.example.studentmanagement.service.INganhService;
import com.example.studentmanagement.utils.Helper;

import java.util.List;

public class NganhService implements INganhService {

    private INganhJPA nganhJPA;
    private IKhoaService khoaService;

    public NganhService() {
        nganhJPA = new NganhJPA();
        khoaService = new KhoaService();
    }

    @Override
    public List<NganhModel> findAll() {
        return nganhJPA.findAll();
    }

    @Override
    public NganhModel findOne(String maNganh) {
        return nganhJPA.findOne(maNganh);
    }

    @Override
    public NganhModel save(NganhModel nganhModel) {
        String newMaNganh = Helper.generateNewMa(nganhJPA.findMaxMaNganh(), "NG");
        nganhModel.setMaNganh(newMaNganh);
        nganhJPA.save(nganhModel);
        return nganhJPA.findOne(newMaNganh);
    }

    @Override
    public NganhModel update(NganhModel nganhModel) {
        nganhJPA.update(nganhModel);
        return nganhJPA.findOne(nganhModel.getMaNganh());
    }

    @Override
    public void delete(String maNganh) {
        nganhJPA.delete(maNganh);
    }
}
