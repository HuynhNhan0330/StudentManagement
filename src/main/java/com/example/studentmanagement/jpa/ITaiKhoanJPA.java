package com.example.studentmanagement.jpa;

import com.example.studentmanagement.model.TaiKhoanModel;

public interface ITaiKhoanJPA {
    String findMaxMaTaiKhoan();

    String save(TaiKhoanModel taiKhoanModel);

    void update(TaiKhoanModel taiKhoanModel);

    Boolean delete(String maTK);

    Boolean checkEmail(String email);
    Boolean checkPhone(String phone);
}
