package com.example.user.knuhui.treatment;

public class WaitItem {
    private String dept;
    private String wait;
    private String time;


    public void setDept(String dept){
        this.dept = dept;
    }

    public void setWait(String wait){
        this.wait = wait;
    }

    public void setTime(String time){
        this.time = time;
    }

    public String getDept(){
        return this.dept;
    }

    public String getWait(){
        return this.wait;
    }

    public String getTime(){
        return this.time;
    }
}

