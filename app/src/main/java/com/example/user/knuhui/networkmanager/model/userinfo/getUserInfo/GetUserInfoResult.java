
package com.example.user.knuhui.networkmanager.model.userinfo.getUserInfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "result", strict = false)
public class GetUserInfoResult {

    @Element
    private String birthDt;
    @Element
    private String pNm;
    @Element
    private String cellphoneNo;
    @Element
    private String pId;
    @Element
    private String genderCd;
    @Element
    private String inHospitalYn;
    @Element
    private String vehicleNo;
    @Element
    private String zipCode;
    @Element
    private String zipCodeTxt;
    @Element
    private String address;

    public String getBirthDt() {
        return birthDt;
    }

    public void setBirthDt(String birthDt) {
        this.birthDt = birthDt;
    }

    public String getPNm() {
        return pNm;
    }

    public void setPNm(String pNm) {
        this.pNm = pNm;
    }

    public String getCellphoneNo() {
        return cellphoneNo;
    }

    public void setCellphoneNo(String cellphoneNo) {
        this.cellphoneNo = cellphoneNo;
    }

    public String getPId() {
        return pId;
    }

    public void setPId(String pId) {
        this.pId = pId;
    }

    public String getGenderCd() {
        return genderCd;
    }

    public void setGenderCd(String genderCd) {
        this.genderCd = genderCd;
    }

    public String getInHospitalYn() {
        return inHospitalYn;
    }

    public void setInHospitalYn(String inHospitalYn) {
        this.inHospitalYn = inHospitalYn;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getZipCodeTxt() {
        return zipCodeTxt;
    }

    public void setZipCodeTxt(String zipCodeTxt) {
        this.zipCodeTxt = zipCodeTxt;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
