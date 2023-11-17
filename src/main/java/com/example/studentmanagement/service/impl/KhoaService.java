package com.example.studentmanagement.service.impl;

import com.example.studentmanagement.dao.IKhoaDAO;
import com.example.studentmanagement.dao.impl.KhoaDAO;
import com.example.studentmanagement.model.Khoa;
import com.example.studentmanagement.service.IKhoaService;
import com.example.studentmanagement.utils.Helper;

import java.util.List;

public class KhoaService implements IKhoaService {

    private IKhoaDAO khoaDAO;

    public KhoaService() {
        khoaDAO = new KhoaDAO();
    }

    @Override
    public List<Khoa> findAll() {
        return khoaDAO.findAll();
    }

    @Override
    public Khoa findOne(String maKhoa) {
        return khoaDAO.findOne(maKhoa);
    }

    @Override
    public Khoa save(Khoa khoa) {
        String newMaKhoa = Helper.generateNewMa(khoaDAO.findMaxMaKhoa(), "KH");
        khoa.setMaKhoa(newMaKhoa);
        String currentMaKhoa = khoaDAO.save(khoa);
        return khoaDAO.findOne(currentMaKhoa);
    }

    @Override
    public Khoa update(Khoa khoa) {
        khoaDAO.update(khoa);
        return khoaDAO.findOne(khoa.getMaKhoa());
    }

    @Override
    public void delete(String maKhoa) {
        khoaDAO.delete(maKhoa);
    }
}
