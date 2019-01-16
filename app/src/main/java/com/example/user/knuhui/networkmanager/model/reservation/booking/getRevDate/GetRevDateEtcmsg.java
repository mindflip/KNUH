package com.example.user.knuhui.networkmanager.model.reservation.booking.getRevDate;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "etcmsg", strict = false)
public class GetRevDateEtcmsg
{
    @Element(required = false)
    private String errortype;
    @Element(required = false)
    private String error;
    @Element
    private String errormsg;

    public String getErrortype ()
    {
        return errortype;
    }

    public void setErrortype (String errortype)
    {
        this.errortype = errortype;
    }

    public String getError ()
    {
        return error;
    }

    public void setError (String error)
    {
        this.error = error;
    }

    public String getErrormsg ()
    {
        return errormsg;
    }

    public void setErrormsg (String errormsg)
    {
        this.errormsg = errormsg;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [errortype = "+errortype+", error = "+error+", errormsg = "+errormsg+"]";
    }
}
