
package com.example.user.knuhui.networkmanager.model.reservation.search.putRevCancel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "result", strict = false)
public class PutRevCancelResult {

    @Element
    private String count;

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "PutRevCancelResult{" +
                "count='" + count + '\'' +
                '}';
    }
}
