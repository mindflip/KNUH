package com.example.user.knuhui;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.user.knuhui.reservation.Reservation_Activity;
import com.example.user.knuhui.ticket.Ticket_Activity;
import com.example.user.knuhui.treatment.Treatment_Search_Activity;

public class BottomNaviSet {

    private BottomNavigationView bottomNavigationView;
    private String currentActivity;
    private Activity activity;

    public BottomNaviSet(Activity activity, String currentActivity) {

        this.activity = activity;
        bottomNavigationView = (BottomNavigationView) activity.findViewById(R.id.bottom_navigation);
        bottomNavigationView.inflateMenu(R.menu.bottom_menu);
        bottomNavigationView.setOnNavigationItemSelectedListener(bottomClick);
        this.currentActivity = currentActivity;
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);

    }

    private BottomNavigationView.OnNavigationItemSelectedListener bottomClick = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            int id = item.getItemId();
            Intent intent;
            switch (id) {
                case R.id.itHome :
                    menuOperation("MainActivity", MainActivity.class);

                    break;

                case R.id.itReservation :
                    menuOperation("Reservation_Activity", Reservation_Activity.class);

                    break;

                case R.id.itTreat :
                    menuOperation("Treatment_Search_Activity", Treatment_Search_Activity.class);

                    break;

                case R.id.itTicket :
                    menuOperation("Ticket_Activity", Ticket_Activity.class);

                    break;

                case R.id.itPay :
                    Toast.makeText(activity.getApplicationContext(),"서비스 준비중입니다.", Toast.LENGTH_SHORT).show();

                    break;
            }

            return true;
        }
    };

    private void menuOperation(String menuActivityName, Class menuClass) {
        if(!currentActivity.equals(menuActivityName)) {
            Intent intent = new Intent(activity.getApplicationContext(), menuClass);
            intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            activity.startActivity(intent);
        } else {
            Toast.makeText(activity.getApplicationContext(),"현재 화면입니다.", Toast.LENGTH_SHORT).show();
        }
    }

    public BottomNavigationView getBottomNavigationView() {
        return bottomNavigationView;
    }

    public void setBottomNavigationView(BottomNavigationView bottomNavigationView) {
        this.bottomNavigationView = bottomNavigationView;
    }
}
