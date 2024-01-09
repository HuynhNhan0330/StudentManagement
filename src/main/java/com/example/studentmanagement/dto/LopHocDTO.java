package com.example.studentmanagement.dto;

import javax.persistence.Column;

public class LopHocDTO {
    private String maLop;

    private String tenLop;

    private String maGV;

    private String tenGV;

    private String maMH;

    private String tenMH;

    private String ngayHoc;

    private String thoiGianBatDau;

    private String thoiGianKetThuc;

    private String maKH;

    private String tenKH;

    private String maPH;

    private String tenPH;

    private String thoiGianBatDauLH;

    private String thoiGianKetThucLH;

    public LopHocDTO() {
    }

    public LopHocDTO(String maLop, String tenLop, String maGV, String tenGV, String maMH, String tenMH, String ngayHoc, String thoiGianBatDau, String thoiGianKetThuc, String maKH, String tenKH, String maPH, String tenPH, String thoiGianBatDauLH, String thoiGianKetThucLH) {
        this.maLop = maLop;
        this.tenLop = tenLop;
        this.maGV = maGV;
        this.tenGV = tenGV;
        this.maMH = maMH;
        this.tenMH = tenMH;
        this.ngayHoc = ngayHoc;
        this.thoiGianBatDau = thoiGianBatDau;
        this.thoiGianKetThuc = thoiGianKetThuc;
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.maPH = maPH;
        this.tenPH = tenPH;
        this.thoiGianBatDauLH = thoiGianBatDauLH;
        this.thoiGianKetThucLH = thoiGianKetThucLH;
    }

    public String getNgayHoc() {
        return ngayHoc;
    }

    public void setNgayHoc(String ngayHoc) {
        this.ngayHoc = ngayHoc;
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public String getMaGV() {
        return maGV;
    }

    public void setMaGV(String maGV) {
        this.maGV = maGV;
    }

    public String getTenGV() {
        return tenGV;
    }

    public void setTenGV(String tenGV) {
        this.tenGV = tenGV;
    }

    public String getMaMH() {
        return maMH;
    }

    public void setMaMH(String maMH) {
        this.maMH = maMH;
    }

    public String getTenMH() {
        return tenMH;
    }

    public void setTenMH(String tenMH) {
        this.tenMH = tenMH;
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

    public String getMaPH() {
        return maPH;
    }

    public void setMaPH(String maPH) {
        this.maPH = maPH;
    }

    public String getTenPH() {
        return tenPH;
    }

    public void setTenPH(String tenPH) {
        this.tenPH = tenPH;
    }

    public String getThoiGianBatDauLH() {
        return thoiGianBatDauLH;
    }

    public void setThoiGianBatDauLH(String thoiGianBatDauLH) {
        this.thoiGianBatDauLH = thoiGianBatDauLH;
    }

    public String getThoiGianKetThucLH() {
        return thoiGianKetThucLH;
    }

    public void setThoiGianKetThucLH(String thoiGianKetThucLH) {
        this.thoiGianKetThucLH = thoiGianKetThucLH;
    }
}
