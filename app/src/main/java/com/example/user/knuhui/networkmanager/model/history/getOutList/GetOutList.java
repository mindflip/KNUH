
package com.example.user.knuhui.networkmanager.model.history.getOutList;


import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "root", strict = false)
public class GetOutList {

    @Element
    private GetOutListResultinfo resultinfo;

    public GetOutListResultinfo getResultinfo() {
        return resultinfo;
    }

    public void setResultinfo(GetOutListResultinfo resultinfo) {
        this.resultinfo = resultinfo;
    }

}
