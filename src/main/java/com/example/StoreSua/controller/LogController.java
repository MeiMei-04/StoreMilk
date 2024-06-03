package com.example.StoreSua.controller;

import com.example.StoreSua.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogController {

    @Autowired
    private LogService logService;

    @GetMapping("/logs")
    public String showLogs(Model model) {
        model.addAttribute("logs", logService.getAllLogs());
        return "log/index";
    }
}
