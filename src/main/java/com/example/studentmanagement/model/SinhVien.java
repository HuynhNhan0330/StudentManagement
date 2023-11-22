package com.example.studentmanagement.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "SINHVIEN")
public class SinhVien {
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

//    @ManyToOne
//    @JoinColumn(name = "MaNganh", referencedColumnName = "MaNganh", foreignKey = @ForeignKey(name = "FK_SINHVIEN_NGANH"))
//    private Nganh nganh;

    public SinhVien() {
    }

    public SinhVien(String maSV, String tenSV, String ngaySinh, String gioiTinh, int namNhapHoc) {
        this.maSV = maSV;
        this.tenSV = tenSV;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.namNhapHoc = namNhapHoc;
//        this.nganh = nganh;
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

//    public Nganh getNganh() {
//        return nganh;
//    }
//
//    public void setNganh(Nganh nganh) {
//        this.nganh = nganh;
//    }

    public int getNamNhapHoc() {
        return namNhapHoc;
    }

    public void setNamNhapHoc(int namNhapHoc) {
        this.namNhapHoc = namNhapHoc;
    }
}
