
package com.example.user.knuhui.networkmanager.model.userinfo.updateAddress;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UpdateAddress {

    @SerializedName("resultinfo")
    @Expose
    private UpdateAddressResultinfo resultinfo;

    public UpdateAddressResultinfo getResultinfo() {
        return resultinfo;
    }

    public void setResultinfo(UpdateAddressResultinfo resultinfo) {
        this.resultinfo = resultinfo;
    }

}
