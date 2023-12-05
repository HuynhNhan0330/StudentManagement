package com.example.studentmanagement.service.impl;

import com.example.studentmanagement.jpa.IGiaoVienJPA;
import com.example.studentmanagement.jpa.impl.GiaoVienJPA;
import com.example.studentmanagement.model.GiaoVienModel;
import com.example.studentmanagement.service.IGiaoVienService;
import com.example.studentmanagement.utils.Helper;

import java.util.List;

public class GiaoVienService implements IGiaoVienService {

    private IGiaoVienJPA giaoVienJPA;

    public GiaoVienService() {
        giaoVienJPA = new GiaoVienJPA();
    }

    @Override
    public List<GiaoVienModel> findAll() {
        return giaoVienJPA.findAll();
    }

    @Override
    public GiaoVienModel findOne(String maGV) {
        return giaoVienJPA.findOne(maGV);
    }

    @Override
    public GiaoVienModel save(GiaoVienModel giaoVienModel) {
        String newMaGV = Helper.generateNewMa(giaoVienJPA.findMaxMaGiaoVien(), "GV");
        giaoVienModel.setMaGV(newMaGV);
        String currentMaKhoa = giaoVienJPA.save(giaoVienModel);
        return giaoVienJPA.findOne(currentMaKhoa);
    }

    @Override
    public GiaoVienModel update(GiaoVienModel giaoVienModel) {
        giaoVienJPA.update(giaoVienModel);
        return giaoVienJPA.findOne(giaoVienModel.getMaGV());
    }

    @Override
    public void delete(String maGV) {
        giaoVienJPA.delete(maGV);
    }
}
