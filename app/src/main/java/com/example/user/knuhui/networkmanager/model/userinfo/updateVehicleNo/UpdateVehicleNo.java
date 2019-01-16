
package com.example.user.knuhui.networkmanager.model.userinfo.updateVehicleNo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "root", strict = false)
public class UpdateVehicleNo {

    @Element
    private UpdateVehicleNoResultinfo resultinfo;

    public UpdateVehicleNoResultinfo getResultinfo() {
        return resultinfo;
    }

    public void setResultinfo(UpdateVehicleNoResultinfo resultinfo) {
        this.resultinfo = resultinfo;
    }

}
