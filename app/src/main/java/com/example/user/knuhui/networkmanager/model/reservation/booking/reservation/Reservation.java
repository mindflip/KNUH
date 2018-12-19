
package com.example.user.knuhui.networkmanager.model.reservation.booking.reservation;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Reservation {

    @SerializedName("resultinfo")
    @Expose
    private ReservationResultinfo resultinfo;

    public ReservationResultinfo getResultinfo() {
        return resultinfo;
    }

    public void setResultinfo(ReservationResultinfo resultinfo) {
        this.resultinfo = resultinfo;
    }

}
