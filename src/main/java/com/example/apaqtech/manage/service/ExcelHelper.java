package com.example.apaqtech.manage.service;

import java.util.ArrayList;
import java.util.List;

public class ExcelHelper {
    //通过该方法将Excel内容导入到Spc的类实例中，然后方便插入数据库
    //该方法一次性将某一张Excel中某一个spc表的数据插入，但两张表不能直接插入
    String text;

    List record;
    double[][] month;
    double[] avg;//存一条平均线
    double[] Range ;//存range线走势图，遍历的时候直接获取了，不要前面又算一遍
    public ExcelHelper(){}
    public ExcelHelper(String text){

        this.text=text.replaceAll("  "," ");//双空格替换成单空格
         month= new double[14][28];
         record=new ArrayList();
    }

    public String[] generate(){
        //生成数组,按行切割
        return this.text.replaceAll(",",".").trim().split("\n");

    }
    public List generateToList(){
        String[] rows=generate();

        for(int i=0; i<rows.length; i++){
            String[] col =rows[i].trim().split(" "); //1 2 3 4
            for(int j=0; j<28; j++){

                month[i][j]=Double.valueOf(col[j]);
            }

        }
        avg=new double[month[0].length];
        Range=new double[month[0].length];

        //month就把每个月的数据存储好了，但是我们加入的时候直接按每列输入就行
        for(int j=0; j<28; j++){ //j现在是列数
            double[] add1=new double[rows.length+2]; //加两行，为年和月,这个是要放入数据库中的
            for(int i=0; i<add1.length; i++){
                if(i==0)add1[0]=2019;//year
                if(i==1)add1[1]=7;//month
                if(i>=2){//从第二行开始（0，1，2）
                    add1[i]=month[i-2][j];
                    if(i==10)avg[j] = month[i-2][j];
                    if(i==11)Range[j] = month[i-2][j];
                }
            }
            record.add(add1); //复制完之后插入这个record
        }

        return record;

    }

    public double[] getAvg() {
        return avg;
    }
//
//    public void setAvg(double[] avg) {
//        this.avg = avg;
//    }

    public double[] getRange() {
        return Range;
    }
//
//    public void setRange(double[] range) {
//        Range = range;
//    }
}
