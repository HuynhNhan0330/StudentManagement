package com.example.studentmanagement.model;

import javax.persistence.*;

@Entity
@Table(name="KHOA")
public class Khoa {
    @Id
    @Column(name="MaKhoa")
    private String maKhoa;

    @Column(name="TenKhoa")
    private String tenKhoa;

    public Khoa() {
    }

    public Khoa(String maKhoa, String tenKhoa) {
        this.maKhoa = maKhoa;
        this.tenKhoa = tenKhoa;
    }

    public String getMaKhoa() {
        return maKhoa;
    }

    public void setMaKhoa(String maKhoa) {
        this.maKhoa = maKhoa;
    }

    public String getTenKhoa() {
        return tenKhoa;
    }

    public void setTenKhoa(String tenKhoa) {
        this.tenKhoa = tenKhoa;
    }
}
