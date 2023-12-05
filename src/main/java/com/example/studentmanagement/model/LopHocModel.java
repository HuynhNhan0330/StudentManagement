package com.example.studentmanagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="LOPHOC")
public class LopHocModel {

    @Id
    @Column(name="MaLop")
    private String maLop;

    @Column(name="TenLop")
    private String tenLop;

    @Column(name="MaGV")
    private String maGV;

    @Column(name="MaMH")
    private String maMH;

    @Column(name="ThoiGian")
    private String thoiGian;

    public LopHocModel() {
    }

    public LopHocModel(String maLop, String tenLop, String maGV, String maMH, String thoiGian) {
        this.maLop = maLop;
        this.tenLop = tenLop;
        this.maGV = maGV;
        this.maMH = maMH;
        this.thoiGian = thoiGian;
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public String getMaMH() {
        return maMH;
    }

    public void setMaMH(String maMH) {
        this.maMH = maMH;
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

    public String getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
    }
}
