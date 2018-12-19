
package com.example.user.knuhui.networkmanager.model.reservation.booking.getRevDept;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetRevDept {

    @SerializedName("resultinfo")
    @Expose
    private GetRevDeptResultinfo resultinfo;

    public GetRevDeptResultinfo getResultinfo() {
        return resultinfo;
    }

    public void setResultinfo(GetRevDeptResultinfo resultinfo) {
        this.resultinfo = resultinfo;
    }

}
