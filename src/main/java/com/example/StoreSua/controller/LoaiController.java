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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
//    @GetMapping("/addlist")
//    public String add(){
//        return "Loai/add.html";
//    }
    @GetMapping("/add")
    public String add(){
        return "Loai/add.html";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model){
        Loai loais = loaiRepository.findById(id).orElseThrow();
        model.addAttribute("loais",loais);
    return "Loai/edit.html";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        Loai loais = loaiRepository.findById(id).orElseThrow();
        loaiRepository.delete(loais);
        return "redirect:/loai/list";
    }
    @PostMapping("/save")
    public String save(Loai loai){
        loaiRepository.save(loai);
        return "redirect:/loai/list";
    }
    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id,  Loai loais) {
        Loai loai = loaiRepository.findById(id).orElseThrow();
        loai.setTenloai(loais.getTenloai());
        loai.setTrangthai(loais.getTrangthai());
        loaiRepository.save(loais);
        return "redirect:/loai/list";
    }
}
