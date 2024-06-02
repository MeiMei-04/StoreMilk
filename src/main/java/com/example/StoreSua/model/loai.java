/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.StoreSua.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 *
 * @author Hieu
 */
@Entity
@Table(name = "Loai")
public class loai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Loai_ID;
    private String TenLoai;
    private int TrangThai;

    public loai() {
    }


    public loai(Long Loai_ID, String TenLoai, int TrangThai) {
        this.Loai_ID = Loai_ID;
        this.TenLoai = TenLoai;
        this.TrangThai = TrangThai;
    }

    public Long getLoai_ID() {
        return Loai_ID;
    }

    public void setLoai_ID(Long Loai_ID) {
        this.Loai_ID = Loai_ID;
    }

    public String getTenLoai() {
        return TenLoai;
    }

    public void setTenLoai(String TenLoai) {
        this.TenLoai = TenLoai;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }

}
