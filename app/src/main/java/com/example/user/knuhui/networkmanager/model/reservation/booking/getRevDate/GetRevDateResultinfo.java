
package com.example.user.knuhui.networkmanager.model.reservation.booking.getRevDate;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetRevDateResultinfo {

    @SerializedName("result")
    @Expose
    private List<GetRevDateResult> result = null;
    @SerializedName("message")
    @Expose
    private GetRevDateMessage message;

    public List<GetRevDateResult> getResult() {
        return result;
    }

    public void setResult(List<GetRevDateResult> result) {
        this.result = result;
    }

    public GetRevDateMessage getMessage() {
        return message;
    }

    public void setMessage(GetRevDateMessage message) {
        this.message = message;
    }

}
