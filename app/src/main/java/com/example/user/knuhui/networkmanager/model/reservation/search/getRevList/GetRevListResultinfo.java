
package com.example.user.knuhui.networkmanager.model.reservation.search.getRevList;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetRevListResultinfo {

    @SerializedName("result")
    @Expose
    private List<GetRevListResult> result = null;
    @SerializedName("message")
    @Expose
    private GetRevListMessage message;

    public List<GetRevListResult> getResult() {
        return result;
    }

    public void setResult(List<GetRevListResult> result) {
        this.result = result;
    }

    public GetRevListMessage getMessage() {
        return message;
    }

    public void setMessage(GetRevListMessage message) {
        this.message = message;
    }

}
