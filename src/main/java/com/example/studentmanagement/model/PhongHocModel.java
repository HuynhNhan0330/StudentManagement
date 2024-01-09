package com.example.studentmanagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PHONGHOC")
public class PhongHocModel {
    @Id
    @Column(name="MaPH")
    private String maPH;

    @Column(name="TenPH")
    private String tenPH;

    public PhongHocModel() {
    }

    public PhongHocModel(String maPH, String tenPH) {
        this.maPH = maPH;
        this.tenPH = tenPH;
    }

    public String getMaPH() {
        return maPH;
    }

    public void setMaPH(String maPH) {
        this.maPH = maPH;
    }

    public String getTenPH() {
        return tenPH;
    }

    public void setTenPH(String tenPH) {
        this.tenPH = tenPH;
    }
}
