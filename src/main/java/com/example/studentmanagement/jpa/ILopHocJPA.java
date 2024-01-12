package com.example.studentmanagement.jpa;

import com.example.studentmanagement.dto.LichHocDTO;
import com.example.studentmanagement.dto.LopHocDTO;
import com.example.studentmanagement.model.LopHocModel;

import java.util.List;

public interface ILopHocJPA {
    List<LopHocDTO> findAll();

    List<LichHocDTO> findScheduleOfStudent(String maSV);

    String findMaxMaLopHoc();

    LopHocDTO findOne(String maLop);

    String save(LopHocModel lopHocModel);

    void update(LopHocModel lopHocModel);

    void delete(String maLop);

    Boolean checkRoom(LopHocModel lopHocModel);

    Boolean checkTeacher(LopHocModel lopHocModel);
}
