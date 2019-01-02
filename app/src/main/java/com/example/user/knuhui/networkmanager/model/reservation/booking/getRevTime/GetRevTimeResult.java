
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
    @Element
    private List<Object> firstReservCnt = null;
    @Element
    private List<Object> secondReservCnt = null;
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

    public List<Object> getFirstReservCnt() {
        return firstReservCnt;
    }

    public void setFirstReservCnt(List<Object> firstReservCnt) {
        this.firstReservCnt = firstReservCnt;
    }

    public List<Object> getSecondReservCnt() {
        return secondReservCnt;
    }

    public void setSecondReservCnt(List<Object> secondReservCnt) {
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
