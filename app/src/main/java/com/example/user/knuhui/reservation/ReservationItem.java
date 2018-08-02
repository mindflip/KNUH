package com.example.user.knuhui.reservation;

public class ReservationItem {
    private String dept;
    private String doctor;
    private String date;
    private String time;

    public void setDept(String dept){
        this.dept = dept;
    }

    public void setDoctor(String doctor){
        this.doctor = doctor;
    }

    public void setDate(String date){
        this.date = date;
    }

    public void setTime(String time){
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public String getDept() {
        return dept;
    }

    public String getDoctor() {
        return doctor;
    }

    public String getTime() {
        return time;
    }
}
