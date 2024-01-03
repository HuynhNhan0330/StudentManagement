package com.example.studentmanagement.service.impl;

import com.example.studentmanagement.dto.GiaoVienDTO;
import com.example.studentmanagement.jpa.IGiaoVienJPA;
import com.example.studentmanagement.jpa.ITaiKhoanJPA;
import com.example.studentmanagement.jpa.impl.GiaoVienJPA;
import com.example.studentmanagement.jpa.impl.TaiKhoanJPA;
import com.example.studentmanagement.model.GiaoVienModel;
import com.example.studentmanagement.model.TaiKhoanModel;
import com.example.studentmanagement.service.IGiaoVienService;
import com.example.studentmanagement.utils.Helper;

import java.util.List;

public class GiaoVienService implements IGiaoVienService {

    private IGiaoVienJPA giaoVienJPA;
    private ITaiKhoanJPA taiKhoanJPA;

    public GiaoVienService() {
        giaoVienJPA = new GiaoVienJPA();
        taiKhoanJPA = new TaiKhoanJPA();
    }

    @Override
    public List<GiaoVienDTO> findAll() {
        return giaoVienJPA.findAll();
    }

    @Override
    public GiaoVienDTO findOne(String maGV) {
        return giaoVienJPA.findOne(maGV);
    }

    @Override
    public GiaoVienDTO save(GiaoVienDTO giaoVienDTO) {
        // Kiểm tra email, phone

        // Lưu tài khoản
        String newMaTK = Helper.generateNewMa(taiKhoanJPA.findMaxMaTaiKhoan(), "TK");
        giaoVienDTO.setMaTK(newMaTK);

        TaiKhoanModel taiKhoanModel = new TaiKhoanModel();
        taiKhoanModel.setMaTK(newMaTK);
        taiKhoanModel.setTenTK(giaoVienDTO.getTenTK());
        taiKhoanModel.setNgaySinh(giaoVienDTO.getNgaySinh());
        taiKhoanModel.setEmail(giaoVienDTO.getEmail());
        taiKhoanModel.setPhone(giaoVienDTO.getPhone());
        taiKhoanModel.setRole("2");
        taiKhoanJPA.save(taiKhoanModel);

        // Lưu giáo viên
        String newMaGV = Helper.generateNewMa(giaoVienJPA.findMaxMaGiaoVien(), "GV");
        giaoVienDTO.setMaGV(newMaGV);
        String currentMaGiaoVien = giaoVienJPA.save(giaoVienDTO);
        return giaoVienJPA.findOne(currentMaGiaoVien);
    }

    @Override
    public GiaoVienDTO update(GiaoVienDTO giaoVienDTO) {
        giaoVienJPA.update(giaoVienDTO);
        return giaoVienJPA.findOne(giaoVienDTO.getMaGV());
    }

    @Override
    public void delete(String maGV) {
        giaoVienJPA.delete(maGV);
    }
}
