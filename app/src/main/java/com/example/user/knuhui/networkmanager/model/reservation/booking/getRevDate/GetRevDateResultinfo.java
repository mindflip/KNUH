
package com.example.user.knuhui.networkmanager.model.reservation.booking.getRevDate;

import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name = "resultinfo", strict = false)
public class GetRevDateResultinfo {

    @ElementList(inline = true, required = false)
    private List<GetRevDateResult> result = null;
    @Element(required = false)
    private GetRevDateEtcmsg etcmsg;
    @Element
    private GetRevDateResultKM resultKM;

    public List<GetRevDateResult> getResult() {
        return result;
    }

    public void setResult(List<GetRevDateResult> result) {
        this.result = result;
    }

    public GetRevDateResultKM getResultKM() {
        return resultKM;
    }

    public void setResultKM(GetRevDateResultKM resultKM) {
        this.resultKM = resultKM;
    }

    public GetRevDateEtcmsg getEtcmsg() {
        return etcmsg;
    }

    public void setEtcmsg(GetRevDateEtcmsg etcmsg) {
        this.etcmsg = etcmsg;
    }
}
