package com.example.apaqtech.manage.dao;

import com.example.apaqtech.manage.pojo.Admin;

import java.util.List;

public interface AdminRepo {

    List<Admin> findAll();

    void save(Admin admin);
}
