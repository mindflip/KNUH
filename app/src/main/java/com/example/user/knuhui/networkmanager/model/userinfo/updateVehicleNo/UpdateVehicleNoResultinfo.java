
package com.example.user.knuhui.networkmanager.model.userinfo.updateVehicleNo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UpdateVehicleNoResultinfo {

    @SerializedName("result")
    @Expose
    private UpdateVehicleNoResult result;
    @SerializedName("message")
    @Expose
    private UpdateVehicleNoMessage message;

    public UpdateVehicleNoResult getResult() {
        return result;
    }

    public void setResult(UpdateVehicleNoResult result) {
        this.result = result;
    }

    public UpdateVehicleNoMessage getMessage() {
        return message;
    }

    public void setMessage(UpdateVehicleNoMessage message) {
        this.message = message;
    }

}
