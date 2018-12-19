
package com.example.user.knuhui.networkmanager.model.userinfo.updateVehicleNo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UpdateVehicleNo {

    @SerializedName("resultinfo")
    @Expose
    private UpdateVehicleNoResultinfo resultinfo;

    public UpdateVehicleNoResultinfo getResultinfo() {
        return resultinfo;
    }

    public void setResultinfo(UpdateVehicleNoResultinfo resultinfo) {
        this.resultinfo = resultinfo;
    }

}
