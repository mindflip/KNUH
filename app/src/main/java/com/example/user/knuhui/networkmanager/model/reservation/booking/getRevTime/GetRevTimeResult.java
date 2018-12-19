
package com.example.user.knuhui.networkmanager.model.reservation.booking.getRevTime;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetRevTimeResult {

    @SerializedName("dataTime")
    @Expose
    private String dataTime;
    @SerializedName("firstReservCnt")
    @Expose
    private List<Object> firstReservCnt = null;
    @SerializedName("secondReservCnt")
    @Expose
    private List<Object> secondReservCnt = null;
    @SerializedName("availReservCnt")
    @Expose
    private String availReservCnt;
    @SerializedName("firstAvailReservCnt")
    @Expose
    private String firstAvailReservCnt;
    @SerializedName("secondAvailReservCnt")
    @Expose
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
