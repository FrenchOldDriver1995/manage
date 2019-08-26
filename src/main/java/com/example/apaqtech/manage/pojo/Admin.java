package com.example.apaqtech.manage.pojo;

import javax.persistence.*;


public class Admin {

    /**
     * 此pojo类为管理员类，拥有比user更高的权限，可以查看user每天的表单检验情况
     */

    private int id ; //人数较少，可以用int


    private String password;


    private String name;

    public Admin(){}

    public Admin(int i, String s, String n){
        this.id = i;
        this.password = s;
        this.name = n;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
