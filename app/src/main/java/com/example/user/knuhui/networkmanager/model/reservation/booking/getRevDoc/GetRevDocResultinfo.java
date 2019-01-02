
package com.example.user.knuhui.networkmanager.model.reservation.booking.getRevDoc;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "resultinfo", strict = false)
public class GetRevDocResultinfo {

    @ElementList(inline = true, required = false)
    private List<GetRevDocResult> result;
    @Element
    private GetRevDocMessage message;

    public List<GetRevDocResult> getResult() {
        return result;
    }

    public void setResult(List<GetRevDocResult> result) {
        this.result = result;
    }

    public GetRevDocMessage getMessage() {
        return message;
    }

    public void setMessage(GetRevDocMessage message) {
        this.message = message;
    }

}
