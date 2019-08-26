package com.example.apaqtech.manage.pojo;

public class User {

    private int id ; //人数较少，可以用int

    private String password;

    private String name;

    public User(){}

    public User(int i, String n){
        this.id=i;
        this.name=n;
    }
    public User(int i, String s, String n){
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
