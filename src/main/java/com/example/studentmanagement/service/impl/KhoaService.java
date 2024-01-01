package com.example.studentmanagement.service.impl;

import com.example.studentmanagement.jpa.IKhoaJPA;
import com.example.studentmanagement.jpa.impl.KhoaJPA;
import com.example.studentmanagement.model.KhoaModel;
import com.example.studentmanagement.service.IKhoaService;
import com.example.studentmanagement.utils.Helper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KhoaService implements IKhoaService {

    private IKhoaJPA khoaJPA;

    public KhoaService() {
        khoaJPA = new KhoaJPA();
    }

    @Override
    public List<KhoaModel> findAll() {
        return khoaJPA.findAll();
    }

    @Override
    public KhoaModel findOne(String maKhoa) {
        return khoaJPA.findOne(maKhoa);
    }

    @Override
    public Map<String, Object> save(KhoaModel khoaModel) {
        // Kiểm tra tên khoa
        Boolean isCheckFacultyName = khoaJPA.checkFacultyName(khoaModel.getTenKhoa());

        if (isCheckFacultyName) {
            return new HashMap<>(){{
                put("khoa", null);
                put("thongBao", "Tên khoa trùng");
            }};
        }
        else {
            String newMaKhoa = Helper.generateNewMa(khoaJPA.findMaxMaKhoa(), "KH");
            khoaModel.setMaKhoa(newMaKhoa);
            String currentMaKhoa = khoaJPA.save(khoaModel);

            return new HashMap<>(){{
                put("khoa", khoaJPA.findOne(currentMaKhoa));
                put("thongBao", "Tạo khoa thành công");
            }};
        }
    }

    @Override
    public KhoaModel update(KhoaModel khoaModel) {
        khoaJPA.update(khoaModel);
        return khoaJPA.findOne(khoaModel.getMaKhoa());
    }

    @Override
    public Boolean delete(String maKhoa) {
        return khoaJPA.delete(maKhoa);
    }
}
