package com.example.apaqtech.manage.service;

import com.example.apaqtech.manage.pojo.Admin;

import java.util.List;

public interface AdminService {

    List<Admin> findAll();

    void save(Admin admin);
}
