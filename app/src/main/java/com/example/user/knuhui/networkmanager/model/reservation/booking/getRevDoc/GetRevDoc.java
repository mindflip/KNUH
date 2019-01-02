
package com.example.user.knuhui.networkmanager.model.reservation.booking.getRevDoc;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "root", strict = false)
public class GetRevDoc {

    @Element
    private GetRevDocResultinfo resultinfo;

    public GetRevDocResultinfo getResultinfo() {
        return resultinfo;
    }

    public void setResultinfo(GetRevDocResultinfo resultinfo) {
        this.resultinfo = resultinfo;
    }

}
