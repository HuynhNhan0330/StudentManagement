package com.example.studentmanagement.dto;

import java.sql.Date;

public class SinhVienDTO {
    private String maSV;
    private String tenSV;
    private String ngaySinh;
    private String gioiTinh;
    private String maNganh;
    private int namNhapHoc;

    public SinhVienDTO() {
    }

    public SinhVienDTO(String maSV, String tenSV, String ngaySinh, String gioiTinh, String maNganh, int namNhapHoc) {
        this.maSV = maSV;
        this.tenSV = tenSV;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.maNganh = maNganh;
        this.namNhapHoc = namNhapHoc;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getTenSV() {
        return tenSV;
    }

    public void setTenSV(String tenSV) {
        this.tenSV = tenSV;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getMaNganh() {
        return maNganh;
    }

    public void setMaNganh(String maNganh) {
        this.maNganh = maNganh;
    }

    public int getNamNhapHoc() {
        return namNhapHoc;
    }

    public void setNamNhapHoc(int namNhapHoc) {
        this.namNhapHoc = namNhapHoc;
    }
}
