
package com.example.user.knuhui.networkmanager.model.reservation.booking.getRevDate;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name = "resultinfo", strict = false)
public class GetRevDateResultinfo {

    @ElementList(inline = true, required = false)
    private List<GetRevDateResult> result = null;
    @Element
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
