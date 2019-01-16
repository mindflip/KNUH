
package com.example.user.knuhui.networkmanager.model.prescription.getPrescList;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "result", strict = false)
public class GetPrescListResult {

    @Element
    private String departmentNm;
    @Element
    private String prescriptionDt;
    @Element
    private String medicineNm;
    @Element
    private String dose;
    @Element
    private String doseTm;
    @Element
    private String doseDay;
    @Element(required = false)
    private String usageNm;
    @Element(required = false)
    private String effectNm;
    @Element(required = false)
    private String dangerNote;
    @Element(required = false)
    private String insuranceCd;

    public String getDepartmentNm() {
        return departmentNm;
    }

    public void setDepartmentNm(String departmentNm) {
        this.departmentNm = departmentNm;
    }

    public String getPrescriptionDt() {
        return prescriptionDt;
    }

    public void setPrescriptionDt(String prescriptionDt) {
        this.prescriptionDt = prescriptionDt;
    }

    public String getMedicineNm() {
        return medicineNm;
    }

    public void setMedicineNm(String medicineNm) {
        this.medicineNm = medicineNm;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public String getDoseTm() {
        return doseTm;
    }

    public void setDoseTm(String doseTm) {
        this.doseTm = doseTm;
    }

    public String getDoseDay() {
        return doseDay;
    }

    public void setDoseDay(String doseDay) {
        this.doseDay = doseDay;
    }

    public String getUsageNm() {
        return usageNm;
    }

    public void setUsageNm(String usageNm) {
        this.usageNm = usageNm;
    }

    public String getEffectNm() {
        return effectNm;
    }

    public void setEffectNm(String effectNm) {
        this.effectNm = effectNm;
    }

    public String getDangerNote() {
        return dangerNote;
    }

    public void setDangerNote(String dangerNote) {
        this.dangerNote = dangerNote;
    }

    public String getInsuranceCd() {
        return insuranceCd;
    }

    public void setInsuranceCd(String insuranceCd) {
        this.insuranceCd = insuranceCd;
    }

    @Override
    public String toString() {
        return "GetPrescListResult{" +
                "departmentNm='" + departmentNm + '\'' +
                ", prescriptionDt='" + prescriptionDt + '\'' +
                ", medicineNm='" + medicineNm + '\'' +
                ", dose='" + dose + '\'' +
                ", doseTm='" + doseTm + '\'' +
                ", doseDay='" + doseDay + '\'' +
                ", usageNm='" + usageNm + '\'' +
                ", effectNm='" + effectNm + '\'' +
                ", dangerNote='" + dangerNote + '\'' +
                ", insuranceCd='" + insuranceCd + '\'' +
                '}';
    }
}
