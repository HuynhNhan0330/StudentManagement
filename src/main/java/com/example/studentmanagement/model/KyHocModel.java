package com.example.studentmanagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="KYHOC")
public class KyHocModel {
    @Id
    @Column(name="MaKH")
    private String maKH;

    @Column(name="TenKH")
    private String tenKH;

    @Column(name="ThoiGianBatDau")
    private String thoiGianBatDau;

    @Column(name="ThoiGianKetThuc")
    private String thoiGianKetThuc;

    public KyHocModel() {
    }

    public KyHocModel(String maKH, String tenKH, String thoiGianBatDau, String thoiGianKetThuc) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.thoiGianBatDau = thoiGianBatDau;
        this.thoiGianKetThuc = thoiGianKetThuc;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getThoiGianBatDau() {
        return thoiGianBatDau;
    }

    public void setThoiGianBatDau(String thoiGianBatDau) {
        this.thoiGianBatDau = thoiGianBatDau;
    }

    public String getThoiGianKetThuc() {
        return thoiGianKetThuc;
    }

    public void setThoiGianKetThuc(String thoiGianKetThuc) {
        this.thoiGianKetThuc = thoiGianKetThuc;
    }
}
