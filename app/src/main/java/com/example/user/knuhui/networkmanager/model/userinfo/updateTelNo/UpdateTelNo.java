
package com.example.user.knuhui.networkmanager.model.userinfo.updateTelNo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UpdateTelNo {

    @SerializedName("resultinfo")
    @Expose
    private UpdateTelNoResultinfo resultinfo;

    public UpdateTelNoResultinfo getResultinfo() {
        return resultinfo;
    }

    public void setResultinfo(UpdateTelNoResultinfo resultinfo) {
        this.resultinfo = resultinfo;
    }

}
