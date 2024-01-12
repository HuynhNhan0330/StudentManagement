package com.example.studentmanagement.dto;

public class LichHocDTO {
    private String tenLop;
    private String ngayHoc;
    private String thoiGianBatDau;
    private String thoiGianKetThuc;
    private String thoiGianBatDauMon;
    private String thoiGianKetThucMon;

    public LichHocDTO() {
    }

    public LichHocDTO(String tenLop, String ngayHoc, String thoiGianBatDau, String thoiGianKetThuc, String thoiGianBatDauMon, String thoiGianKetThucMon) {
        this.tenLop = tenLop;
        this.ngayHoc = ngayHoc;
        this.thoiGianBatDau = thoiGianBatDau;
        this.thoiGianKetThuc = thoiGianKetThuc;
        this.thoiGianBatDauMon = thoiGianBatDauMon;
        this.thoiGianKetThucMon = thoiGianKetThucMon;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public String getNgayHoc() {
        return ngayHoc;
    }

    public void setNgayHoc(String ngayHoc) {
        this.ngayHoc = ngayHoc;
    }

    public String getThoiGianBatDau() {
        return thoiGianBatDau;
    }

    public void setThoiGianBatDau(String thoiGianBatDau) {
        this.thoiGianBatDau = thoiGianBatDau;
    }

    public String getThoiGianKetThuc() {
        return thoiGianKetThuc;
    }

    public void setThoiGianKetThuc(String thoiGianKetThuc) {
        this.thoiGianKetThuc = thoiGianKetThuc;
    }

    public String getThoiGianBatDauMon() {
        return thoiGianBatDauMon;
    }

    public void setThoiGianBatDauMon(String thoiGianBatDauMon) {
        this.thoiGianBatDauMon = thoiGianBatDauMon;
    }

    public String getThoiGianKetThucMon() {
        return thoiGianKetThucMon;
    }

    public void setThoiGianKetThucMon(String thoiGianKetThucMon) {
        this.thoiGianKetThucMon = thoiGianKetThucMon;
    }
}
