package com.example.studentmanagement.service.impl;

import com.example.studentmanagement.dao.ISinhVienDAO;
import com.example.studentmanagement.dao.impl.SinhVienDAO;
import com.example.studentmanagement.dto.SinhVienDTO;
import com.example.studentmanagement.model.SinhVien;
import com.example.studentmanagement.service.ISinhVienService;
import com.example.studentmanagement.utils.Helper;

import java.util.List;

public class SinhVienService implements ISinhVienService {

    private ISinhVienDAO sinhVienDAO;

    public SinhVienService() {
        sinhVienDAO = new SinhVienDAO();
    }

    @Override
    public List<SinhVien> findAll() {
        return sinhVienDAO.findAll();
    }

    @Override
    public SinhVien findOne(String maSinhVien) {
        return sinhVienDAO.findOne(maSinhVien);
    }

    @Override
    public SinhVien save(SinhVienDTO sinhVienDTO) {
        SinhVien sinhVien = new SinhVien();
        String x = sinhVienDAO.findMaxMaSinhVien();
        String newMaSinhVien = Helper.generateNewMa(x, "SV");
        sinhVien.setMaSV(newMaSinhVien);
        sinhVien.setTenSV(sinhVienDTO.getTenSV());
        sinhVien.setNgaySinh(sinhVienDTO.getNgaySinh());
        sinhVien.setGioiTinh(sinhVienDTO.getGioiTinh());
        sinhVien.setNamNhapHoc(sinhVienDTO.getNamNhapHoc());
        String currentMaSinhVien = sinhVienDAO.save(sinhVien);
        return sinhVienDAO.findOne(currentMaSinhVien);
    }

    @Override
    public SinhVien update(SinhVienDTO sinhVienDTO) {
        SinhVien sinhVien = new SinhVien();
        sinhVien.setMaSV(sinhVienDTO.getMaSV());
        sinhVien.setTenSV(sinhVienDTO.getTenSV());
        sinhVien.setNgaySinh(sinhVienDTO.getNgaySinh());
        sinhVien.setGioiTinh(sinhVienDTO.getGioiTinh());
        sinhVien.setNamNhapHoc(sinhVienDTO.getNamNhapHoc());
        String currentMaSinhVien = sinhVienDAO.save(sinhVien);
        return sinhVienDAO.findOne(currentMaSinhVien);
    }

    @Override
    public void delete(String maSinhVien) {
        sinhVienDAO.delete(maSinhVien);
    }
}
