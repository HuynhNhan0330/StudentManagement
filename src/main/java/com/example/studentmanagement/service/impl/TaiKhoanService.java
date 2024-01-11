package com.example.studentmanagement.service.impl;

import com.example.studentmanagement.dto.TaiKhoanDTO;
import com.example.studentmanagement.jpa.ITaiKhoanJPA;
import com.example.studentmanagement.jpa.impl.TaiKhoanJPA;
import com.example.studentmanagement.model.TaiKhoanModel;
import com.example.studentmanagement.service.ITaiKhoanService;

public class TaiKhoanService implements ITaiKhoanService {
    private ITaiKhoanJPA taiKhoanJPA;

    public TaiKhoanService() {
        taiKhoanJPA = new TaiKhoanJPA();
    }

    @Override
    public TaiKhoanModel login(TaiKhoanDTO taiKhoanDTO) {
        return taiKhoanJPA.login(taiKhoanDTO);
    }
}
