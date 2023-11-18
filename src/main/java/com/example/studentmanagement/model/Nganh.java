package com.example.studentmanagement.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

@Entity
@Table(name="NGANH")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "maNganh")
public class Nganh {
    @Id
    @Column(name="MaNganh")
    private String maNganh;

    @Column(name="TenNganh")
    private String tenNganh;

    @ManyToOne()
    @JoinColumn(name = "MaKhoa", referencedColumnName = "MaKhoa", foreignKey = @ForeignKey(name = "FK_NGANH_KHOA"))
    @JsonBackReference
    private Khoa khoa;

    public Nganh() {
    }

    public Nganh(String maNganh, String tenNganh, Khoa khoa) {
        this.maNganh = maNganh;
        this.tenNganh = tenNganh;
        this.khoa = khoa;
    }

    public String getMaNganh() {
        return maNganh;
    }

    public void setMaNganh(String maNganh) {
        this.maNganh = maNganh;
    }

    public String getTenNganh() {
        return tenNganh;
    }

    public void setTenNganh(String tenNganh) {
        this.tenNganh = tenNganh;
    }

    public Khoa getKhoa() {
        return khoa;
    }

    public void setKhoa(Khoa khoa) {
        this.khoa = khoa;
    }
}
