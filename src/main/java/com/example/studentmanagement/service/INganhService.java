package com.example.studentmanagement.service;

import com.example.studentmanagement.dto.NganhDTO;
import com.example.studentmanagement.model.NganhModel;

import java.util.List;
import java.util.Map;

public interface INganhService {

    List<NganhDTO> findAll();

    NganhDTO findOne(String maNganh);

    Map<String, Object> save(NganhModel nganhModel);

    NganhDTO update(NganhModel nganhModel);

    Boolean delete(String maNganh);
}
