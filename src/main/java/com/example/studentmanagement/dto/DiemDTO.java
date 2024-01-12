package com.example.studentmanagement.dto;

public class DiemDTO {
    private String maSV;
    private String tenSV;
    private String maMH;
    private String tenMH;
    private Float quaTrinh;
    private Float giuaKy;
    private Float cuoiKy;


    public DiemDTO() {
    }

    public DiemDTO(String maSV, String tenSV, String maMH, String tenMH, Float quaTrinh, Float giuaKy, Float cuoiKy) {
        this.maSV = maSV;
        this.tenSV = tenSV;
        this.maMH = maMH;
        this.tenMH = tenMH;
        this.quaTrinh = quaTrinh;
        this.giuaKy = giuaKy;
        this.cuoiKy = cuoiKy;
    }

    public String getTenMH() {
        return tenMH;
    }

    public void setTenMH(String tenMH) {
        this.tenMH = tenMH;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getTenSV() {
        return tenSV;
    }

    public void setTenSV(String tenSV) {
        this.tenSV = tenSV;
    }

    public String getMaMH() {
        return maMH;
    }

    public void setMaMH(String maMH) {
        this.maMH = maMH;
    }

    public Float getQuaTrinh() {
        return quaTrinh;
    }

    public void setQuaTrinh(Float quaTrinh) {
        this.quaTrinh = quaTrinh;
    }

    public Float getGiuaKy() {
        return giuaKy;
    }

    public void setGiuaKy(Float giuaKy) {
        this.giuaKy = giuaKy;
    }

    public Float getCuoiKy() {
        return cuoiKy;
    }

    public void setCuoiKy(Float cuoiKy) {
        this.cuoiKy = cuoiKy;
    }
}
