
package com.example.user.knuhui.networkmanager.model.reservation.booking.getRevTime;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "root", strict = false)
public class GetRevTime {

    @Element
    private GetRevTimeResultinfo resultinfo;

    public GetRevTimeResultinfo getResultinfo() {
        return resultinfo;
    }

    public void setResultinfo(GetRevTimeResultinfo resultinfo) {
        this.resultinfo = resultinfo;
    }

}
