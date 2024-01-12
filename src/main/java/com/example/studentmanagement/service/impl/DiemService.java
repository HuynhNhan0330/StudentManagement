package com.example.studentmanagement.service.impl;

import com.example.studentmanagement.dto.DiemDTO;
import com.example.studentmanagement.dto.LopHocDTO;
import com.example.studentmanagement.jpa.IDiemJPA;
import com.example.studentmanagement.jpa.impl.DiemJPA;
import com.example.studentmanagement.model.DiemModel;
import com.example.studentmanagement.service.IDiemService;
import com.example.studentmanagement.service.ILopHocService;

import java.util.List;

public class DiemService implements IDiemService {
    private IDiemJPA diemJPA;
    private ILopHocService lopHocService;

    public DiemService() {
        diemJPA = new DiemJPA();
        lopHocService = new LopHocService();
    }

    @Override
    public List<DiemModel> findAll() {
        return diemJPA.findAll();
    }

    @Override
    public List<DiemDTO> findByClass(String maLop) {
        LopHocDTO lopHocDTO = lopHocService.findOne(maLop);

        return diemJPA.findByClass(lopHocDTO);
    }

    @Override
    public List<DiemDTO> findByStudent(String maSV) {
        return diemJPA.findByStudent(maSV);
    }

    @Override
    public DiemModel findOne(String maSV, String maMH, String maLoaiDiem) {
        return diemJPA.findOne(maSV, maMH, maLoaiDiem);
    }

    @Override
    public DiemModel save(DiemModel diemModel) {
        String[] currentMa = diemJPA.save(diemModel);
        return diemJPA.findOne(currentMa[0], currentMa[1], currentMa[2]);
    }

    @Override
    public DiemModel update(DiemModel diemModel) {
        diemJPA.update(diemModel);
        return diemJPA.findOne(diemModel.getMaSV(), diemModel.getMaMH(), diemModel.getMaLoaiDiem());
    }

    @Override
    public void delete(String maSV, String maMH, String maLoaiDiem) {
        diemJPA.delete(maSV, maMH, maLoaiDiem);
    }
}
