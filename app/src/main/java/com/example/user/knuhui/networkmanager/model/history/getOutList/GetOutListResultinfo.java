
package com.example.user.knuhui.networkmanager.model.history.getOutList;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name = "resultinfo", strict = false)
public class GetOutListResultinfo {

    @ElementList(inline = true)
    private List<GetOutListResult> result;
    @Element(required = false)
    private GetOutListResultKM resultKM;

    public List<GetOutListResult> getResult() {
        return result;
    }

    public void setResult(List<GetOutListResult> result) {
        this.result = result;
    }

    public GetOutListResultKM getResultKM() {
        return resultKM;
    }

    public void setResultKM(GetOutListResultKM resultKM) {
        this.resultKM = resultKM;
    }

}
