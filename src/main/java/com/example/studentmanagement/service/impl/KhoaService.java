package com.example.studentmanagement.service.impl;

import com.example.studentmanagement.jpa.IKhoaJPA;
import com.example.studentmanagement.jpa.impl.KhoaJPA;
import com.example.studentmanagement.model.KhoaModel;
import com.example.studentmanagement.service.IKhoaService;
import com.example.studentmanagement.utils.Helper;

import java.util.List;

public class KhoaService implements IKhoaService {

    private IKhoaJPA khoaJPA;

    public KhoaService() {
        khoaJPA = new KhoaJPA();
    }

    @Override
    public List<KhoaModel> findAll() {
        return khoaJPA.findAll();
    }

    @Override
    public KhoaModel findOne(String maKhoa) {
        return khoaJPA.findOne(maKhoa);
    }

    @Override
    public KhoaModel save(KhoaModel khoaModel) {
        String newMaKhoa = Helper.generateNewMa(khoaJPA.findMaxMaKhoa(), "KH");
        khoaModel.setMaKhoa(newMaKhoa);
        String currentMaKhoa = khoaJPA.save(khoaModel);
        return khoaJPA.findOne(currentMaKhoa);
    }

    @Override
    public KhoaModel update(KhoaModel khoaModel) {
        khoaJPA.update(khoaModel);
        return khoaJPA.findOne(khoaModel.getMaKhoa());
    }

    @Override
    public Boolean delete(String maKhoa) {
        return khoaJPA.delete(maKhoa);
    }
}
