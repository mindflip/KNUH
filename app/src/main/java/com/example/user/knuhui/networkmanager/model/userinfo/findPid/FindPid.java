
package com.example.user.knuhui.networkmanager.model.userinfo.findPid;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FindPid {

    @SerializedName("resultinfo")
    @Expose
    private FindPidResultinfo resultinfo;

    public FindPidResultinfo getResultinfo() {
        return resultinfo;
    }

    public void setResultinfo(FindPidResultinfo resultinfo) {
        this.resultinfo = resultinfo;
    }

}
