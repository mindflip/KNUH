
package com.example.user.knuhui.networkmanager.model.userinfo.updateAddress;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "root", strict = false)
public class UpdateAddress {

    @Element
    private UpdateAddressResultinfo resultinfo;

    public UpdateAddressResultinfo getResultinfo() {
        return resultinfo;
    }

    public void setResultinfo(UpdateAddressResultinfo resultinfo) {
        this.resultinfo = resultinfo;
    }

}
