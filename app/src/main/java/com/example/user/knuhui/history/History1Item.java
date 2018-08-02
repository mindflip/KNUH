package com.example.user.knuhui.history;

public class History1Item {
    private String dept;
    private String doctor;
    private String date;

    public void setDate(String date) {
        this.date = date;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
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
}
