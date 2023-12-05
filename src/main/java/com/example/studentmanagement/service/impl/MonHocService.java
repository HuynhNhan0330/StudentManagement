package com.example.studentmanagement.service.impl;

import com.example.studentmanagement.jpa.IMonHocJPA;
import com.example.studentmanagement.jpa.impl.MonHocJPA;
import com.example.studentmanagement.model.MonHocModel;
import com.example.studentmanagement.service.IMonHocService;
import com.example.studentmanagement.utils.Helper;

import java.util.List;

public class MonHocService implements IMonHocService {

    private IMonHocJPA monHocJPA;

    public MonHocService() {
        monHocJPA = new MonHocJPA();
    }

    @Override
    public List<MonHocModel> findAll() {
        return monHocJPA.findAll();
    }

    @Override
    public MonHocModel findOne(String maMH) {
        return monHocJPA.findOne(maMH);
    }

    @Override
    public MonHocModel save(MonHocModel monHocModel) {
        String newMaMH = Helper.generateNewMa(monHocJPA.findMaxMaMonHoc(), "MH");
        monHocModel.setMaMH(newMaMH);
        String currentMaMonHoc = monHocJPA.save(monHocModel);
        return monHocJPA.findOne(currentMaMonHoc);
    }

    @Override
    public MonHocModel update(MonHocModel monHocModel) {
        monHocJPA.update(monHocModel);
        return monHocJPA.findOne(monHocModel.getMaMH());
    }

    @Override
    public void delete(String maMH) {
        monHocJPA.delete(maMH);
    }
}
