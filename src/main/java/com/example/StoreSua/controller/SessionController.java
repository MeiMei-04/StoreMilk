/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.StoreSua.controller;

import com.example.StoreSua.auth.SessionInfo;
import com.example.StoreSua.auth.SessionManager;
import com.example.StoreSua.model.NguoiDung;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Hieu
 */
@RestController
public class SessionController {
    @GetMapping("/session-info")
    public SessionInfo getSessionInfo() {
        boolean isLogin = SessionManager.isLogin();
        NguoiDung nguoiDung = SessionManager.isNguoiDung();
        if(nguoiDung == null){
            return new SessionInfo(false, null,null);
        }
        String username = nguoiDung.getHoten();
        Long idcv = nguoiDung.getChucVu().getChucvu_id();
        return new SessionInfo(isLogin, username,idcv);
    }
}
