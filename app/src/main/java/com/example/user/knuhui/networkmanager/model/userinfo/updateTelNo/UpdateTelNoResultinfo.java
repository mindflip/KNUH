
package com.example.user.knuhui.networkmanager.model.userinfo.updateTelNo;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "resultinfo", strict = false)
public class UpdateTelNoResultinfo {

    @Element
    private UpdateTelNoResult result;
    @Element
    private UpdateVehicleNoResultKM resultKM;

    public UpdateTelNoResult getResult() {
        return result;
    }

    public void setResult(UpdateTelNoResult result) {
        this.result = result;
    }

    public UpdateVehicleNoResultKM getResultKM() {
        return resultKM;
    }

    public void setResultKM(UpdateVehicleNoResultKM resultKM) {
        this.resultKM = resultKM;
    }
}
