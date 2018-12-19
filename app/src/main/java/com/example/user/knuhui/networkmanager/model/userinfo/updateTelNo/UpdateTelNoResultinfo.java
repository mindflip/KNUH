
package com.example.user.knuhui.networkmanager.model.userinfo.updateTelNo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UpdateTelNoResultinfo {

    @SerializedName("result")
    @Expose
    private UpdateTelNoResult result;
    @SerializedName("message")
    @Expose
    private UpdateTelNoMessage message;

    public UpdateTelNoResult getResult() {
        return result;
    }

    public void setResult(UpdateTelNoResult result) {
        this.result = result;
    }

    public UpdateTelNoMessage getMessage() {
        return message;
    }

    public void setMessage(UpdateTelNoMessage message) {
        this.message = message;
    }

}
