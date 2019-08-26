package com.example.apaqtech.manage.controller;

import com.example.apaqtech.manage.pojo.SpcWindingData;
import com.example.apaqtech.manage.service.ExcelHelper;
import com.example.apaqtech.manage.service.SpcService;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoGridFSException;
import com.mongodb.internal.connection.Time;
import net.minidev.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.time.Year;
import java.util.*;

@RestController
@RequestMapping("/spc")
public class SpcController {

    @Autowired
    SpcService spcService; //使用这个自动注入时，要在对应的Service层注解

    @Autowired
    MongoTemplate mongoTemplate;

    @PostMapping("/insert")
    //@ResponseBody
    public void insert(String id, String d1, String d2, String d3, String d4, String d5){//机台id和5个数据

//        spcService.insert(id, in); //这就push进去了,
        //把avgline也push一下
        //已经将操作语句封装了，这里不要直接使用mongotemplate
//        mongoTemplate.updateMulti(new Query(Criteria.where("_id").is(id)),new Update().push("avgLine",in[10]), SpcWindingData.class, "winding");
        spcService.updateDailyData(id, d1, d2, d3, d4, d5);
    }
    @PostMapping("/findOne")
    public SpcWindingData findOne(String id){
        //这个接口用于查看特定机台具体信息Post

        return spcService.findById(id);
    }

    @GetMapping("/show")
    public List<SpcWindingData> showAll(){


        return spcService.findAll();
    }


    @GetMapping("/pop")
    public void pop(){
//        pop掉最近一次的操作

    }


    @GetMapping("/test")
    public void testService(){

        SpcWindingData sdd =spcService.findById("A10");
//        List<SpcWindingData>  cur= mongoTemplate.find(new Query(Criteria.where("_id").is("A05")),SpcWindingData.class, "winding" ); //
        System.out.println(sdd.getNo_machine()+"   "+sdd.getFormat());
//        mongoTemplate.updateMulti(new Query(Criteria.where("_id").is(id)),new Update().push("record",add1), SpcWindingData.class, "winding");


    }
    //这个返回是否可以通过ID查找之后直接调用该对象自己本身的getRecord方法，不用管class

    public SpcWindingData spcdInitial(String id, String Title,String Format, String text){
        SpcWindingData spcd = new SpcWindingData();
        spcd.setNo_machine(id); //记得每次修改
        spcd.setType(true);
        spcd.setTitle(Title);

        spcd.setFormat(Format);
        spcd.setTestGenre("阻抗");
        spcd.setTestMachine("欧姆测试仪");
        spcd.setTestObject("正箔");


        ExcelHelper eh=new ExcelHelper(text);
        spcd.setRecord(eh.generateToList());//统一加入
        spcd.setAvgLine(eh.getAvg());
        spcd.setRangeLine(eh.getRange());
        System.out.println("success");
        return spcd;
    }

    public void spcPush(String text, String id){
        /**
         * 与项目逻辑操作无关，仅用于将现成的excel内容快速导入到已建成的数据库database中
         */
        String str=text.replaceAll("  "," ");//双空格替换成单空格
        String[] rows=str.replaceAll(",",".").trim().split("\n");
        Double[][] month=new Double[14][22];
        for(int i=0; i<rows.length; i++){
            String[] col =rows[i].trim().split(" "); //1 2 3 4
            for(int j=0; j<22; j++){

                month[i][j]=Double.valueOf(col[j]);
            }

        }

        for(int j=0; j<22; j++){ //j现在是列数
            double[] add1=new double[rows.length+2]; //加两行，为年和月,这个是要放入数据库中的
            for(int i=0; i<add1.length; i++){
                if(i==0)add1[0]=2019;//year
                if(i==1)add1[1]=8;//month
                if(i>=2){//从第二行开始（0，1，2）
                    add1[i]=month[i-2][j];
                    if(i==10){
                        //mongo操作
                        mongoTemplate.updateMulti(new Query(Criteria.where("_id").is(id)),new Update().push("avgLine",month[i-2][j]), SpcWindingData.class, "winding");
                    }
                    if(i==11){
                        //mongo操作
                        mongoTemplate.updateMulti(new Query(Criteria.where("_id").is(id)),new Update().push("rangeLine",month[i-2][j]), SpcWindingData.class, "winding");
                    }
                }
            }
            mongoTemplate.updateMulti(new Query(Criteria.where("_id").is(id)),new Update().push("record",add1), SpcWindingData.class, "winding");
            //复制完之后插入这个record,插入这一行
        }

        System.out.println(" success insert");
    }
}
