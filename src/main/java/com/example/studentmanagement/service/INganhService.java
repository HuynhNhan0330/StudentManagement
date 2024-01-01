package com.example.studentmanagement.service;

import com.example.studentmanagement.dto.NganhDTO;
import com.example.studentmanagement.model.NganhModel;

import java.util.List;

public interface INganhService {

    List<NganhDTO> findAll();

    NganhDTO findOne(String maNganh);

    NganhDTO save(NganhModel nganhModel);

    NganhDTO update(NganhModel nganhModel);

    Boolean delete(String maNganh);
}
