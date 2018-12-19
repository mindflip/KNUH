
package com.example.user.knuhui.networkmanager.model.userinfo.getUserInfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetUserInfoResultinfo {

    @SerializedName("result")
    @Expose
    private GetUserInfoResult result;
    @SerializedName("message")
    @Expose
    private GetUserInfoMessage message;

    public GetUserInfoResult getResult() {
        return result;
    }

    public void setResult(GetUserInfoResult result) {
        this.result = result;
    }

    public GetUserInfoMessage getMessage() {
        return message;
    }

    public void setMessage(GetUserInfoMessage message) {
        this.message = message;
    }

}
