
package com.example.user.knuhui.networkmanager.model.prescription.getPrescList;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "root", strict = false)
public class GetPrescList {

    @Element
    private GetPrescListResultinfo resultinfo;

    public GetPrescListResultinfo getResultinfo() {
        return resultinfo;
    }

    public void setResultinfo(GetPrescListResultinfo resultinfo) {
        this.resultinfo = resultinfo;
    }

}