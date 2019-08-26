package com.example.apaqtech.manage.service;


import com.example.apaqtech.manage.pojo.Sheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

@Service
public class SheetServiceImpl<E> implements SheetService<E>{


    private Class<E> entityClass;

    //对于Sheet这里模仿共享单车中的方法，不需要Dao层，直接Service和Dao层在一起
    @Autowired //如果这里不注入，SheetService中无法使用
    MongoTemplate mongoTemplate;

    //这个Template有很多方法可以扩展


    public SheetServiceImpl(){
//        try{
//            //这里会报错无法转型
//            Type type = this.getClass().getGenericSuperclass();
//            ParameterizedType ptype=(ParameterizedType)type;
//            Type[] types = ptype.getActualTypeArguments();
//            if(types.length > 0)
//                entityClass = (Class<E>)types[0];
//
//            for(Type t : types){
//                System.out.println(t.toString());
//            }
//        }catch(Exception ex){
//            ex.printStackTrace();
//        }
    }
    @Override
    public void insert(E sheet) {
        mongoTemplate.insert(sheet);
    }

    @Override
    public void insertAll(List<E> sheets) {
        mongoTemplate.insertAll(sheets);
    }


    @Override
    public List<Sheet> findAllSheets() {
        /**
         * 这个方法尽量不要修改成泛型方法，实在不行就多写重复代码了。。
         */
        return mongoTemplate.findAll(Sheet.class);


    }



}
