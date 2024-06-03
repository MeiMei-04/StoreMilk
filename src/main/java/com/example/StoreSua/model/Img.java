package com.example.StoreSua.model;

import jakarta.persistence.*;

@Entity
@Table(name = "img")
public class Img {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long img_id;
    public String linkimg;
    private String tenanhimg;
    private int trangthai;

    public Img() {
    }

    public Img(Long img_id, String linkimg, String tenanhimg, int trangthai) {
        this.img_id = img_id;
        this.linkimg = linkimg;
        this.tenanhimg = tenanhimg;
        this.trangthai = trangthai;
    }

    public Long getImg_id() {
        return img_id;
    }

    public void setImg_id(Long img_id) {
        this.img_id = img_id;
    }

    public String getLinkimg() {
        return linkimg;
    }

    public void setLinkimg(String linkimg) {
        this.linkimg = linkimg;
    }

    public String getTenanhimg() {
        return tenanhimg;
    }

    public void setTenanhimg(String tenanhimg) {
        this.tenanhimg = tenanhimg;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }
}
