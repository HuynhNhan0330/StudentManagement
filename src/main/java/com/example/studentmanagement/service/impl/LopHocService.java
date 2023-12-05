package com.example.studentmanagement.service.impl;

import com.example.studentmanagement.jpa.ILopHocJPA;
import com.example.studentmanagement.jpa.impl.LopHocJPA;
import com.example.studentmanagement.model.LopHocModel;
import com.example.studentmanagement.service.ILopHocService;
import com.example.studentmanagement.utils.Helper;

import java.util.List;

public class LopHocService implements ILopHocService {
    private ILopHocJPA lopHocJPA;

    public LopHocService() {
        lopHocJPA = new LopHocJPA();
    }

    @Override
    public List<LopHocModel> findAll() {
        return lopHocJPA.findAll();
    }

    @Override
    public LopHocModel findOne(String maLop) {
        return lopHocJPA.findOne(maLop);
    }

    @Override
    public LopHocModel save(LopHocModel lopHocModel) {
        String newMaLop = Helper.generateNewMa(lopHocJPA.findMaxMaLopHoc(), "LH");
        lopHocModel.setMaLop(newMaLop);
        String currentMaLop = lopHocJPA.save(lopHocModel);
        return lopHocJPA.findOne(currentMaLop);
    }

    @Override
    public LopHocModel update(LopHocModel lopHocModel) {
        lopHocJPA.update(lopHocModel);
        return lopHocJPA.findOne(lopHocModel.getMaLop());
    }

    @Override
    public void delete(String maLop) {
        lopHocJPA.delete(maLop);
    }
}
