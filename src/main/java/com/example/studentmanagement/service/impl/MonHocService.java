package com.example.studentmanagement.service.impl;

import com.example.studentmanagement.jpa.IMonHocJPA;
import com.example.studentmanagement.jpa.impl.MonHocJPA;
import com.example.studentmanagement.model.MonHocModel;
import com.example.studentmanagement.service.IMonHocService;
import com.example.studentmanagement.utils.Helper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class MonHocService implements IMonHocService {

    private IMonHocJPA monHocJPA;

    public MonHocService() {
        monHocJPA = new MonHocJPA();
    }

    @Override
    public List<MonHocModel> findAll() {
        return monHocJPA.findAll();
    }

    @Override
    public MonHocModel findOne(String maMH) {
        return monHocJPA.findOne(maMH);
    }

    @Override
    public Map<String, Object> save(MonHocModel monHocModel) {
        // Kiểm tra tên môn học
        Boolean isCheckSubjectName = monHocJPA.checkSubjectName(monHocModel.getTenMH());

        if (isCheckSubjectName) {
            return new HashMap<>(){{
                put("monHoc", null);
                put("thongBao", "Tên môn học trùng");
            }};
        }
        else {
            String newMaMH = Helper.generateNewMa(monHocJPA.findMaxMaMonHoc(), "MH");
            monHocModel.setMaMH(newMaMH);
            String currentMaMonHoc = monHocJPA.save(monHocModel);
            return new HashMap<>(){{
                put("monHoc", monHocJPA.findOne(currentMaMonHoc));
                put("thongBao", "Tạo môn học thành công");
            }};
        }
    }

    @Override
    public MonHocModel update(MonHocModel monHocModel) {
        monHocJPA.update(monHocModel);
        return monHocJPA.findOne(monHocModel.getMaMH());
    }

    @Override
    public Boolean delete(String maMH) {
        return monHocJPA.delete(maMH);
    }
}
