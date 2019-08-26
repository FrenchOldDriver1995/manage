package com.example.apaqtech.manage.service;

import com.example.apaqtech.manage.pojo.User;
import com.example.apaqtech.manage.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    //C R U D
    @Autowired
    UserDao userDao;
    public int addUser(User u){
        return userDao.add(u);
    }

    public int updateUser(User u){ return userDao.update(u);}

    public  User getUserById(Integer id){return userDao.getById(id);}

    public int deleteUserById(Integer id){
        return userDao.deleteById(id);
    }


    public List<User> getAllUsers(){
        return userDao.getAll();
    }
}
