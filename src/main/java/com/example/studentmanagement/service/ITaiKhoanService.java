package com.example.studentmanagement.service;

import com.example.studentmanagement.dto.TaiKhoanDTO;
import com.example.studentmanagement.model.TaiKhoanModel;

public interface ITaiKhoanService {
    public TaiKhoanModel login(TaiKhoanDTO taiKhoanDTO);
}
