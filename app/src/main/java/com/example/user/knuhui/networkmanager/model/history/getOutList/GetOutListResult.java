
package com.example.user.knuhui.networkmanager.model.history.getOutList;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "result", strict = false)
public class GetOutListResult {

    @Element
    private String receiptNo;
    @Element
    private String pid;
    @Element
    private String receiptGubunNm;
    @Element
    private String dataDate;
    @Element
    private String dataTime;
    @Element
    private String departmentNm;
    @Element
    private String doctorNm;

    public String getReceiptNo() {
        return receiptNo;
    }

    public void setReceiptNo(String receiptNo) {
        this.receiptNo = receiptNo;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getReceiptGubunNm() {
        return receiptGubunNm;
    }

    public void setReceiptGubunNm(String receiptGubunNm) {
        this.receiptGubunNm = receiptGubunNm;
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

    public String getDepartmentNm() {
        return departmentNm;
    }

    public void setDepartmentNm(String departmentNm) {
        this.departmentNm = departmentNm;
    }

    public String getDoctorNm() {
        return doctorNm;
    }

    public void setDoctorNm(String doctorNm) {
        this.doctorNm = doctorNm;
    }

}
