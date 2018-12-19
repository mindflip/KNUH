
package com.example.user.knuhui.networkmanager.model.reservation.booking.reservation;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ReservationResultinfo {

    @SerializedName("result")
    @Expose
    private ReservationResult result;
    @SerializedName("message")
    @Expose
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
