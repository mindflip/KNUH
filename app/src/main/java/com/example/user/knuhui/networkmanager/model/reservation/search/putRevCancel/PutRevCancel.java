
package com.example.user.knuhui.networkmanager.model.reservation.search.putRevCancel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PutRevCancel {

    @SerializedName("resultinfo")
    @Expose
    private PutRevCancelResultinfo resultinfo;

    public PutRevCancelResultinfo getResultinfo() {
        return resultinfo;
    }

    public void setResultinfo(PutRevCancelResultinfo resultinfo) {
        this.resultinfo = resultinfo;
    }

}
