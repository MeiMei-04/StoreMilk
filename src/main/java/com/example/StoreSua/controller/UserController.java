/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.StoreSua.controller;

import com.example.StoreSua.auth.SessionManager;
import com.example.StoreSua.model.NguoiDung;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Hieu
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @GetMapping("/detail")
    public String detail(Model model){
        if (!SessionManager.isLogin()) {
            return "redirect:/login";
        }
        model.addAttribute("user", SessionManager.isNguoiDung());
        return "/user/detail.html";
    }
}
