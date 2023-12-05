package com.example.studentmanagement.model;

import javax.persistence.*;
import java.io.Serializable;

class ChiTietDangKyId implements Serializable {
    private String maSV;
    private String maLop;
}

@Entity
@Table(name="CHITIETDANGKY")
@IdClass(ChiTietDangKyId.class)
public class ChiTietDangKyModel {
    @Id
    @Column(name="MaSV")
    private String maSV;

    @Column(name="MaLop")
    private String maLop;

    @Column(name="KyHoc")
    private int kyHoc;

    public ChiTietDangKyModel() {
    }

    public ChiTietDangKyModel(String maSV, String maLop, int kyHoc) {
        this.maSV = maSV;
        this.maLop = maLop;
        this.kyHoc = kyHoc;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public int getKyHoc() {
        return kyHoc;
    }

    public void setKyHoc(int kyHoc) {
        this.kyHoc = kyHoc;
    }
}
