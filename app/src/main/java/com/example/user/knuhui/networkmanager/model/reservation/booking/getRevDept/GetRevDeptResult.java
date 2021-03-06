
package com.example.user.knuhui.networkmanager.model.reservation.booking.getRevDept;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "result", strict = false)
public class GetRevDeptResult {

    @Element
    private String departmentCd;
    @Element
    private String departmentNm;

    public String getDepartmentCd() {
        return departmentCd;
    }

    public void setDepartmentCd(String departmentCd) {
        this.departmentCd = departmentCd;
    }

    public String getDepartmentNm() {
        return departmentNm;
    }

    public void setDepartmentNm(String departmentNm) {
        this.departmentNm = departmentNm;
    }

    @Override
    public String toString() {
        return "Result{" +
                "departmentCd='" + departmentCd + '\'' +
                ", departmentNm='" + departmentNm + '\'' +
                '}';
    }
}
