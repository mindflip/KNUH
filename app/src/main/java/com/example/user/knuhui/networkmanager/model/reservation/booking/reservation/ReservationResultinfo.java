
package com.example.user.knuhui.networkmanager.model.reservation.booking.reservation;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "resultinfo", strict = false)
public class ReservationResultinfo {

    @Element
    private ReservationResult result;
    @Element
    private ReservationMessage message;

    public ReservationResult getResult() {
        return result;
    }

    public void setResult(ReservationResult result) {
        this.result = result;
    }

    public ReservationMessage getMessage() {
        return message;
    }

    public void setMessage(ReservationMessage message) {
        this.message = message;
    }

}
