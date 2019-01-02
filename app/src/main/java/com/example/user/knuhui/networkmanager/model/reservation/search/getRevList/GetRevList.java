
package com.example.user.knuhui.networkmanager.model.reservation.search.getRevList;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.simpleframework.xml.Root;

@Root(name = "root", strict = false)
public class GetRevList {

    @SerializedName("resultinfo")
    @Expose
    private GetRevListResultinfo resultinfo;

    public GetRevListResultinfo getResultinfo() {
        return resultinfo;
    }

    public void setResultinfo(GetRevListResultinfo resultinfo) {
        this.resultinfo = resultinfo;
    }

}
