package com.example.studentmanagement.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="KHOA")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "maKhoa")
public class Khoa {
    @Id
    @Column(name="MaKhoa")
    private String maKhoa;

    @Column(name="TenKhoa")
    private String tenKhoa;

    @OneToMany(mappedBy = "khoa", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Nganh> nganhs;

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

    public List<Nganh> getNganhs() {
        return nganhs;
    }

    public void setNganhs(List<Nganh> nganhs) {
        this.nganhs = nganhs;
    }
}
