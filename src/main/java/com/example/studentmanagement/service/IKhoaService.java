package com.example.studentmanagement.service;


import com.example.studentmanagement.model.KhoaModel;

import java.util.List;

public interface IKhoaService {

    List<KhoaModel> findAll();

    KhoaModel findOne(String maKhoa);

    KhoaModel save(KhoaModel khoaModel);

    KhoaModel update(KhoaModel khoaModel);

    void delete(String maKhoa);
}
