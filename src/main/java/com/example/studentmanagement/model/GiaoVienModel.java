package com.example.studentmanagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="GiaoVien")
public class GiaoVienModel {
    @Id
    @Column(name="MaGV")
    private String maGV;

    @Column(name="MaKhoa")
    private String maKhoa;

    @Column(name="MaTK")
    private String maTK;

    public GiaoVienModel() {
    }

    public GiaoVienModel(String maGV, String maKhoa, String maTK) {
        this.maGV = maGV;
        this.maKhoa = maKhoa;
        this.maTK = maTK;
    }

    public String getMaTK() {
        return maTK;
    }

    public void setMaTK(String maTK) {
        this.maTK = maTK;
    }

    public String getMaGV() {
        return maGV;
    }

    public void setMaGV(String maGV) {
        this.maGV = maGV;
    }

    public String getMaKhoa() {
        return maKhoa;
    }

    public void setMaKhoa(String maKhoa) {
        this.maKhoa = maKhoa;
    }
}
