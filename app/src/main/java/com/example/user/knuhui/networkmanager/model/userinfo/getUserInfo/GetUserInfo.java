
package com.example.user.knuhui.networkmanager.model.userinfo.getUserInfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetUserInfo {

    @SerializedName("resultinfo")
    @Expose
    private GetUserInfoResultinfo resultinfo;

    public GetUserInfoResultinfo getResultinfo() {
        return resultinfo;
    }

    public void setResultinfo(GetUserInfoResultinfo resultinfo) {
        this.resultinfo = resultinfo;
    }

}
