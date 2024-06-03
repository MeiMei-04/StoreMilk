package com.example.StoreSua.controller;

import com.example.StoreSua.model.Img;
import com.example.StoreSua.repository.ImgRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/upload")
public class ImgController {
    @Autowired
    private ImgRepository imgRepository;
    private List<Img> imgList = new ArrayList<>();
    @ModelAttribute("dataimg")
    public List<Img> getDataimg() {
        return imgList = imgRepository.findAll();
    }
    @Value("${imgbb.api.key}")
    private String apiKey;

    @GetMapping("/list")
    public String list() {
        return "img/index";
    }
//    @GetMapping("/edit/{id}")
//    public String edit(@PathVariable Long id, Model model) {
//        Img img = imgRepository.findById(id).orElseThrow();
//        model.addAttribute("imgs", img);
//        return "img/edit";
//    }
    @GetMapping("/add")
    public String add() {
        return "img/add";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id,Img img) {
        img = imgRepository.findById(id).orElseThrow();
        img.setTrangthai(0);
        imgRepository.save(img);
        return "redirect:/upload/list";
    }
    @PostMapping("/save")
    public String save(Img img) {
        img.setTrangthai(1);
        img = imgRepository.save(img);
        return "redirect:/upload/list";
    }
//    @PostMapping("/update/{id}")
//    public String update(@PathVariable Long id, @ModelAttribute("imgs") Img img) {
//        Img imgToUpdate = imgRepository.findById(id).orElseThrow();
//        imgToUpdate.setLinkimg(img.getLinkimg());
//        imgToUpdate.setTenanhimg(img.getTenanhimg());
//        imgToUpdate = imgRepository.save(imgToUpdate);
//        return "redirect:/upload/list";
//    }
    @PostMapping("/image")
    public String uploadImage(@RequestParam("image") MultipartFile image, Model model) {
        if (image.isEmpty()) {
            model.addAttribute("message", "Please select a file to upload.");
            return "img/add";
        }

        try {
            byte[] bytes = image.getBytes();
            String base64Image = Base64.getEncoder().encodeToString(bytes);

            RestTemplate restTemplate = new RestTemplate();
            String url = "https://api.imgbb.com/1/upload";

            MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
            body.add("key", apiKey);
            body.add("image", base64Image);

            ResponseEntity<Map> response = restTemplate.postForEntity(url, body, Map.class);
            Map<String, Object> responseBody = response.getBody();
            if (responseBody != null && responseBody.get("data") != null) {
                Map<String, Object> data = (Map<String, Object>) responseBody.get("data");
                String imageUrl = (String) data.get("url");
                model.addAttribute("imageUrl", imageUrl);
            } else {
                model.addAttribute("message", "An error occurred while uploading the file.");
            }

        } catch (IOException e) {
            e.printStackTrace();
            model.addAttribute("message", "An error occurred while uploading the file.");
        }
        return "img/add";
    }

}
