
package com.example.user.knuhui.networkmanager.model.reservation.booking.getRevTime;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "result", strict = false)
public class GetRevTimeResult {

    @Element
    private String dataTime;
    @Element(required = false)
    private String firstReservCnt;
    @Element(required = false)
    private String secondReservCnt;
    @Element
    private String availReservCnt;
    @Element
    private String firstAvailReservCnt;
    @Element
    private String secondAvailReservCnt;

    public String getDataTime() {
        return dataTime;
    }

    public void setDataTime(String dataTime) {
        this.dataTime = dataTime;
    }

    public String getFirstReservCnt() {
        return firstReservCnt;
    }

    public void setFirstReservCnt(String firstReservCnt) {
        this.firstReservCnt = firstReservCnt;
    }

    public String getSecondReservCnt() {
        return secondReservCnt;
    }

    public void setSecondReservCnt(String secondReservCnt) {
        this.secondReservCnt = secondReservCnt;
    }

    public String getAvailReservCnt() {
        return availReservCnt;
    }

    public void setAvailReservCnt(String availReservCnt) {
        this.availReservCnt = availReservCnt;
    }

    public String getFirstAvailReservCnt() {
        return firstAvailReservCnt;
    }

    public void setFirstAvailReservCnt(String firstAvailReservCnt) {
        this.firstAvailReservCnt = firstAvailReservCnt;
    }

    public String getSecondAvailReservCnt() {
        return secondAvailReservCnt;
    }

    public void setSecondAvailReservCnt(String secondAvailReservCnt) {
        this.secondAvailReservCnt = secondAvailReservCnt;
    }

    @Override
    public String toString() {
        return "GetRevTimeResult{" +
                "dataTime='" + dataTime + '\'' +
                ", firstReservCnt=" + firstReservCnt +
                ", secondReservCnt=" + secondReservCnt +
                ", availReservCnt='" + availReservCnt + '\'' +
                ", firstAvailReservCnt='" + firstAvailReservCnt + '\'' +
                ", secondAvailReservCnt='" + secondAvailReservCnt + '\'' +
                '}';
    }
}
