
package com.example.user.knuhui.networkmanager.model.reservation.booking.getRevDoc;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "result", strict = false)
public class GetRevDocResult {

    @Element
    private String doctorId;
    @Element
    private String doctorNm;
    @Element
    private String departmentCd;
    @Element
    private String specYn;
    @Element(required = false)
    private String majorField;

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorNm() {
        return doctorNm;
    }

    public void setDoctorNm(String doctorNm) {
        this.doctorNm = doctorNm;
    }

    public String getDepartmentCd() {
        return departmentCd;
    }

    public void setDepartmentCd(String departmentCd) {
        this.departmentCd = departmentCd;
    }

    public String getSpecYn() {
        return specYn;
    }

    public void setSpecYn(String specYn) {
        this.specYn = specYn;
    }

    public String getMajorField() {
        return majorField;
    }

    public void setMajorField(String majorField) {
        this.majorField = majorField;
    }

    @Override
    public String toString() {
        return "Result{" +
                "doctorId='" + doctorId + '\'' +
                ", doctorNm='" + doctorNm + '\'' +
                ", departmentCd='" + departmentCd + '\'' +
                ", specYn='" + specYn + '\'' +
                ", majorField='" + majorField + '\'' +
                '}';
    }
}
