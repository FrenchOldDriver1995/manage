package com.example.apaqtech.manage.controller;

import com.example.apaqtech.manage.pojo.Sheet;
import com.example.apaqtech.manage.service.SheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/sheet")
//@CrossOrigin(value="http://localhost:8083", maxAge = 1800, allowedHeaders = "*")
public class SheetController {

    /**
     * 通过该controller中的MongoTemplate控制代码可以实现对数据库的写入和网页读取功能,
     * SheetService中的MongoTemplate加上注解之后，这里才能够使用
     */


    @Autowired
    private SheetService sheetService;

    @Autowired
    private MongoTemplate mongoTemplate;

//    @GetMapping("/test")
//    public void testMongo(){ //mongoTemplate这里直接能使用，但还是应该Service层包装一下较好
//        List<Sheet> sheets = new ArrayList<>();
//        Sheet s1 = new Sheet();
//        s1.setId("jaascxxxxx");
//        s1.setSheet_name("daily test");
//        s1.setTime("2019-07-17");
//
//        sheets.add(s1);
//        Sheet s2 = new Sheet();
//        s2.setId("sheet object perfect");
//        s2.setSheet_name("daily test, too");
//        s2.setTime("2019-07-17");
//        sheets.add(s2);
//
//        mongoTemplate.insertAll(sheets);
//        List<Sheet> res = mongoTemplate.findAll(Sheet.class);
//        System.out.println(res);
//        Sheet sheet = mongoTemplate.findById("sheet object", Sheet.class);
//        System.out.println(sheet);
//    }

    @GetMapping("/test2")
    public void testService(){
        //既然直接在这一层用template可以成功，那么用service应该也可以
        List<Sheet> ss = new ArrayList<>();
//        Sheet s1 = new Sheet();
//        s1.setId("Sheet_service_test");
//        s1.setSheet_name("daily xxxxxx");
//        s1.setTime("2019-07-17 16:30:00");

//        ss.add(s1);
        Sheet s2 = new Sheet();
        s2.setId("day2 test");
        s2.setSheet_name("daily test, another");
        s2.setTime("2019-07-17 16:30:40");
        s2.setDaywork(true);
        s2.setN0_IPQC("AXX1902");
        ss.add(s2);
        sheetService.insertAll(ss);
        List<Sheet> res = sheetService.findAllSheets();
        System.out.println(res);
    }


    @GetMapping("/add")
    @ResponseBody
    public Sheet addSheet(@RequestBody Sheet sheet){

        sheetService.insert(sheet);
        System.out.println("added sheet + " + sheet.getSheet_name());

        return sheet;
    }

    @GetMapping("/insert")
    @ResponseBody
    public void ParamTest(@RequestParam("id") String id, @RequestParam("name") String name){
        Sheet s = new Sheet();
        s.setId(id);
        s.setSheet_name(name);
        sheetService.insert(s);
        System.out.println("successfully inserted");
    }

    @GetMapping("/show")
    public List<Sheet> add(){ //该方法已成功

        return sheetService.findAllSheets();
        //使用service前 记得在service中给MongoTemplate加上@Autowired
//        return mongoTemplate.findAll(Sheet.class);
    }




}
