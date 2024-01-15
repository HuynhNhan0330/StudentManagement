package com.example.studentmanagement.service.impl;

import com.example.studentmanagement.dto.GiaoVienDTO;
import com.example.studentmanagement.jpa.IGiaoVienJPA;
import com.example.studentmanagement.jpa.ITaiKhoanJPA;
import com.example.studentmanagement.jpa.impl.GiaoVienJPA;
import com.example.studentmanagement.jpa.impl.TaiKhoanJPA;
import com.example.studentmanagement.model.TaiKhoanModel;
import com.example.studentmanagement.service.IGiaoVienService;
import com.example.studentmanagement.utils.Helper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public Map<String, Object> save(GiaoVienDTO giaoVienDTO) {
        // Kiểm tra email
        Boolean isCheckEmail = taiKhoanJPA.checkEmail(giaoVienDTO.getEmail());
        if (isCheckEmail) {
            return new HashMap<>(){{
                put("giaoVien", null);
                put("thongBao", "Email đã tồn tại");
            }};
        }

        // Kiểm tra số điện thoại
        Boolean isCheckPhone = taiKhoanJPA.checkPhone(giaoVienDTO.getPhone());
        if (isCheckPhone) {
            return new HashMap<>(){{
                put("giaoVien", null);
                put("thongBao", "Số điện thoại đã tồn tại");
            }};
        }

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
        taiKhoanModel.setPassword("1");

        taiKhoanJPA.save(taiKhoanModel);

        // Lưu giáo viên
        String newMaGV = Helper.generateNewMa(giaoVienJPA.findMaxMaGiaoVien(), "GV");
        giaoVienDTO.setMaGV(newMaGV);
        String currentMaGiaoVien = giaoVienJPA.save(giaoVienDTO);

        return new HashMap<>(){{
            put("giaoVien", giaoVienJPA.findOne(currentMaGiaoVien));
            put("thongBao", "Tạo giáo viên thành công");
        }};
    }

    @Override
    public Map<String, Object> update(GiaoVienDTO giaoVienDTO) {
        TaiKhoanModel taiKhoanModel = new TaiKhoanModel();
        taiKhoanModel.setMaTK(giaoVienDTO.getMaTK());
        taiKhoanModel.setTenTK(giaoVienDTO.getTenTK());
        taiKhoanModel.setNgaySinh(giaoVienDTO.getNgaySinh());
        taiKhoanModel.setEmail(giaoVienDTO.getEmail());
        taiKhoanModel.setPhone(giaoVienDTO.getPhone());
        taiKhoanModel.setRole(giaoVienDTO.getRole());
        taiKhoanModel.setPassword("1");
        taiKhoanJPA.update(taiKhoanModel);

        giaoVienJPA.update(giaoVienDTO);

        return new HashMap<>(){{
            put("giaoVien", giaoVienJPA.findOne(giaoVienDTO.getMaGV()));
            put("thongBao", "Tạo giáo viên thành công");
        }};
    }

    @Override
    public Boolean delete(GiaoVienDTO giaoVienDTO) {
        // Xoá giáo viên
        // Xoá tài khoản
        return giaoVienJPA.delete(giaoVienDTO.getMaGV()) && taiKhoanJPA.delete(giaoVienDTO.getMaTK());
    }

    @Override
    public GiaoVienDTO findAccount(String maTK) { return giaoVienJPA.findAccount(maTK); }
}
