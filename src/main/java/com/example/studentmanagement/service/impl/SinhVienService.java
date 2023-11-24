package com.example.studentmanagement.service.impl;

import com.example.studentmanagement.dao.ISinhVienDAO;
import com.example.studentmanagement.dao.impl.SinhVienDAO;
import com.example.studentmanagement.dto.SinhVienDTO;
import com.example.studentmanagement.model.SinhVienModel;
import com.example.studentmanagement.service.ISinhVienService;
import com.example.studentmanagement.utils.Helper;

import java.util.List;

public class SinhVienService implements ISinhVienService {

    private ISinhVienDAO sinhVienDAO;

    public SinhVienService() {
        sinhVienDAO = new SinhVienDAO();
    }

    @Override
    public List<SinhVienModel> findAll() {
        return sinhVienDAO.findAll();
    }

    @Override
    public SinhVienModel findOne(String maSinhVien) {
        return sinhVienDAO.findOne(maSinhVien);
    }

    @Override
    public SinhVienModel save(SinhVienModel sinhVienModel) {
        String newMaSinhVien = Helper.generateNewMa(sinhVienDAO.findMaxMaSinhVien(), "SV");
        sinhVienModel.setMaSV(newMaSinhVien);
        sinhVienDAO.save(sinhVienModel);
        return sinhVienDAO.findOne(newMaSinhVien);
    }

    @Override
    public SinhVienModel update(SinhVienModel sinhVienModel) {
        sinhVienDAO.update(sinhVienModel);
        return sinhVienDAO.findOne(sinhVienModel.getMaSV());
    }

    @Override
    public void delete(String maSinhVien) {
        sinhVienDAO.delete(maSinhVien);
    }
}
