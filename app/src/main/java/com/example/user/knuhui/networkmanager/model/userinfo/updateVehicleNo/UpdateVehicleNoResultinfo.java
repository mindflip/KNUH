
package com.example.user.knuhui.networkmanager.model.userinfo.updateVehicleNo;

import com.example.user.knuhui.networkmanager.model.userinfo.updateTelNo.UpdateVehicleNoResultKM;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "resultinfo", strict = false)
public class UpdateVehicleNoResultinfo {

    @Element
    private UpdateVehicleNoResult result;
    @Element
    private UpdateVehicleNoResultKM resultKM;

    public UpdateVehicleNoResult getResult() {
        return result;
    }

    public void setResult(UpdateVehicleNoResult result) {
        this.result = result;
    }

    public UpdateVehicleNoResultKM getResultKM() {
        return resultKM;
    }

    public void setResultKM(UpdateVehicleNoResultKM resultKM) {
        this.resultKM = resultKM;
    }
}
