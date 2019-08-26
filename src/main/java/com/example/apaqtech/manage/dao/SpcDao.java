package com.example.apaqtech.manage.dao;


import com.example.apaqtech.manage.pojo.SpcWindingData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SpcDao {

    @Autowired
    MongoTemplate mongoTemplate;


    public void insert(String id, Double[] in){

        //把每日数据组 in 推入push 到 record中
        mongoTemplate.updateMulti(new Query(Criteria.where("_id").is(id)),new Update().push("record", in), SpcWindingData.class, "winding");
    }

    public SpcWindingData findOne(String _id){
        return mongoTemplate.findOne(new Query(Criteria.where("_id").is(_id)),SpcWindingData.class, "winding" );
    }

    public List<SpcWindingData> findAll(){
        return mongoTemplate.findAll(SpcWindingData.class);
    }


}
