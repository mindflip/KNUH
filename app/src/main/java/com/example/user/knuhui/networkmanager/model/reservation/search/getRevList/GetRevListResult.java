
package com.example.user.knuhui.networkmanager.model.reservation.search.getRevList;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetRevListResult {

    @SerializedName("receiptNo")
    @Expose
    private String receiptNo;
    @SerializedName("departmentNm")
    @Expose
    private String departmentNm;
    @SerializedName("departmentCd")
    @Expose
    private String departmentCd;
    @SerializedName("doctorNm")
    @Expose
    private String doctorNm;
    @SerializedName("doctorId")
    @Expose
    private String doctorId;
    @SerializedName("dataDate")
    @Expose
    private String dataDate;
    @SerializedName("dataTime")
    @Expose
    private String dataTime;
    @SerializedName("receiptGubunKindNm")
    @Expose
    private String receiptGubunKindNm;
    @SerializedName("reservationMethod")
    @Expose
    private String reservationMethod;
    @SerializedName("ordExamKindNm")
    @Expose
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
