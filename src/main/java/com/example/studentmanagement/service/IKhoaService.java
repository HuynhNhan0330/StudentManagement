package com.example.studentmanagement.service;


import com.example.studentmanagement.model.Khoa;

import java.util.List;

public interface IKhoaService {

    List<Khoa> findAll();

    Khoa findOne(String maKhoa);

    Khoa save(Khoa khoa);

    Khoa update(Khoa khoa);

    void delete(String maKhoa);
}
