
package com.example.user.knuhui.networkmanager.model.reservation.booking.getRevDept;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "root", strict = false)
public class GetRevDept {

    @Element
    private GetRevDeptResultinfo resultinfo;

    public GetRevDeptResultinfo getResultinfo() {
        return resultinfo;
    }

    public void setResultinfo(GetRevDeptResultinfo resultinfo) {
        this.resultinfo = resultinfo;
    }

}
