package com.example.apaqtech.manage.dao;


import com.example.apaqtech.manage.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao {
    @Autowired
    JdbcTemplate jdbcTemplate;


    public int add(User u){
        return jdbcTemplate.update("INSERT INTO user(id, password, name) VALUES(?,?,?)",
                u.getId(), u.getPassword(), u.getName());
    }

    public int update(User u){
        return jdbcTemplate.update("update user set password=?, name=? WHERE id=?",
                u.getPassword(),u.getName(), u.getId());
    }

    public User getById(Integer id){
        return jdbcTemplate.queryForObject("select * from user where id=?",
                new BeanPropertyRowMapper<>(User.class), id);
    }


    public int deleteById(Integer id){
        return jdbcTemplate.update("DELETE FROM user where id=?", id);

    }

    public List<User> getAll(){
        return jdbcTemplate.query("select * from user", new BeanPropertyRowMapper<>(User.class));
    }
}
