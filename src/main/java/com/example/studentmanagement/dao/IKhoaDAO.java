package com.example.studentmanagement.dao;

import com.example.studentmanagement.model.Khoa;

import java.util.List;

public interface IKhoaDAO {
    List<Khoa> findAll();

    String findMaxMaKhoa();

    Khoa findOne(String maKhoa);

    String save(Khoa khoa);

    void update(Khoa khoa);

    void delete(String maKhoa);
}
