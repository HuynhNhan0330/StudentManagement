package com.example.studentmanagement.dao;

import com.example.studentmanagement.model.Nganh;

import java.util.List;

public interface INganhDAO {
    List<Nganh> findAll();

    String findMaxMaNganh();

    Nganh findOne(String maNganh);

    String save(Nganh nganh);

    void update(Nganh nganh);

    void delete(String maNganh);
}
