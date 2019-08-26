package com.example.apaqtech.manage.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


public interface SpcData {
    /**
     * 站点号 no_depart (int)
     * 站点名（不强制，有编号即可）
     * 机台号 no_machine (String)
     * 记录时间 time (String)
     * 一组检测数据（5个）testVal （double[]）
     * 通过检测数据自动计算的一些参数 如 平均值avg 等
     * 提前已知的一些上限下限值
     * 记录人员（附加功能，默认可以通过账号自动添加,但不重要）
     *
     */


    void Save();
    void Get();

//    private int no_depart;
//    private String no_machine;
//    private String time;
//    private double[] testVal;
//    private double avg;
//
//    public SpcData(){}
//
//    public SpcData(double[] val){
//        this.testVal = val;
//    }
//
//    public int getNo_depart() {
//        return no_depart;
//    }
//
//    public void setNo_depart(int no_depart) {
//        this.no_depart = no_depart;
//    }
//
//    public String getNo_machine() {
//        return no_machine;
//    }
//
//    public void setNo_machine(String no_machine) {
//        this.no_machine = no_machine;
//    }
//
//    public String getTime() {
//        return time;
//    }
//
//    public void setTime(String time) {
//        this.time = time;
//    }
//
//    public double[] getTestVal() {
//        return testVal;
//    }
//
//    public void setTestVal(double[] testVal) {
//        this.testVal = testVal;
//    }
//
//    public double getAvg() {
//        return avg;
//    }
//
//    public void setAvg(double avg) {
//        this.avg = avg;
//    }
}
