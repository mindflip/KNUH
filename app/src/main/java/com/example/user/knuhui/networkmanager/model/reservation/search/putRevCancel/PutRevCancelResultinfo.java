
package com.example.user.knuhui.networkmanager.model.reservation.search.putRevCancel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PutRevCancelResultinfo {

    @SerializedName("result")
    @Expose
    private PutRevCancelResult result;
    @SerializedName("message")
    @Expose
    private PutRevCancelMessage message;

    public PutRevCancelResult getResult() {
        return result;
    }

    public void setResult(PutRevCancelResult result) {
        this.result = result;
    }

    public PutRevCancelMessage getMessage() {
        return message;
    }

    public void setMessage(PutRevCancelMessage message) {
        this.message = message;
    }

}
