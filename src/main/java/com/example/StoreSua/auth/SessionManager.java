/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.StoreSua.auth;

import com.example.StoreSua.model.NguoiDung;

/**
 *
 * @author Hieu
 */
public class SessionManager {
    private static boolean isLogin = false;
    // khai bao nhan vien
    private static NguoiDung nguoiDung = null; 
    public static void login(NguoiDung nguoiDung){
        isLogin = true;
        SessionManager.nguoiDung = nguoiDung;
        
        
    }
    public static boolean isLogin(){
        return isLogin;
    }
    public static NguoiDung isNguoiDung(){
        return SessionManager.nguoiDung;
    }
    public static void logout(){
        isLogin = false;
        //xoa thong tin dang nhap
        SessionManager.nguoiDung = null;
    }
}
