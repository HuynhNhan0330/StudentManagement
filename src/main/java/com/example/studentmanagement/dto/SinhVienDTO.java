package com.example.studentmanagement.dto;

public class SinhVienDTO {
    private String maSV;
    private String maNganh;
    private String tenNganh;
    private String maTK;
    private String tenTK;
    private String ngaySinh;
    private String email;
    private String phone;
    private String role;
    private Integer namNhapHoc;
    private String gioiTinh;

    public SinhVienDTO() {
    }

    public SinhVienDTO(String maSV, String maNganh, String tenNganh, String maTK, String tenTK, String ngaySinh, String email, String phone, String role, Integer namNhapHoc, String gioiTinh) {
        this.maSV = maSV;
        this.maNganh = maNganh;
        this.tenNganh = tenNganh;
        this.maTK = maTK;
        this.tenTK = tenTK;
        this.ngaySinh = ngaySinh;
        this.email = email;
        this.phone = phone;
        this.role = role;
        this.namNhapHoc = namNhapHoc;
        this.gioiTinh = gioiTinh;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
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

    public Integer getNamNhapHoc() {
        return namNhapHoc;
    }

    public void setNamNhapHoc(Integer namNhapHoc) {
        this.namNhapHoc = namNhapHoc;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }
}
