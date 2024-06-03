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
@Table(name = "loai")
public class Loai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Loai_ID;
    private String tenloai;
    private int trangthai;

    public Loai() {
    }

    public Loai(Long Loai_ID, String tenloai, int trangthai) {
        this.Loai_ID = Loai_ID;
        this.tenloai = tenloai;
        this.trangthai = trangthai;
    }

    public Long getLoai_ID() {
        return Loai_ID;
    }

    public void setLoai_ID(Long Loai_ID) {
        this.Loai_ID = Loai_ID;
    }

    public String getTenloai() {
        return tenloai;
    }

    public void setTenloai(String tenloai) {
        this.tenloai = tenloai;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }


    
}
