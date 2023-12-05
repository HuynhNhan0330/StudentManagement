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

    @Column(name="TenGV")
    private String tenGV;

    @Column(name="MaKhoa")
    private String maKhoa;

    public GiaoVienModel() {
    }

    public GiaoVienModel(String maGV, String tenGV, String maKhoa) {
        this.maGV = maGV;
        this.tenGV = tenGV;
        this.maKhoa = maKhoa;
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

    public String getMaKhoa() {
        return maKhoa;
    }

    public void setMaKhoa(String maKhoa) {
        this.maKhoa = maKhoa;
    }
}
