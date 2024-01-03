package com.example.studentmanagement.model;

import javax.persistence.*;

@Entity
@Table(name = "SINHVIEN")
public class SinhVienModel {
    @Id
    @Column(name = "MaSV")
    private String maSV;

    @Column(name = "GioiTinh")
    private String gioiTinh;

    @Column(name = "NamNhapHoc")
    private int namNhapHoc;

    @Column(name="MaNganh")
    private String maNganh;

    @Column(name="MaTK")
    private String maTK;

    public SinhVienModel() {
    }

    public SinhVienModel(String maSV, String gioiTinh, int namNhapHoc, String maNganh, String maTK) {
        this.maSV = maSV;
        this.gioiTinh = gioiTinh;
        this.namNhapHoc = namNhapHoc;
        this.maNganh = maNganh;
        this.maTK = maTK;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
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

    public String getMaTK() {
        return maTK;
    }

    public void setMaTK(String maTK) {
        this.maTK = maTK;
    }
}
