
package com.example.user.knuhui.networkmanager.model.reservation.booking.getRevDoc;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetRevDocResultinfo {

    @SerializedName("result")
    @Expose
    private GetRevDocResult result;
    @SerializedName("message")
    @Expose
    private GetRevDocMessage message;

    public GetRevDocResult getResult() {
        return result;
    }

    public void setResult(GetRevDocResult result) {
        this.result = result;
    }

    public GetRevDocMessage getMessage() {
        return message;
    }

    public void setMessage(GetRevDocMessage message) {
        this.message = message;
    }

}
