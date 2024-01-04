package com.example.studentmanagement.model;

import javax.persistence.*;

@Entity
@Table(name = "TAIKHOAN")
public class TaiKhoanModel {
    @Id
    @Column(name = "MaTK")
    private String maTK;

    @Column(name = "TenTK")
    private String tenTK;

    @Column(name = "NgaySinh")
    private String ngaySinh;

    @Column(name = "Email")
    private String email;

    @Column(name = "Phone")
    private String phone;

    @Column(name="Role")
    private String role;

    @Column(name="Password")
    private String password;

    public TaiKhoanModel() {
    }

    public TaiKhoanModel(String maTK, String tenTK, String ngaySinh, String email, String phone, String role, String password) {
        this.maTK = maTK;
        this.tenTK = tenTK;
        this.ngaySinh = ngaySinh;
        this.email = email;
        this.phone = phone;
        this.role = role;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMaTK() {
        return maTK;
    }

    public void setMaTK(String maTK) {
        this.maTK = maTK;
    }

    public String getTenTK() {
        return tenTK;
    }

    public void setTenTK(String tenTK) {
        this.tenTK = tenTK;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
