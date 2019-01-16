
package com.example.user.knuhui.networkmanager.model.reservation.search.putRevCancel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "resultinfo", strict = false)
public class PutRevCancelResultinfo {

    @Element
    private PutRevCancelResult result;
    @Element
    private PutRevCancelResultKM resultKM;

    public PutRevCancelResult getResult() {
        return result;
    }

    public void setResult(PutRevCancelResult result) {
        this.result = result;
    }

    public PutRevCancelResultKM getResultKM() {
        return resultKM;
    }

    public void setResultKM(PutRevCancelResultKM resultKM) {
        this.resultKM = resultKM;
    }
}
