package com.example.studentmanagement.model;

import javax.persistence.*;

@Entity
@Table(name="LOAIDIEM")
public class LoaiDiemModel {
    @Id
    @Column(name="MaLoaiDiem")
    private String maLoaiDiem;

    @Column(name="TenLoaiDiem")
    private String tenLoaiDiem;

    @Column(name="TiLe")
    private int tiLe;

    public LoaiDiemModel() {
    }

    public LoaiDiemModel(String maLoaiDiem, String tenLoaiDiem, int tiLe) {
        this.maLoaiDiem = maLoaiDiem;
        this.tenLoaiDiem = tenLoaiDiem;
        this.tiLe = tiLe;
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

    public int getTiLe() {
        return tiLe;
    }

    public void setTiLe(int tiLe) {
        this.tiLe = tiLe;
    }
}
