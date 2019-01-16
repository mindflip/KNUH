
package com.example.user.knuhui.networkmanager.model.reservation.booking.reservation;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "resultinfo", strict = false)
public class ReservationResultinfo {

    @Element
    private ReservationResult result;
    @Element
    private ReservationResultKM resultKM;

    public ReservationResult getResult() {
        return result;
    }

    public void setResult(ReservationResult result) {
        this.result = result;
    }

    public ReservationResultKM getResultKM() {
        return resultKM;
    }

    public void setResultKM(ReservationResultKM resultKM) {
        this.resultKM = resultKM;
    }
}
