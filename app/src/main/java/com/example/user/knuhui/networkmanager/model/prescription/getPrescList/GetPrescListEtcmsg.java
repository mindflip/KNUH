package com.example.user.knuhui.networkmanager.model.prescription.getPrescList;

import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "etcmsg", strict = false)
public class GetPrescListEtcmsg {

    @Element
    private List<Object> error = null;
    @Element
    private List<Object> errortype = null;
    @Element
    private String errormsg;

    public List<Object> getError() {
        return error;
    }

    public void setError(List<Object> error) {
        this.error = error;
    }

    public List<Object> getErrortype() {
        return errortype;
    }

    public void setErrortype(List<Object> errortype) {
        this.errortype = errortype;
    }

    public String getErrormsg() {
        return errormsg;
    }

    public void setErrormsg(String errormsg) {
        this.errormsg = errormsg;
    }

}
