
package com.example.user.knuhui.networkmanager.model.reservation.search.getRevList;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "result", strict = false)
public class GetRevListResult {

    @Element
    private String receiptNo;
    @Element
    private String departmentNm;
    @Element
    private String departmentCd;
    @Element
    private String doctorNm;
    @Element
    private String doctorId;
    @Element
    private String dataDate;
    @Element
    private String dataTime;
    @Element
    private String receiptGubunKindNm;
    @Element
    private String reservationMethod;
    @Element
    private String ordExamKindNm;

    public String getReceiptNo() {
        return receiptNo;
    }

    public void setReceiptNo(String receiptNo) {
        this.receiptNo = receiptNo;
    }

    public String getDepartmentNm() {
        return departmentNm;
    }

    public void setDepartmentNm(String departmentNm) {
        this.departmentNm = departmentNm;
    }

    public String getDepartmentCd() {
        return departmentCd;
    }

    public void setDepartmentCd(String departmentCd) {
        this.departmentCd = departmentCd;
    }

    public String getDoctorNm() {
        return doctorNm;
    }

    public void setDoctorNm(String doctorNm) {
        this.doctorNm = doctorNm;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getDataDate() {
        return dataDate;
    }

    public void setDataDate(String dataDate) {
        this.dataDate = dataDate;
    }

    public String getDataTime() {
        return dataTime;
    }

    public void setDataTime(String dataTime) {
        this.dataTime = dataTime;
    }

    public String getReceiptGubunKindNm() {
        return receiptGubunKindNm;
    }

    public void setReceiptGubunKindNm(String receiptGubunKindNm) {
        this.receiptGubunKindNm = receiptGubunKindNm;
    }

    public String getReservationMethod() {
        return reservationMethod;
    }

    public void setReservationMethod(String reservationMethod) {
        this.reservationMethod = reservationMethod;
    }

    public String getOrdExamKindNm() {
        return ordExamKindNm;
    }

    public void setOrdExamKindNm(String ordExamKindNm) {
        this.ordExamKindNm = ordExamKindNm;
    }

    @Override
    public String toString() {
        return "GetRevListResult{" +
                "receiptNo='" + receiptNo + '\'' +
                ", departmentNm='" + departmentNm + '\'' +
                ", departmentCd='" + departmentCd + '\'' +
                ", doctorNm='" + doctorNm + '\'' +
                ", doctorId='" + doctorId + '\'' +
                ", dataDate='" + dataDate + '\'' +
                ", dataTime='" + dataTime + '\'' +
                ", receiptGubunKindNm='" + receiptGubunKindNm + '\'' +
                ", reservationMethod='" + reservationMethod + '\'' +
                ", ordExamKindNm='" + ordExamKindNm + '\'' +
                '}';
    }
}
