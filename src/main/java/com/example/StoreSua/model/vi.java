/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.StoreSua.model;

import jakarta.persistence.*;

/**
 *
 * @author truon
 */
@Entity
@Table(name = "vi")
public class vi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vi_id;
    private String tenvi;
    private int trangthai;

    public vi() {
    }

    public vi(Long vi_id, String tenvi, int trangthai) {
        this.vi_id = vi_id;
        this.tenvi = tenvi;
        this.trangthai = trangthai;
    }

    public Long getVi_id() {
        return vi_id;
    }

    public void setVi_id(Long vi_id) {
        this.vi_id = vi_id;
    }

    public String getTenvi() {
        return tenvi;
    }

    public void setTenvi(String tenvi) {
        this.tenvi = tenvi;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }


}
