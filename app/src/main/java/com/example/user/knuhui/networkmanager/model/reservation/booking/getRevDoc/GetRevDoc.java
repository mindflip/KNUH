
package com.example.user.knuhui.networkmanager.model.reservation.booking.getRevDoc;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetRevDoc {

    @SerializedName("resultinfo")
    @Expose
    private GetRevDocResultinfo resultinfo;

    public GetRevDocResultinfo getResultinfo() {
        return resultinfo;
    }

    public void setResultinfo(GetRevDocResultinfo resultinfo) {
        this.resultinfo = resultinfo;
    }

}
