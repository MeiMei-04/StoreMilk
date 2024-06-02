/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.StoreSua.auth;

/**
 *
 * @author Hieu
 */
public class SessionManager {
    private static boolean isLogin = false;
    // khai bao nhan vien
    public static void login(){
        isLogin = true;
        //set thong tin nhan vien
    }
    public static boolean isLogin(){
        return isLogin;
    }
//    public static nhanvien isNhanVien(){
//        return "";
//    }
    public static void logout(){
        isLogin = false;
        //xoa thong tin dang nhap
    }
}
