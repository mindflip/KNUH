
package com.example.user.knuhui.networkmanager.model.prescription.getPrescList;

import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name = "resultinfo", strict = false)
public class GetPrescListResultinfo {

    @ElementList(inline = true, required = false)
    private List<GetPrescListResult> result = null;
    @Element(required = false)
    private GetPrescListResultKM resultKM;
    @Element(required = false)
    private GetPrescListEtcmsg etcmsg;

    public List<GetPrescListResult> getResult() {
        return result;
    }

    public void setResult(List<GetPrescListResult> result) {
        this.result = result;
    }

    public GetPrescListResultKM getResultKM() {
        return resultKM;
    }

    public void setResultKM(GetPrescListResultKM resultKM) {
        this.resultKM = resultKM;
    }

    public GetPrescListEtcmsg getEtcmsg() {
        return etcmsg;
    }

    public void setEtcmsg(GetPrescListEtcmsg etcmsg) {
        this.etcmsg = etcmsg;
    }
}