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

    @Column(name="MaKH")
    private String kyHoc;

    @Column(name="Dau")
    private int dau;

    public ChiTietDangKyModel() {
    }

    public ChiTietDangKyModel(String maSV, String maLop, String kyHoc, int dau) {
        this.maSV = maSV;
        this.maLop = maLop;
        this.kyHoc = kyHoc;
        this.dau = dau;
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

    public String getKyHoc() {
        return kyHoc;
    }

    public void setKyHoc(String kyHoc) {
        this.kyHoc = kyHoc;
    }

    public int getDau() {
        return dau;
    }

    public void setDau(int dau) {
        this.dau = dau;
    }
}
