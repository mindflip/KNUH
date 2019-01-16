
package com.example.user.knuhui.networkmanager.model.userinfo.getUserInfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "root", strict = false)
public class GetUserInfo {

    @Element
    private GetUserInfoResultinfo resultinfo;

    public GetUserInfoResultinfo getResultinfo() {
        return resultinfo;
    }

    public void setResultinfo(GetUserInfoResultinfo resultinfo) {
        this.resultinfo = resultinfo;
    }

}
