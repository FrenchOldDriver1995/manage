package com.example.apaqtech.manage.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "winding") //钉卷站
public class SpcWindingData implements SpcData{

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

    @Id
    private String no_machine; //应该把机台号当成Id，因为他具有一定的标识作用，并且也会用来查找
    private int no_depart;
    private boolean type; //区分正负箔等
    private String title; //标题,比如Xbar-R管制图
    private String time;
    private double[] testVal; //用ArrayList存储试一试,testVal是每天的数据

    private double UCL; //
    private double LCL;
    private double CLC;
    private double Aplus;
    private double Aminus;

    private String format; //规格
    private String valueFormat;//规格值
    private String testMachine;//测试仪器
    private String testObject;//测试对象
    private String testGenre;//测试特性
    private String testCondition;//测试条件
    private double[] avgLine;//专门平均线走势。
    private double[] rangeLine;// 专门记录跨度线走势
    public boolean isType() {
        return type;
    }


    private List<double[]> record; //感觉要存String，因为要把他们每一行对应的时间存进去



    public void setType(boolean type) {
        this.type = type;
    }

    public void SpcWindingData(){}

    @Override
    public void Save() {

    }

    @Override
    public void Get() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNo_depart() {
        return no_depart;
    }

    public void setNo_depart(int no_depart) {
        this.no_depart = no_depart;
    }

    public String getNo_machine() {
        return no_machine;
    }

    public void setNo_machine(String no_machine) {
        this.no_machine = no_machine;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public double[] getTestVal() {
        return testVal;
    }

    public void setTestVal(double[] testVal) {
        this.testVal = testVal;
    }

    public List<double[]> getRecord() {
        return record;
    }

    public void setRecord(List<double[]> record) {
        //这个Strng[]每一组应该不固定大小
        //每一行分别为年月日，检验数据5个，最大值，最小值，平均值，跨度Range，平均（平均值），平均（跨度值）
        //分左右两张图，左图是avg对应avg（avg）加上上下两条A线，再加上上下两条CL线（Upper Control Line和Low Control Line）
        this.record = record;
    }

    public double getUCL() {
        return UCL;
    }

    public void setUCL(double UCL) {
        this.UCL = UCL;
    }

    public double getLCL() {
        return LCL;
    }

    public void setLCL(double LCL) {
        this.LCL = LCL;
    }

    public double getCLC() {
        return CLC;
    }

    public void setCLC(double CLC) {
        this.CLC = CLC;
    }

    public double getAplus() {
        return Aplus;
    }

    public void setAplus(double aplus) {
        Aplus = aplus;
    }

    public double getAminus() {
        return Aminus;
    }

    public void setAminus(double aminus) {
        Aminus = aminus;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getValueFormat() {
        return valueFormat;
    }

    public void setValueFormat(String valueFormat) {
        this.valueFormat = valueFormat;
    }

    public String getTestMachine() {
        return testMachine;
    }

    public void setTestMachine(String testMachine) {
        this.testMachine = testMachine;
    }

    public String getTestObject() {
        return testObject;
    }

    public void setTestObject(String testObject) {
        this.testObject = testObject;
    }

    public String getTestGenre() {
        return testGenre;
    }

    public void setTestGenre(String testGenre) {
        this.testGenre = testGenre;
    }

    public String getTestCondition() {
        return testCondition;
    }

    public void setTestCondition(String testCondition) {
        this.testCondition = testCondition;
    }

    public double[] getAvgLine() {
        return avgLine;
    }

    public void setAvgLine(double[] avgLine) {
        this.avgLine = avgLine;
    }

    public double[] getRangeLine() {
        return rangeLine;
    }

    public void setRangeLine(double[] rangeLine) {
        this.rangeLine = rangeLine;
    }
}
