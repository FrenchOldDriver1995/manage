package com.example.apaqtech.manage.service;

import com.example.apaqtech.manage.dao.SpcDao;
import com.example.apaqtech.manage.pojo.SpcWindingData;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import javax.swing.text.Position;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class SpcServiceImpl<E> implements SpcService<E> {
    /**
     * 先不用泛型或者继承实现。。直接插入SpcWindingData
     */
    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    SpcDao spcDao;

    @Override
    public SpcWindingData findById(String _id){
//        return mongoTemplate.findOne(new Query(Criteria.where("_id").is(_id)),SpcWindingData.class, "winding" );
        return spcDao.findOne(_id);
    }
    @Override
    public List<SpcWindingData> findAll(){
//        return mongoTemplate.findAll(SpcWindingData.class);
        return spcDao.findAll();
    }

    @Override
    public void updateDailyData(String id, String d1, String d2, String d3, String d4, String d5) {
        Double[] in = new Double[14]; //年，月，日，5个数据，最大值，最小值，平均值，跨度, 预留两个位置给平均值的平均值， 跨度的平均值
        Double max=Double.MIN_VALUE;
        Double min=Double.MAX_VALUE;
        in[3]=Double.valueOf(d1);
        max=Math.max(max,in[3]);
        min=Math.min(min,in[3]);
        in[4]=Double.valueOf(d2);
        max=Math.max(max,in[4]);
        min=Math.min(min,in[4]);
        in[5]=Double.valueOf(d3);
        max=Math.max(max,in[5]);
        min=Math.min(min,in[5]);
        in[6]=Double.valueOf(d4);
        max=Math.max(max,in[6]);
        min=Math.min(min,in[6]);
        in[7]=Double.valueOf(d5);
        max=Math.max(max,in[7]);
        min=Math.min(min,in[7]);
        in[8]=max;
        in[9]=min;
        in[10]=(in[3]+in[4]+in[5]+in[6]+in[7])/5;
        in[11]=(max-min); //跨度

        in[12]=0.0;//占位
        in[13]=0.0;//占位
        Date today = new Date();
        Calendar cal= Calendar.getInstance();
        cal.setTime(today);
        in[2]=(double)cal.get(Calendar.DAY_OF_MONTH);
        in[1]=(double)(cal.get(Calendar.MONTH)+1);
        in[0]=(double)cal.get(Calendar.YEAR);
        spcDao.insert(id, in);
//        mongoTemplate.updateMulti(new Query(Criteria.where("_id").is(id)),new Update().push("record", in), SpcWindingData.class, "winding");



    }
//
//    @Override
//    public void pop(String id) {
//        //pop 删掉该界面中最近一天的数据
////        UpdateResult updateResult = mongoTemplate.updateMulti(new Query(Criteria.where("_id").is(id)), new Update().pop("record", 1), SpcWindingData.class, "winding");
//    }


}
