package com.example.studentmanagement.service.impl;

import com.example.studentmanagement.dao.INganhDAO;
import com.example.studentmanagement.dao.impl.NganhDAO;
import com.example.studentmanagement.dto.NganhDTO;
import com.example.studentmanagement.model.Nganh;
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
    public List<Nganh> findAll() {
        return nganhDAO.findAll();
    }

    @Override
    public Nganh findOne(String maNganh) {
        return nganhDAO.findOne(maNganh);
    }

    @Override
    public Nganh save(NganhDTO nganhDTO) {
        String newMaNganh = Helper.generateNewMa(nganhDAO.findMaxMaNganh(), "NG");
        Nganh nganh = new Nganh();
        nganh.setMaNganh(newMaNganh);
        nganh.setTenNganh(nganhDTO.getTenNganh());
        nganh.setKhoa(khoaService.findOne(nganhDTO.getMaKhoa()));
        String currentMaNganh = nganhDAO.save(nganh);
        return nganhDAO.findOne(currentMaNganh);
    }

    @Override
    public Nganh update(NganhDTO nganhDTO) {
        Nganh nganh = new Nganh();
        nganh.setMaNganh(nganhDTO.getMaNganh());
        nganh.setTenNganh(nganhDTO.getTenNganh());
        nganh.setKhoa(khoaService.findOne(nganhDTO.getMaKhoa()));
        nganhDAO.update(nganh);
        return nganhDAO.findOne(nganh.getMaNganh());
    }

    @Override
    public void delete(String maNganh) {
        nganhDAO.delete(maNganh);
    }
}
