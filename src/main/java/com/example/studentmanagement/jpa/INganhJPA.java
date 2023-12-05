package com.example.studentmanagement.jpa;

import com.example.studentmanagement.model.NganhModel;

import java.util.List;

public interface INganhJPA {
    List<NganhModel> findAll();

    String findMaxMaNganh();

    NganhModel findOne(String maNganh);

    String save(NganhModel nganhModel);

    void update(NganhModel nganhModel);

    void delete(String maNganh);
}
