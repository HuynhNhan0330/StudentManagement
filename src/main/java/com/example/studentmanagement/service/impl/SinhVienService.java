package com.example.studentmanagement.service.impl;

import com.example.studentmanagement.dto.SinhVienDTO;
import com.example.studentmanagement.jpa.ISinhVienJPA;
import com.example.studentmanagement.jpa.ITaiKhoanJPA;
import com.example.studentmanagement.jpa.impl.SinhVienJPA;
import com.example.studentmanagement.jpa.impl.TaiKhoanJPA;
import com.example.studentmanagement.model.TaiKhoanModel;
import com.example.studentmanagement.service.ISinhVienService;
import com.example.studentmanagement.utils.Helper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SinhVienService implements ISinhVienService {

    private ISinhVienJPA sinhVienJPA;
    private ITaiKhoanJPA taiKhoanJPA;

    public SinhVienService() {
        sinhVienJPA = new SinhVienJPA();
        taiKhoanJPA = new TaiKhoanJPA();
    }

    @Override
    public List<SinhVienDTO> findAll() {
        return sinhVienJPA.findAll();
    }

    @Override
    public SinhVienDTO findOne(String maSinhVien) {
        return sinhVienJPA.findOne(maSinhVien);
    }

    @Override
    public Map<String, Object> save(SinhVienDTO sinhVienDTO) {
        // Kiểm tra email
        Boolean isCheckEmail = taiKhoanJPA.checkEmail(sinhVienDTO.getEmail());
        if (isCheckEmail) {
            return new HashMap<>(){{
                put("sinhVien", null);
                put("thongBao", "Email đã tồn tại");
            }};
        }

        // Kiểm tra số điện thoại
        Boolean isCheckPhone = taiKhoanJPA.checkPhone(sinhVienDTO.getPhone());
        if (isCheckPhone) {
            return new HashMap<>(){{
                put("sinhVien", null);
                put("thongBao", "Số điện thoại đã tồn tại");
            }};
        }

        // Lưu tài khoản
        String newMaTK = Helper.generateNewMa(taiKhoanJPA.findMaxMaTaiKhoan(), "TK");
        sinhVienDTO.setMaTK(newMaTK);

        TaiKhoanModel taiKhoanModel = new TaiKhoanModel();
        taiKhoanModel.setMaTK(newMaTK);
        taiKhoanModel.setTenTK(sinhVienDTO.getTenTK());
        taiKhoanModel.setNgaySinh(sinhVienDTO.getNgaySinh());
        taiKhoanModel.setEmail(sinhVienDTO.getEmail());
        taiKhoanModel.setPhone(sinhVienDTO.getPhone());
        taiKhoanModel.setRole("3");
        taiKhoanJPA.save(taiKhoanModel);

        // Lưu sinh viên
        String newMaSinhVien = Helper.generateNewMa(sinhVienJPA.findMaxMaSinhVien(), "SV");
        sinhVienDTO.setMaSV(newMaSinhVien);
        sinhVienJPA.save(sinhVienDTO);

        return new HashMap<>(){{
            put("sinhVien", sinhVienJPA.findOne(newMaSinhVien));
            put("thongBao", "Tạo giáo viên thành công");
        }};
    }

    @Override
    public SinhVienDTO update(SinhVienDTO sinhVienDTO) {
        sinhVienJPA.update(sinhVienDTO);
        return sinhVienJPA.findOne(sinhVienDTO.getMaSV());
    }

    @Override
    public Boolean delete(String maSinhVien) {
        return sinhVienJPA.delete(maSinhVien);
    }
}
