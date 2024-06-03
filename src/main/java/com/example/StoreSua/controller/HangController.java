package com.example.StoreSua.controller;

import com.example.StoreSua.model.Hang;
import com.example.StoreSua.repository.HangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = {"/hang"})
public class HangController {
    @Autowired
    private HangRepository HangRepository;
    @Autowired
    private HangRepository hangRepository;
    private List<Hang> hangList = new ArrayList<>();
    @ModelAttribute("listhang")
    public List<Hang> getHangList() {
        hangList = hangRepository.findAll();
        return hangList;
    }
    @GetMapping("/list")
    public String list(Model model) {
        return "Hang/index";
    }
    @GetMapping("/add")
    public String add() {
        return "Hang/add";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
         Hang hang1 = hangRepository.findById(id).orElseThrow();
         model.addAttribute("datahang", hang1);
         return "Hang/edit";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id,Hang hang) {
        Hang hang1 = hangRepository.findById(id).orElseThrow();
        hang1.setTrangthai(0);
        hangRepository.save(hang1);
        return "redirect:/hang/list";
    }
    @PostMapping("/save")
    public String save(Hang hang) {
        hang.setTrangthai(1);
        hang = HangRepository.save(hang);
        return "redirect:/hang/list";
    }
    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id, Hang hang) {
        Hang hang1 = hangRepository.findById(id).orElseThrow();
        hang1.setTenhang(hang.getTenhang());
        hang1.setTrangthai(1);
        hang1 = hangRepository.save(hang1);
        return "redirect:/hang/list";
    }

}
