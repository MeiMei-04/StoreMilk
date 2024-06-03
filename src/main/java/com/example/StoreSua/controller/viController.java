/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.StoreSua.controller;

import com.example.StoreSua.model.vi;
import com.example.StoreSua.repository.ViRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 *
 * @author truon
 */
@Controller
@RequestMapping("/vi")
public class viController {
    @Autowired
    ViRepository viRepository;
    @GetMapping("/list")
    public String listVi(Model model) {
            List<vi> viList = viRepository.findAll();
        model.addAttribute("viS",  viList);
        return "Vi/viewVI.html";
    }
    @GetMapping("/add")
    public String addVi() {
        return "Vi/addVi.html";
    }
    @PostMapping("/save")
    public String Save(vi vI){
        vI.setTrangthai(1);
        viRepository.save(vI);

        return "redirect:/vi/list";
    }
    @GetMapping("/")
}
