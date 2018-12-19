
package com.example.user.knuhui.networkmanager.model.reservation.booking.getRevDoc;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetRevDocResult {

    @SerializedName("doctorId")
    @Expose
    private String doctorId;
    @SerializedName("doctorNm")
    @Expose
    private String doctorNm;
    @SerializedName("departmentCd")
    @Expose
    private String departmentCd;
    @SerializedName("specYn")
    @Expose
    private String specYn;
    @SerializedName("majorField")
    @Expose
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
