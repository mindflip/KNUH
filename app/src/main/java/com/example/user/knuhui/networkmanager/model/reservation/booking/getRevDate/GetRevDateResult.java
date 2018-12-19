
package com.example.user.knuhui.networkmanager.model.reservation.booking.getRevDate;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetRevDateResult {

    @SerializedName("dataDate")
    @Expose
    private String dataDate;
    @SerializedName("weekNm")
    @Expose
    private String weekNm;

    public String getDataDate() {
        return dataDate;
    }

    public void setDataDate(String dataDate) {
        this.dataDate = dataDate;
    }

    public String getWeekNm() {
        return weekNm;
    }

    public void setWeekNm(String weekNm) {
        this.weekNm = weekNm;
    }

    @Override
    public String toString() {
        return "getRevDateResult{" +
                "dataDate='" + dataDate + '\'' +
                ", weekNm='" + weekNm + '\'' +
                '}';
    }
}
