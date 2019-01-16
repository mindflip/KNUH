
package com.example.user.knuhui.networkmanager.model.reservation.search.getRevList;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name = "resultinfo", strict = false)
public class GetRevListResultinfo {

    @ElementList(inline = true)
    private List<GetRevListResult> result;
    @Element
    private GetRevListResultKM resultKM;

    public List<GetRevListResult> getResult() {
        return result;
    }

    public void setResult(List<GetRevListResult> result) {
        this.result = result;
    }

    public GetRevListResultKM getResultKM() {
        return resultKM;
    }

    public void setResultKM(GetRevListResultKM resultKM) {
        this.resultKM = resultKM;
    }
}
