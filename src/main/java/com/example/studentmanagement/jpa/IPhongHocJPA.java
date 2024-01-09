package com.example.studentmanagement.jpa;

import com.example.studentmanagement.model.PhongHocModel;

import java.util.List;

public interface IPhongHocJPA {
    List<PhongHocModel> findAll();
}
