package com.example.studentmanagement.service.impl;

import com.example.studentmanagement.jpa.IPhongHocJPA;
import com.example.studentmanagement.jpa.impl.PhongHocJPA;
import com.example.studentmanagement.model.PhongHocModel;
import com.example.studentmanagement.service.IPhongHocService;

import java.util.List;

public class PhongHocService implements IPhongHocService {
    private IPhongHocJPA phongHocJPA;

    public PhongHocService() {
        phongHocJPA = new PhongHocJPA();
    }

    @Override
    public List<PhongHocModel> findAll() {
        return phongHocJPA.findAll();
    }
}
