/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.StoreSua.controller;

import com.example.StoreSua.model.NguoiDung;
import com.example.StoreSua.repository.NguoiDungRepository;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Hieu
 */
@Controller
public class loginController {

    @Autowired
    NguoiDungRepository nguoiDungRepository;
    NguoiDung nguoiDung = null;

    @GetMapping("/login")
    public String login() {
        return "/login/login.html";
    }

    @PostMapping("/login")
    public String login(@RequestParam("taikhoan") String taikhoan,@RequestParam("matkhau") String matkhau,Model model) {
        System.out.println(taikhoan);
        String textFail = null;
        this.nguoiDung = nguoiDungRepository.findByUsernameAndPassword(taikhoan, matkhau);
        if (this.nguoiDung == null) {
            System.out.println("Login fail");
            textFail = "Login Fail";
        }
        else{
            System.out.println("Login true");
            textFail = "Login True";
        }
        model.addAttribute("textFail", textFail);
        return "/login/login.html"; 
    }
}
