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
    private int diem;

    public DiemModel() {
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

    public int getDiem() {
        return diem;
    }

    public void setDiem(int diem) {
        this.diem = diem;
    }
}
