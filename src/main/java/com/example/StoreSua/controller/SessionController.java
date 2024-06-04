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
        String username = nguoiDung != null ? nguoiDung.getHoten(): "";
        Long idcv = nguoiDung.getChucVu().getChucvu_id();
        return new SessionInfo(isLogin, username,idcv);
    }

//    private static class SessionInfo {
//        private boolean login;
//        private String username;
//        private Long idcv;
//
//        public SessionInfo(boolean login, String username, Long idcv) {
//            this.login = login;
//            this.username = username;
//            this.idcv = idcv;
//        }
//
//        public boolean isLogin() {
//            return login;
//        }
//
//        public void setLogin(boolean login) {
//            this.login = login;
//        }
//
//        public String getUsername() {
//            return username;
//        }
//
//        public void setUsername(String username) {
//            this.username = username;
//        }
//
//        public Long getIdcv() {
//            return idcv;
//        }
//
//        public void setIdcv(Long idcv) {
//            this.idcv = idcv;
//        }
//
//        
//
//        
//    }
}
