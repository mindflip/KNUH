
package com.example.user.knuhui.networkmanager.model.userinfo.updateAddress;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UpdateAddressResultinfo {

    @SerializedName("result")
    @Expose
    private UpdateAddressResult result;
    @SerializedName("message")
    @Expose
    private UpdateAddressMessage message;

    public UpdateAddressResult getResult() {
        return result;
    }

    public void setResult(UpdateAddressResult result) {
        this.result = result;
    }

    public UpdateAddressMessage getMessage() {
        return message;
    }

    public void setMessage(UpdateAddressMessage message) {
        this.message = message;
    }

}
