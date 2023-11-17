package com.example.studentmanagement.service;

import com.example.studentmanagement.dto.NganhDTO;
import com.example.studentmanagement.model.Nganh;

import java.util.List;

public interface INganhService {

    List<Nganh> findAll();

    Nganh findOne(String maNganh);

    Nganh save(NganhDTO nganhDTO);

    Nganh update(NganhDTO nganhDTO);

    void delete(String maNganh);
}
