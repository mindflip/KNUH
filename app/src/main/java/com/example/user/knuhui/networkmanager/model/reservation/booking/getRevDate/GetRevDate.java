
package com.example.user.knuhui.networkmanager.model.reservation.booking.getRevDate;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetRevDate {

    @SerializedName("resultinfo")
    @Expose
    private GetRevDateResultinfo resultinfo;

    public GetRevDateResultinfo getResultinfo() {
        return resultinfo;
    }

    public void setResultinfo(GetRevDateResultinfo resultinfo) {
        this.resultinfo = resultinfo;
    }

}
