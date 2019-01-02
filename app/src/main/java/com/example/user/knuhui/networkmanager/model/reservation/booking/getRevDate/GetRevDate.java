
package com.example.user.knuhui.networkmanager.model.reservation.booking.getRevDate;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "root", strict = false)
public class GetRevDate {

    @Element
    private GetRevDateResultinfo resultinfo;

    public GetRevDateResultinfo getResultinfo() {
        return resultinfo;
    }

    public void setResultinfo(GetRevDateResultinfo resultinfo) {
        this.resultinfo = resultinfo;
    }

}
