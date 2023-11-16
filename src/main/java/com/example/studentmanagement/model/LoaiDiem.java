package com.example.studentmanagement.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LoaiDiem {
    @Id
    private String maLoaiDiem;
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
