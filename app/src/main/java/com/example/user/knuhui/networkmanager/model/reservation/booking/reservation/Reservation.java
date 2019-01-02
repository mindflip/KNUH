
package com.example.user.knuhui.networkmanager.model.reservation.booking.reservation;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "root", strict = false)
public class Reservation {

    @Element
    private ReservationResultinfo resultinfo;

    public ReservationResultinfo getResultinfo() {
        return resultinfo;
    }

    public void setResultinfo(ReservationResultinfo resultinfo) {
        this.resultinfo = resultinfo;
    }

}
