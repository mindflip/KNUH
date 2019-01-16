
package com.example.user.knuhui.networkmanager.model.reservation.search.putRevCancel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "root", strict = false)
public class PutRevCancel {

    @Element
    private PutRevCancelResultinfo resultinfo;

    public PutRevCancelResultinfo getResultinfo() {
        return resultinfo;
    }

    public void setResultinfo(PutRevCancelResultinfo resultinfo) {
        this.resultinfo = resultinfo;
    }

}
