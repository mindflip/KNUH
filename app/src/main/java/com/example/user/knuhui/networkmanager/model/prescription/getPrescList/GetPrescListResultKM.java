
package com.example.user.knuhui.networkmanager.model.prescription.getPrescList;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name = "resultKM", strict = false)
public class GetPrescListResultKM {
//
//    @Element
//    private String error;
//    @Element
//    private String type;
//    @Element
//    private String clear;
//    @Element
//    private String description;
//    @Element
//    private String updateinstance;
//    @Element
//    private String source;
//
//    public String getError() {
//        return error;
//    }
//
//    public void setError(String error) {
//        this.error = error;
//    }
//
//    public String getClear() {
//        return clear;
//    }
//
//    public void setClear(String clear) {
//        this.clear = clear;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public String getUpdateinstance() {
//        return updateinstance;
//    }
//
//    public void setUpdateinstance(String updateinstance) {
//        this.updateinstance = updateinstance;
//    }
//
//    public String getSource() {
//        return source;
//    }
//
//    public void setSource(String source) {
//        this.source = source;
//    }
//
//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }

    private String clear;

    private String error;

    private String source;

    private String description;

    private String type;

    private String updateinstance;

    public String getClear ()
    {
        return clear;
    }

    public void setClear (String clear)
    {
        this.clear = clear;
    }

    public String getError ()
    {
        return error;
    }

    public void setError (String error)
    {
        this.error = error;
    }

    public String getSource ()
    {
        return source;
    }

    public void setSource (String source)
    {
        this.source = source;
    }

    public String getDescription ()
    {
        return description;
    }

    public void setDescription (String description)
    {
        this.description = description;
    }

    public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }

    public String getUpdateinstance ()
    {
        return updateinstance;
    }

    public void setUpdateinstance (String updateinstance)
    {
        this.updateinstance = updateinstance;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [clear = "+clear+", error = "+error+", source = "+source+", description = "+description+", type = "+type+", updateinstance = "+updateinstance+"]";
    }
}