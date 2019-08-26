package com.example.apaqtech.manage.service;

import com.example.apaqtech.manage.pojo.SpcWindingData;

import java.util.List;

public interface SpcService<E> {
//应该使用泛型，然后就不需要使用继承了？
//    void insert(String id, Double[] in);
//    void pop(String id);
    SpcWindingData findById(String id);
    List<SpcWindingData> findAll();
    void updateDailyData(String id,String d1, String d2, String d3, String d4, String d5);
}
