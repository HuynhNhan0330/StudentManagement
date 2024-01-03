package com.example.studentmanagement.dto;

public class GiaoVienDTO {
    private String maGV;
    private String maKhoa;
    private String tenKhoa;
    private String maTK;
    private String tenTK;
    private String ngaySinh;
    private String email;
    private String phone;
    private String role;

    public GiaoVienDTO() {
    }

    public GiaoVienDTO(String maGV, String maKhoa, String tenKhoa, String maTK, String tenTK, String ngaySinh, String email, String phone, String role) {
        this.maGV = maGV;
        this.maKhoa = maKhoa;
        this.tenKhoa = tenKhoa;
        this.maTK = maTK;
        this.tenTK = tenTK;
        this.ngaySinh = ngaySinh;
        this.email = email;
        this.phone = phone;
        this.role = role;
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

    public String getTenKhoa() {
        return tenKhoa;
    }

    public void setTenKhoa(String tenKhoa) {
        this.tenKhoa = tenKhoa;
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
