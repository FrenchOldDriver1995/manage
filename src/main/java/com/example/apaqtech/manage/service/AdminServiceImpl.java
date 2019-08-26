package com.example.apaqtech.manage.service;

import com.example.apaqtech.manage.dao.AdminRepo;
import com.example.apaqtech.manage.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepo adminRepo;

    public AdminServiceImpl(AdminRepo adminRepo){
        this.adminRepo = adminRepo;
    }
    @Override
    public List<Admin> findAll() {

        return adminRepo.findAll();
    }

    @Override
    public void save(Admin admin) {
        adminRepo.save(admin);
    }
}
