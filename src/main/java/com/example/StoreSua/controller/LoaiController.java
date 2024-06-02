/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.StoreSua.controller;

import com.example.StoreSua.model.Loai;
import com.example.StoreSua.repository.LoaiRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Hieu
 */
@Controller
@RequestMapping("/loai")
public class LoaiController {
    @Autowired
    LoaiRepository loaiRepository;
    private List<Loai> loais = new ArrayList<>();
    @ModelAttribute("loais")
    public List<Loai> getLoais(){
        loais = loaiRepository.findAll();
        if(loais.isEmpty()){
            System.out.println("ListNull");
        }
        return loais;
    }
    @GetMapping("/list")
    public String list(){
        return "Loai/index.html";
    }
}
