package com.example.studentmanagement.service.impl;

import com.example.studentmanagement.dto.NganhDTO;
import com.example.studentmanagement.jpa.INganhJPA;
import com.example.studentmanagement.jpa.impl.NganhJPA;
import com.example.studentmanagement.model.NganhModel;
import com.example.studentmanagement.service.IKhoaService;
import com.example.studentmanagement.service.INganhService;
import com.example.studentmanagement.utils.Helper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NganhService implements INganhService {

    private INganhJPA nganhJPA;
    private IKhoaService khoaService;

    public NganhService() {
        nganhJPA = new NganhJPA();
        khoaService = new KhoaService();
    }

    @Override
    public List<NganhDTO> findAll() {
        return nganhJPA.findAll();
    }

    @Override
    public NganhDTO findOne(String maNganh) {
        return nganhJPA.findOne(maNganh);
    }

    @Override
    public Map<String, Object> save(NganhModel nganhModel) {
        // Kiểm tra tên ngành
        Boolean isCheckMajorName = nganhJPA.checkMajorName(nganhModel.getTenNganh());

        if (isCheckMajorName) {
            return new HashMap<>(){{
                put("nganh", null);
                put("thongBao", "Tên ngành trùng");
            }};
        }
        else {
            String newMaNganh = Helper.generateNewMa(nganhJPA.findMaxMaNganh(), "NG");
            nganhModel.setMaNganh(newMaNganh);
            nganhJPA.save(nganhModel);

            return new HashMap<>(){{
                put("nganh", nganhJPA.findOne(newMaNganh));
                put("thongBao", "Tạo ngành thành công");
            }};
        }
    }

    @Override
    public NganhDTO update(NganhModel nganhModel) {
        nganhJPA.update(nganhModel);
        return nganhJPA.findOne(nganhModel.getMaNganh());
    }

    @Override
    public Boolean delete(String maNganh) {
        return nganhJPA.delete(maNganh);
    }
}
