package com.example.studentmanagement.model;

import javax.persistence.*;
import java.io.Serializable;

class DiemId implements Serializable {
    private String maSV;
    private String maMH;
    private String maLoaiDiem;
}

@Entity
@Table(name="DIEM")
@IdClass(DiemId.class)
public class DiemModel {
    @Id
    @Column(name="MaSV")
    private String maSV;

    @Id
    @Column(name="MaMH")
    private String maMH;

    @Id
    @Column(name="MaLoaiDiem")
    private String maLoaiDiem;

    @Column(name="Diem")
    private Float diem;

    public DiemModel() {
    }

    public DiemModel(String maSV, String maMH, String maLoaiDiem, Float diem) {
        this.maSV = maSV;
        this.maMH = maMH;
        this.maLoaiDiem = maLoaiDiem;
        this.diem = diem;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getMaMH() {
        return maMH;
    }

    public void setMaMH(String maMH) {
        this.maMH = maMH;
    }

    public String getMaLoaiDiem() {
        return maLoaiDiem;
    }

    public void setMaLoaiDiem(String maLoaiDiem) {
        this.maLoaiDiem = maLoaiDiem;
    }

    public Float getDiem() {
        return diem;
    }

    public void setDiem(Float diem) {
        this.diem = diem;
    }
}
