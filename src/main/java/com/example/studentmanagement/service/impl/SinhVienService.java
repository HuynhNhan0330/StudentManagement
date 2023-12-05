package com.example.studentmanagement.service.impl;

import com.example.studentmanagement.jpa.ISinhVienJPA;
import com.example.studentmanagement.jpa.impl.SinhVienJPA;
import com.example.studentmanagement.model.SinhVienModel;
import com.example.studentmanagement.service.ISinhVienService;
import com.example.studentmanagement.utils.Helper;

import java.util.List;

public class SinhVienService implements ISinhVienService {

    private ISinhVienJPA sinhVienJPA;

    public SinhVienService() {
        sinhVienJPA = new SinhVienJPA();
    }

    @Override
    public List<SinhVienModel> findAll() {
        return sinhVienJPA.findAll();
    }

    @Override
    public SinhVienModel findOne(String maSinhVien) {
        return sinhVienJPA.findOne(maSinhVien);
    }

    @Override
    public SinhVienModel save(SinhVienModel sinhVienModel) {
        String newMaSinhVien = Helper.generateNewMa(sinhVienJPA.findMaxMaSinhVien(), "SV");
        sinhVienModel.setMaSV(newMaSinhVien);
        sinhVienJPA.save(sinhVienModel);
        return sinhVienJPA.findOne(newMaSinhVien);
    }

    @Override
    public SinhVienModel update(SinhVienModel sinhVienModel) {
        sinhVienJPA.update(sinhVienModel);
        return sinhVienJPA.findOne(sinhVienModel.getMaSV());
    }

    @Override
    public void delete(String maSinhVien) {
        sinhVienJPA.delete(maSinhVien);
    }
}
