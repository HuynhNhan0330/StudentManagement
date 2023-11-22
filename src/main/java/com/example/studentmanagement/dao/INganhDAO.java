package com.example.studentmanagement.dao;

import com.example.studentmanagement.model.NganhModel;

import java.util.List;

public interface INganhDAO {
    List<NganhModel> findAll();

    String findMaxMaNganh();

    NganhModel findOne(String maNganh);

    String save(NganhModel nganhModel);

    void update(NganhModel nganhModel);

    void delete(String maNganh);
}
