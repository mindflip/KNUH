
package com.example.user.knuhui.networkmanager.model.reservation.booking.getRevTime;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name = "resultinfo", strict = false)
public class GetRevTimeResultinfo {

    @ElementList(inline = true, required = false)
    private List<GetRevTimeResult> result = null;
    @Element
    private GetRevTimeResultKM resultKM;

    public List<GetRevTimeResult> getResult() {
        return result;
    }

    public void setResult(List<GetRevTimeResult> result) {
        this.result = result;
    }

    public GetRevTimeResultKM getResultKM() {
        return resultKM;
    }

    public void setResultKM(GetRevTimeResultKM resultKM) {
        this.resultKM = resultKM;
    }
}
