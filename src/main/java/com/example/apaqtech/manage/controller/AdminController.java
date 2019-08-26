package com.example.apaqtech.manage.controller;


import com.example.apaqtech.manage.pojo.Admin;
import com.example.apaqtech.manage.service.AdminService;
import com.example.apaqtech.manage.service.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@RestController
//public class AdminController {
//
//
//    AdminService adminService;
//
//    @GetMapping("/Admin")
//    public List<Admin> AdminOps(){
//        Admin a = new Admin();
//        a.setId(02);
//        a.setPassword("testpwd");
//        a.setName("testor");
//
//        adminService.save(a);
//
//        return adminService.findAll();
//    }
//
//}
