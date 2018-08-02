package com.example.user.knuhui;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.example.user.knuhui.history.History_Search_Activity;
import com.example.user.knuhui.profile.ProfileActivity;
import com.example.user.knuhui.reservation.Reservation_Activity;
import com.example.user.knuhui.reservation.Reservation_Search_Activity;
import com.example.user.knuhui.ticket.Ticket_Activity;
import com.example.user.knuhui.treatment.Treatment_Search_Activity;
import com.example.user.knuhui.treatment.Wait_Search_Activity;

public class MainActivity extends AppCompatActivity {

    private ImageView ivReserve, ivTicket, ivTreatment, ivPayment, ivCall, ivSetting;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        initLayout();
    }

    private void initLayout(){
        ivReserve = (ImageView) findViewById(R.id.ivReserve);
        ivTicket = (ImageView) findViewById(R.id.ivTicket);
        ivTreatment = (ImageView) findViewById(R.id.ivTreatment);
        ivPayment = (ImageView) findViewById(R.id.ivPayment);
        ivCall = (ImageView) findViewById(R.id.ivCall);
        ivSetting = (ImageView) findViewById(R.id.ivSetting);

        ivReserve.setOnClickListener(onClickListener);
        ivTicket.setOnClickListener(onClickListener);
        ivTreatment.setOnClickListener(onClickListener);
        ivPayment.setOnClickListener(onClickListener);
        ivCall.setOnClickListener(onClickListener);
        ivSetting.setOnClickListener(onClickListener);
    }

    private Button.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent;
            switch (v.getId()){
                case R.id.ivReserve :
                    menuInflate(R.id.ivReserve,R.menu.reserve_menu);
                    break;

                case R.id.ivTicket :
                    intent = new Intent(MainActivity.this, Ticket_Activity.class);
                    startActivity(intent);
                    break;

                case R.id.ivTreatment :
                    menuInflate(R.id.ivTreatment, R.menu.treatment_menu);
                    break;

                case R.id.ivPayment :
                    break;

                case R.id.ivCall :
                    menuInflate(R.id.ivCall, R.menu.call_menu);
                    break;

                case R.id.ivSetting :
                    intent = new Intent(MainActivity.this, ProfileActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    };

    private void menuInflate(int imageView, int menu){
        PopupMenu pum = new PopupMenu(getApplicationContext(), findViewById(imageView));
        pum.inflate(menu);
        pum.show();

        pum.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent intent;
                Toast.makeText(getApplicationContext(), "팝업메뉴 이벤트 처리 - " + item.getTitle(),Toast.LENGTH_SHORT).show();
                switch (item.getItemId()){
                    case R.id.itTrReserve:
                        intent = new Intent(MainActivity.this, Reservation_Activity.class);
                        startActivity(intent);
                        break;

                    case R.id.itReserveRecord:
                        intent = new Intent(MainActivity.this, Reservation_Search_Activity.class);
                        startActivity(intent);
                        break;

                    case R.id.itDestination:
                        intent = new Intent(MainActivity.this, RoadList_Activity.class);
                        startActivity(intent);
                        break;

                    case R.id.itWaiting:
                        intent = new Intent(MainActivity.this, Wait_Search_Activity.class);
                        startActivity(intent);
                        break;

                    case R.id.itTrRecord:
                        intent = new Intent(MainActivity.this, History_Search_Activity.class);
                        startActivity(intent);
                        break;

                    case R.id.itTrSearch:
                        intent = new Intent(MainActivity.this, Treatment_Search_Activity.class);
                        startActivity(intent);
                        break;

                    case R.id.itChangeGown:
                        callDialog((String) item.getTitle());
                        break;

                    case R.id.itChangeSheet:
                        callDialog((String) item.getTitle());
                        break;

                    case R.id.itChangeFluid:
                        callDialog((String) item.getTitle());
                        break;
                }
                return false;
            }
        });
    }

    private void callDialog(String title){
        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setTitle(title);
        alertDialog.setMessage("입원환자가 아닙니다.");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }
}