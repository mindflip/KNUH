
package com.example.user.knuhui.networkmanager.model.userinfo.getUserInfo;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "resultinfo", strict = false)
public class GetUserInfoResultinfo {

    @Element
    private GetUserInfoResult result;
    @Element(required = false)
    private GetUserInfoResultKM resultKM;

    public GetUserInfoResult getResult() {
        return result;
    }

    public void setResult(GetUserInfoResult result) {
        this.result = result;
    }

    public GetUserInfoResultKM getResultKM() {
        return resultKM;
    }

    public void setResultKM(GetUserInfoResultKM resultKM) {
        this.resultKM = resultKM;
    }
}
