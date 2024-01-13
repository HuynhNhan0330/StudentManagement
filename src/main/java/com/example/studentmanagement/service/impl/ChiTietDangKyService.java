package com.example.studentmanagement.service.impl;

import com.example.studentmanagement.dto.LopHocDTO;
import com.example.studentmanagement.jpa.IChiTietDangKyJPA;
import com.example.studentmanagement.jpa.IDiemJPA;
import com.example.studentmanagement.jpa.ILopHocJPA;
import com.example.studentmanagement.jpa.impl.ChiTietDangKyJPA;
import com.example.studentmanagement.jpa.impl.DiemJPA;
import com.example.studentmanagement.jpa.impl.LopHocJPA;
import com.example.studentmanagement.model.ChiTietDangKyModel;
import com.example.studentmanagement.model.DiemModel;
import com.example.studentmanagement.service.IChiTietDangKyService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChiTietDangKyService implements IChiTietDangKyService {
    private IChiTietDangKyJPA chiTietDangKyJPA;
    private IDiemJPA diemJPA;
    private ILopHocJPA lopHocJPA;

    public ChiTietDangKyService() {
        chiTietDangKyJPA = new ChiTietDangKyJPA();
        diemJPA = new DiemJPA();
        lopHocJPA = new LopHocJPA();
    }

    @Override
    public List<ChiTietDangKyModel> findAll() {
        return chiTietDangKyJPA.findAll();
    }

    @Override
    public ChiTietDangKyModel findOne(String maSV, String maLop) {
        return chiTietDangKyJPA.findOne(maSV, maLop);
    }

    @Override
    public Map<String, Object> save(String maSV, LopHocDTO lopHocDTO) {
        // Check lịch học của sinh viên
        Boolean checkS = lopHocJPA.checkStudent(maSV, lopHocDTO);
        if (!checkS) {
            return new HashMap<>(){{
                put("ctdk", null);
                put("thongBao", "Sinh viên đã có lịch học trùng với lớp học này");
            }};
        }

        // Tạo đăng ký
        ChiTietDangKyModel chiTietDangKyModel = new ChiTietDangKyModel();
        chiTietDangKyModel.setKyHoc("KH0001");
        chiTietDangKyModel.setMaSV(maSV);
        chiTietDangKyModel.setMaLop(lopHocDTO.getMaLop());
        chiTietDangKyModel.setDau(0);

        chiTietDangKyJPA.save(chiTietDangKyModel);

        // Tạo điểm
        DiemModel quaTrinh = new DiemModel();
        DiemModel giuaKy = new DiemModel();
        DiemModel cuoiKy = new DiemModel();

        quaTrinh.setMaSV(maSV);
        giuaKy.setMaSV(maSV);
        cuoiKy.setMaSV(maSV);

        quaTrinh.setMaMH(lopHocDTO.getMaMH());
        giuaKy.setMaMH(lopHocDTO.getMaMH());
        cuoiKy.setMaMH(lopHocDTO.getMaMH());

        quaTrinh.setMaLoaiDiem("LD0001");
        giuaKy.setMaLoaiDiem("LD0002");
        cuoiKy.setMaLoaiDiem("LD0003");

        quaTrinh.setDiem(0F);
        giuaKy.setDiem(0F);
        cuoiKy.setDiem(0F);

        diemJPA.save(quaTrinh);
        diemJPA.save(giuaKy);
        diemJPA.save(cuoiKy);

        return new HashMap<>(){{
            put("ctdk", diemJPA.findOne(maSV, lopHocDTO.getMaMH()));
            put("thongBao", "Đăng ký vào lớp thành công");
        }};
    }

    @Override
    public ChiTietDangKyModel update(ChiTietDangKyModel chiTietDangKyModel) {
        chiTietDangKyJPA.update(chiTietDangKyModel);
        return chiTietDangKyJPA.findOne(chiTietDangKyModel.getMaSV(), chiTietDangKyModel.getMaLop());
    }

    @Override
    public void delete(String maSV, LopHocDTO lopHocDTO) {
        // Xoá chi tiết đăng ký
        chiTietDangKyJPA.delete(maSV, lopHocDTO.getMaLop());

        // Xoá điểm
        diemJPA.delete(maSV, lopHocDTO.getMaMH(), "LD0001");
        diemJPA.delete(maSV, lopHocDTO.getMaMH(), "LD0002");
        diemJPA.delete(maSV, lopHocDTO.getMaMH(), "LD0003");
    }
}
