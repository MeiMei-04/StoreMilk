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
@Table(name = "chucvu")
public class ChucVu {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long chucvu_id;
    private String tenchucvu;
    private int tranthai;

    public ChucVu() {
    }

    public ChucVu(Long chucvu_id, String tenchucvu, int tranthai) {
        this.chucvu_id = chucvu_id;
        this.tenchucvu = tenchucvu;
        this.tranthai = tranthai;
    }

    public Long getChucvu_id() {
        return chucvu_id;
    }

    public void setChucvu_id(Long chucvu_id) {
        this.chucvu_id = chucvu_id;
    }

    public String getTenchucvu() {
        return tenchucvu;
    }

    public void setTenchucvu(String tenchucvu) {
        this.tenchucvu = tenchucvu;
    }

    public int getTranthai() {
        return tranthai;
    }

    public void setTranthai(int tranthai) {
        this.tranthai = tranthai;
    }
    
}
