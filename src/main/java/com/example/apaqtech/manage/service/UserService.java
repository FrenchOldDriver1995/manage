package com.example.apaqtech.manage.service;

import com.example.apaqtech.manage.pojo.User;

import java.util.List;

public interface UserService {
    int addUser(User u);
    int updateUser(User u);
    User getUserById(Integer id);
    int deleteUserById(Integer id);
    List<User> getAllUsers();

}
