package com.example.apaqtech.manage.service;

import com.example.apaqtech.manage.pojo.Sheet;

import java.util.List;

//把Sheet有关的层全部变成泛型
public interface SheetService<E> {
//这里不能再SheetService后面写<Sheet> 因为这样就等于<E> ，Sheet就变成了一个任意参数名
    void insert(E sheet);
    void insertAll(List<E> sheets);
    List<Sheet> findAllSheets();

    //这个返回由于要用到Sheet.class 写E的话是E.class会报错
}
