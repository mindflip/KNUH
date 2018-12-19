
package com.example.user.knuhui.networkmanager.model.reservation.booking.getRevTime;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetRevTimeResultinfo {

    @SerializedName("result")
    @Expose
    private List<GetRevTimeResult> result = null;
    @SerializedName("message")
    @Expose
    private GetRevTimeMessage message;

    public List<GetRevTimeResult> getResult() {
        return result;
    }

    public void setResult(List<GetRevTimeResult> result) {
        this.result = result;
    }

    public GetRevTimeMessage getMessage() {
        return message;
    }

    public void setMessage(GetRevTimeMessage message) {
        this.message = message;
    }

}
