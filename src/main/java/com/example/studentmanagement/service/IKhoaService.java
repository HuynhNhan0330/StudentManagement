package com.example.studentmanagement.service;


import com.example.studentmanagement.model.KhoaModel;

import java.util.List;
import java.util.Map;

public interface IKhoaService {

    List<KhoaModel> findAll();

    KhoaModel findOne(String maKhoa);

    Map<String, Object> save(KhoaModel khoaModel);

    KhoaModel update(KhoaModel khoaModel);

    Boolean delete(String maKhoa);
}
