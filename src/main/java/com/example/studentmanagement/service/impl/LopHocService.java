package com.example.studentmanagement.service.impl;

import com.example.studentmanagement.dto.LichHocDTO;
import com.example.studentmanagement.dto.LopHocDTO;
import com.example.studentmanagement.jpa.ILopHocJPA;
import com.example.studentmanagement.jpa.impl.LopHocJPA;
import com.example.studentmanagement.model.LopHocModel;
import com.example.studentmanagement.service.ILopHocService;
import com.example.studentmanagement.utils.Helper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LopHocService implements ILopHocService {
    private ILopHocJPA lopHocJPA;

    public LopHocService() {
        lopHocJPA = new LopHocJPA();
    }

    @Override
    public List<LopHocDTO> findAll() {
        return lopHocJPA.findAll();
    }

    @Override
    public List<LopHocDTO> findByLecturer(String maGV) {
        return lopHocJPA.findByLecturer(maGV);
    }

    @Override
    public List<LichHocDTO> findScheduleOfStudent(String maSV) { return lopHocJPA.findScheduleOfStudent(maSV); }

    @Override
    public List<LichHocDTO> findScheduleOfLecturer(String maGV) { return lopHocJPA.findScheduleOfLecturer(maGV); }

    @Override
    public LopHocDTO findOne(String maLop) {
        return lopHocJPA.findOne(maLop);
    }

    @Override
    public Map<String, Object> save(LopHocModel lopHocModel) {
        if (lopHocModel.getThoiGianBatDau() == lopHocModel.getThoiGianKetThuc()) {
            return new HashMap<>(){{
                put("lopHoc", null);
                put("thongBao", "Thời gian bắt đầu trùng với kết thúc");
            }};
        }

        String newMaLop = Helper.generateNewMa(lopHocJPA.findMaxMaLopHoc(), "LH");
        lopHocModel.setMaLop(newMaLop);
        lopHocModel.setMaKH("KH0001");

        // Kiểm tra phòng học có trống giờ đó không
        Boolean isCheckRoom = lopHocJPA.checkRoom(lopHocModel);

        if (!isCheckRoom) {
            return new HashMap<>(){{
                put("lopHoc", null);
                put("thongBao", "Phòng học này đã có người dùng vào thời gian này");
            }};
        }

        // Thời gian đó giáo viên có dạy lớp nào không
        Boolean isCheckTeacher = lopHocJPA.checkTeacher(lopHocModel);

        if (!isCheckTeacher) {
            return new HashMap<>(){{
                put("lopHoc", null);
                put("thongBao", "Giáo viên đã dạy vào thời gian này");
            }};
        }


        String currentMaLop = lopHocJPA.save(lopHocModel);

        return new HashMap<>(){{
            put("lopHoc", lopHocJPA.findOne(currentMaLop));
            put("thongBao", "Tạo lớp thành công");
        }};
    }

    @Override
    public LopHocDTO update(LopHocModel lopHocModel) {
        lopHocJPA.update(lopHocModel);
        return lopHocJPA.findOne(lopHocModel.getMaLop());
    }

    @Override
    public void delete(String maLop) {
        lopHocJPA.delete(maLop);
    }
}
