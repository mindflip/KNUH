
package com.example.user.knuhui.networkmanager.model.reservation.booking.getRevTime;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetRevTime {

    @SerializedName("resultinfo")
    @Expose
    private GetRevTimeResultinfo resultinfo;

    public GetRevTimeResultinfo getResultinfo() {
        return resultinfo;
    }

    public void setResultinfo(GetRevTimeResultinfo resultinfo) {
        this.resultinfo = resultinfo;
    }

}
