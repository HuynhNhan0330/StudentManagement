package com.example.studentmanagement.model;

import javax.persistence.*;

@Entity
@Table(name="LOAIDIEM")
public class LoaiDiem {
    @Id
    @Column(name="MaLoaiDiem")
    private String maLoaiDiem;

    @Column(name="TenLoaiDiem")
    private String tenLoaiDiem;

    public LoaiDiem() {
    }

    public LoaiDiem(String maLoaiDiem, String tenLoaiDiem) {
        this.maLoaiDiem = maLoaiDiem;
        this.tenLoaiDiem = tenLoaiDiem;
    }

    public String getMaLoaiDiem() {
        return maLoaiDiem;
    }

    public void setMaLoaiDiem(String maLoaiDiem) {
        this.maLoaiDiem = maLoaiDiem;
    }

    public String getTenLoaiDiem() {
        return tenLoaiDiem;
    }

    public void setTenLoaiDiem(String tenLoaiDiem) {
        this.tenLoaiDiem = tenLoaiDiem;
    }
}
