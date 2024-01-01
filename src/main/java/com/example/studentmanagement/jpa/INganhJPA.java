package com.example.studentmanagement.jpa;

import com.example.studentmanagement.dto.NganhDTO;
import com.example.studentmanagement.model.NganhModel;

import java.util.List;

public interface INganhJPA {
    List<NganhDTO> findAll();

    String findMaxMaNganh();

    NganhDTO findOne(String maNganh);

    String save(NganhModel nganhModel);

    void update(NganhModel nganhModel);

    Boolean delete(String maNganh);

    Boolean checkMajorName(String tenNganh);
}
