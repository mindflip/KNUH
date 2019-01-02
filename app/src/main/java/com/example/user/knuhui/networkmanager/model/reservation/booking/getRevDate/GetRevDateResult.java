
package com.example.user.knuhui.networkmanager.model.reservation.booking.getRevDate;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "result", strict = false)
public class GetRevDateResult {

    @Element
    private String dataDate;
    @Element
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
