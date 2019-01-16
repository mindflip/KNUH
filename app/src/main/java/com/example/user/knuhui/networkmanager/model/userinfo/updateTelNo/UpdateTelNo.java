
package com.example.user.knuhui.networkmanager.model.userinfo.updateTelNo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "root", strict = false)
public class UpdateTelNo {

    @Element
    private UpdateTelNoResultinfo resultinfo;

    public UpdateTelNoResultinfo getResultinfo() {
        return resultinfo;
    }

    public void setResultinfo(UpdateTelNoResultinfo resultinfo) {
        this.resultinfo = resultinfo;
    }

}
