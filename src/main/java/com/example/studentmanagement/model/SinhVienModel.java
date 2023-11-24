package com.example.studentmanagement.model;

import javax.persistence.*;

@Entity
@Table(name = "SINHVIEN")
public class SinhVienModel {
    @Id
    @Column(name = "MaSV")
    private String maSV;

    @Column(name = "TenSV")
    private String tenSV;

    @Column(name = "NgaySinh")
    private String ngaySinh;

    @Column(name = "GioiTinh")
    private String gioiTinh;

    @Column(name = "NamNhapHoc")
    private int namNhapHoc;

    @Column(name="MaNganh")
    private String maNganh;

    public SinhVienModel() {
    }

    public SinhVienModel(String maSV, String tenSV, String ngaySinh, String gioiTinh, int namNhapHoc, String maNganh) {
        this.maSV = maSV;
        this.tenSV = tenSV;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.namNhapHoc = namNhapHoc;
        this.maNganh = maNganh;
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

    public int getNamNhapHoc() {
        return namNhapHoc;
    }

    public void setNamNhapHoc(int namNhapHoc) {
        this.namNhapHoc = namNhapHoc;
    }

    public String getMaNganh() {
        return maNganh;
    }

    public void setMaNganh(String maNganh) {
        this.maNganh = maNganh;
    }
}
