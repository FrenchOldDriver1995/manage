package com.example.apaqtech.manage.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;


@Document(collection="sheets")
public class Sheet {

    @Id
    private String id;

    private String sheet_name;

    private String time; //先用String测试

    @Indexed
    private String No_machine;

    private String N0_IPQC;

    private boolean daywork;

    public Sheet(){}

    public Sheet(String i){
        this.id= i;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getSheet_name() {
        return sheet_name;
    }

    public void setSheet_name(String sheet_name) {
        this.sheet_name = sheet_name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getNo_machine() {
        return No_machine;
    }

    public void setNo_machine(String no_machine) {
        No_machine = no_machine;
    }

    public String getN0_IPQC() {
        return N0_IPQC;
    }

    public void setN0_IPQC(String n0_IPQC) {
        N0_IPQC = n0_IPQC;
    }

    public boolean isDaywork() {
        return daywork;
    }

    public void setDaywork(boolean daywork) {
        this.daywork = daywork;
    }
}
