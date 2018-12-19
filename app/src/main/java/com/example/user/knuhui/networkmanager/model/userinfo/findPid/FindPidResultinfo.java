
package com.example.user.knuhui.networkmanager.model.userinfo.findPid;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FindPidResultinfo {

    @SerializedName("result")
    @Expose
    private FindPidResult result;
    @SerializedName("message")
    @Expose
    private FindPidMessage message;

    public FindPidResult getResult() {
        return result;
    }

    public void setResult(FindPidResult result) {
        this.result = result;
    }

    public FindPidMessage getMessage() {
        return message;
    }

    public void setMessage(FindPidMessage message) {
        this.message = message;
    }

}
