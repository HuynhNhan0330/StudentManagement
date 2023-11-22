package com.example.studentmanagement.service;

import com.example.studentmanagement.model.NganhModel;

import java.util.List;

public interface INganhService {

    List<NganhModel> findAll();

    NganhModel findOne(String maNganh);

    NganhModel save(NganhModel nganhModel);

    NganhModel update(NganhModel nganhModel);

    void delete(String maNganh);
}
