
package com.example.user.knuhui.networkmanager.model.reservation.booking.getRevDept;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name = "resultinfo", strict = false)
public class GetRevDeptResultinfo {

    @ElementList(inline = true, required = false)
    private List<GetRevDeptResult> result = null;
    @Element
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
