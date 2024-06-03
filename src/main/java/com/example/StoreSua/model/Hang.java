package com.example.StoreSua.model;

import jakarta.persistence.*;

@Entity
@Table(name = "hang")
public class Hang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hang_id;
    private String tenhang;
    private int trangthai;
    public Hang() {

    }
    public Hang(String tenhang, int trangthai) {
        this.tenhang = tenhang;
        this.trangthai = trangthai;

    }
    public Long getHang_id() {
        return hang_id;
    }
    public void setHang_id(Long hang_id) {
        this.hang_id = hang_id;
    }
    public String getTenhang() {
        return tenhang;
    }
    public void setTenhang(String tenhang) {
        this.tenhang = tenhang;
    }
    public int getTrangthai() {
        return trangthai;
    }
    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }

}
