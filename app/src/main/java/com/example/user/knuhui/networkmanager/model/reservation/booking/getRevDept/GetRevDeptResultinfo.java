
package com.example.user.knuhui.networkmanager.model.reservation.booking.getRevDept;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetRevDeptResultinfo {

    @SerializedName("result")
    @Expose
    private List<GetRevDeptResult> result = null;
    @SerializedName("message")
    @Expose
    private GetRevDeptMessage message;

    public List<GetRevDeptResult> getResult() {
        return result;
    }

    public void setResult(List<GetRevDeptResult> result) {
        this.result = result;
    }

    public GetRevDeptMessage getMessage() {
        return message;
    }

    public void setMessage(GetRevDeptMessage message) {
        this.message = message;
    }

}
