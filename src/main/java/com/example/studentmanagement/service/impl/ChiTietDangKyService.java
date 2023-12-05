package com.example.studentmanagement.service.impl;

import com.example.studentmanagement.jpa.IChiTietDangKyJPA;
import com.example.studentmanagement.jpa.impl.ChiTietDangKyJPA;
import com.example.studentmanagement.model.ChiTietDangKyModel;
import com.example.studentmanagement.service.IChiTietDangKyService;
import com.example.studentmanagement.utils.Helper;

import java.util.List;

public class ChiTietDangKyService implements IChiTietDangKyService {
    private IChiTietDangKyJPA chiTietDangKyJPA;

    public ChiTietDangKyService() {
        chiTietDangKyJPA = new ChiTietDangKyJPA();
    }

    @Override
    public List<ChiTietDangKyModel> findAll() {
        return chiTietDangKyJPA.findAll();
    }

    @Override
    public ChiTietDangKyModel findOne(String maSV, String maLop) {
        return chiTietDangKyJPA.findOne(maSV, maLop);
    }

    @Override
    public ChiTietDangKyModel save(ChiTietDangKyModel chiTietDangKyModel) {
        String[] currentMa = chiTietDangKyJPA.save(chiTietDangKyModel);
        return chiTietDangKyJPA.findOne(currentMa[0], currentMa[1]);
    }

    @Override
    public ChiTietDangKyModel update(ChiTietDangKyModel chiTietDangKyModel) {
        chiTietDangKyJPA.update(chiTietDangKyModel);
        return chiTietDangKyJPA.findOne(chiTietDangKyModel.getMaSV(), chiTietDangKyModel.getMaLop());
    }

    @Override
    public void delete(String maSV, String maLop) {
        chiTietDangKyJPA.delete(maSV, maLop);
    }
}
