
package com.example.user.knuhui.networkmanager.model.userinfo.updateAddress;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "resultinfo", strict = false)
public class UpdateAddressResultinfo {

    @Element
    private UpdateAddressResult result;
    @Element
    private UpdateAddressResultKM resultKM;

    public UpdateAddressResult getResult() {
        return result;
    }

    public void setResult(UpdateAddressResult result) {
        this.result = result;
    }

    public UpdateAddressResultKM getResultKM() {
        return resultKM;
    }

    public void setResultKM(UpdateAddressResultKM resultKM) {
        this.resultKM = resultKM;
    }
}
