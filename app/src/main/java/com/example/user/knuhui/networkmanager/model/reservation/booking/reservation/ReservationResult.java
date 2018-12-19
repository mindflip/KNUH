
package com.example.user.knuhui.networkmanager.model.reservation.booking.reservation;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ReservationResult {

    @SerializedName("count")
    @Expose
    private String count;

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "ReservationResult{" +
                "count='" + count + '\'' +
                '}';
    }
}
