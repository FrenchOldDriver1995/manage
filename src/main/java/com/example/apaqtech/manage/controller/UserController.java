package com.example.apaqtech.manage.controller;

import com.example.apaqtech.manage.pojo.User;
import com.example.apaqtech.manage.service.UserService;
import com.example.apaqtech.manage.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/user")
//@CrossOrigin(value="http://localhost:8083/user", maxAge = 1800, allowedHeaders = "*")
public class UserController {
    //controller就用于前后端链接

    @Autowired
    UserService userService; //多用面向接口编程

    @GetMapping("/Ops")
    /**
     * 这里不能用post只能用Get ？
     * 应该是改为post的话，前端代码也要相应改成post
     */
    public void userOps(){
        User u1 = new User(5, "123456", "法拉利");
        int i =userService.addUser(u1);
        System.out.println("addUser>>>" + i);
        User u2 = new User(6, "qwertyqwerty", "雪弗兰");
        int j =userService.addUser(u2);
        User u3 = new User(7, "qwertyqwerty", "特斯拉");
        int s =userService.addUser(u3);
        System.out.println("addUser>>>" + j);

    }

    @GetMapping("/add")
    @ResponseBody
    public User addUser(@RequestParam("User") User u){

        userService.addUser(u);
        return u;
    }

    @GetMapping("/show")
    public List<User> user(){ //成功的方法
        System.out.println("all user showed");
        return userService.getAllUsers();

    }

    @GetMapping("/test")
    //@CrossOrigin(value="http://localhost:8083", maxAge = 1800, allowedHeaders = "*")
    public String test(String str){
        return str;
    }
}
