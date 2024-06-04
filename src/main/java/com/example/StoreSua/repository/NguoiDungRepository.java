/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.StoreSua.repository;

import com.example.StoreSua.model.NguoiDung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Hieu
 */
@Repository
public interface NguoiDungRepository extends JpaRepository<NguoiDung, Long> {
//NguoiDung findByTaikhoanAndMatkhau(String taikhoan, String matkhau);
//    @Query("Select n from nguoidung n where n.taikhoan = :username and n.matkhau = :password")
//    public NguoiDung findOneByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    @Query("SELECT n FROM NguoiDung n WHERE n.taikhoan = :username AND n.matkhau = :password")
    NguoiDung findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}
