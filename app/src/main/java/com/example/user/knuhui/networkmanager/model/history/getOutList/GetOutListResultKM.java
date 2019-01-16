
package com.example.user.knuhui.networkmanager.model.history.getOutList;


import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "resultKM", strict = false)
public class GetOutListResultKM {

    @Element(required = false)
    private String error;
    @Element(required = false)
    private String type;
    @Element(required = false)
    private String clear;
    @Element(required = false)
    private String description;
    @Element(required = false)
    private String updateinstance;
    @Element(required = false)
    private String source;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getClear() {
        return clear;
    }

    public void setClear(String clear) {
        this.clear = clear;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUpdateinstance() {
        return updateinstance;
    }

    public void setUpdateinstance(String updateinstance) {
        this.updateinstance = updateinstance;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

}
