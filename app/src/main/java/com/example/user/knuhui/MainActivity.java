package com.example.user.knuhui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.example.user.knuhui.dicom.android.dicomviewer.DICOMFileChooser;
import com.example.user.knuhui.history.History_Search_Activity;
import com.example.user.knuhui.networkmanager.NetworkManager;
import com.example.user.knuhui.networkmanager.model.User;
import com.example.user.knuhui.networkmanager.model.reservation.booking.getRevDept.GetRevDept;
import com.example.user.knuhui.networkmanager.model.reservation.booking.getRevDept.GetRevDeptResult;
import com.example.user.knuhui.networkmanager.model.reservation.booking.getRevDoc.GetRevDoc;
import com.example.user.knuhui.networkmanager.model.reservation.booking.getRevDoc.GetRevDocResult;
import com.example.user.knuhui.networkmanager.model.userinfo.updateVehicleNo.UpdateVehicleNo;
import com.example.user.knuhui.networkmanager.model.userinfo.updateVehicleNo.UpdateVehicleNoResult;
import com.example.user.knuhui.networkmanager.service.RelayService;
import com.example.user.knuhui.profile.ProfileActivity;
import com.example.user.knuhui.reservation.Reservation_Activity;
import com.example.user.knuhui.reservation.Reservation_Search_Activity;
import com.example.user.knuhui.ticket.Ticket_Activity;
import com.example.user.knuhui.treatment.Treatment_Search_Activity;
import com.example.user.knuhui.treatment.Wait_Search_Activity;
import com.google.gson.JsonObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private NetworkManager networkManager;
    private RelayService relayService;

    private ImageView ivReserve, ivTicket, ivTreatment, ivPayment, ivCall, ivSetting, ivDicom;

    private BottomNavigationView bottomNavigationView;
    private BottomNaviSet bottomNaviSet;

    private String pId;

    private int dialogItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        initPref();
        initLayout();

        networkManager = NetworkManager.getInstance();
        relayService = networkManager.getRelayService();

        introDialog();

        Log.d("actname", this.getClass().getSimpleName());

        Intent intent = getIntent();
        pId = intent.getExtras().getString("pId");
        Log.d("getIntent", "/////////////////"+pId);

//        callTest3();

    }

//    private void callTest3() {
//        Call<UpdateVehicleNo> call = relayService.updateVehicleNo("93888", "1224");
//
//        call.enqueue(new Callback<UpdateVehicleNo>() {
//            @Override
//            public void onResponse(Call<UpdateVehicleNo> call, Response<UpdateVehicleNo> response) {
//                if(response.isSuccessful()) {
//
//                    UpdateVehicleNoResult item = response.body().getResultinfo().getResult();
//
//                    Log.d("resultResp", item.toString());
//
//                }
//            }
//
//            @Override
//            public void onFailure(Call<UpdateVehicleNo> call, Throwable t) {
//                Log.e("Not Response", t.getLocalizedMessage());
//            }
//        });
//    }

    private void initPref() {
        SharedPreferences testUserPreferences = getSharedPreferences("testUser",MODE_PRIVATE);

        testUserPreferences.getString("birthDt","20150725");
        testUserPreferences.getString("pNm", "전산실.");
        testUserPreferences.getString("cellphoneNo","01031533455");
        testUserPreferences.getString("pId","93888");
        testUserPreferences.getString("genderCd","F");
        testUserPreferences.getString("inHospitalYn","N");
        testUserPreferences.getString("vehicleNo","실험1234");
        testUserPreferences.getString("zipCode","700740");
        testUserPreferences.getString("zipCodeTxt","경북 김천시 어모면");
        testUserPreferences.getString("address","T");

        SharedPreferences.Editor editor = testUserPreferences.edit();
//        if(testUserPreferences.getString("name"))
    }

    private void initLayout(){
        ivReserve = (ImageView) findViewById(R.id.ivReserve);
        ivTicket = (ImageView) findViewById(R.id.ivTicket);
        ivTreatment = (ImageView) findViewById(R.id.ivTreatment);
        ivPayment = (ImageView) findViewById(R.id.ivPayment);
        ivCall = (ImageView) findViewById(R.id.ivCall);
        ivSetting = (ImageView) findViewById(R.id.ivSetting);
        ivDicom = (ImageView) findViewById(R.id.ivDicom);

        ivReserve.setOnClickListener(onClickListener);
        ivTicket.setOnClickListener(onClickListener);
        ivTreatment.setOnClickListener(onClickListener);
        ivPayment.setOnClickListener(onClickListener);
        ivCall.setOnClickListener(onClickListener);
        ivSetting.setOnClickListener(onClickListener);
        ivDicom.setOnClickListener(onClickListener);

        bottomNaviSet = new BottomNaviSet(this,this.getClass().getSimpleName());
        bottomNavigationView = bottomNaviSet.getBottomNavigationView();
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
//                    intent = new Intent(MainActivity.this, Ticket_Activity.class);
//                    startActivity(intent);
                    callDialog("번호표 발급");
//                    callTest3();
                    break;

                case R.id.ivTreatment :
                    menuInflate(R.id.ivTreatment, R.menu.treatment_menu);
                    break;

                case R.id.ivPayment :
                    callWaiting("결제","서비스 준비 중입니다." );

                    break;

                case R.id.ivCall :
                    menuInflate(R.id.ivCall, R.menu.call_menu);
                    break;

                case R.id.ivSetting :
                    intent = new Intent(MainActivity.this, ProfileActivity.class);
                    startActivity(intent);
                    break;

                case R.id.ivDicom :
                    intent = new Intent(MainActivity.this, DICOMFileChooser.class);
                    startActivity(intent);
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
//                        intent = new Intent(MainActivity.this, Wait_Search_Activity.class);
//                        startActivity(intent);
                        callWaiting("진료대기시간 조회","서비스 준비 중입니다." );
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
        alertDialog.setMessage("내원상태에서만 서비스가 제공됩니다.");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }

    private void callWaiting(String title, String Message){
        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setTitle(title);
        alertDialog.setMessage(Message);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }

    private void introDialog() {
        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setTitle("내원 알림");
        alertDialog.setMessage("현재 내원 상태가 아니라 서비스 이용에 제한이 있습니다.");
        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "닫기",
                new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }

    private void noticeDialog() {
        final ProgressDialog pd = new ProgressDialog(MainActivity.this,R.style.MyAlertDialogStyle);
        pd.setMessage("알림 수신 중입니다.");
        pd.show();

        Handler pdCanceller = new Handler();
        pdCanceller.postDelayed(new Runnable() {
            @Override
            public void run() {
                pd.cancel();
                testReservDialog();
            }
        }, 3000);
    }

    private void testReservDialog() {

        final CharSequence[] testList = {"혈액검사실로 가세요.", "CT실로 가세요."};
        AlertDialog.Builder alt_bld = new AlertDialog.Builder(this);
        alt_bld.setTitle("2건의 검사예약이 있습니다");
        alt_bld.setSingleChoiceItems(testList, -1, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
//                Toast.makeText(getApplicationContext(), "검사항목 = "+testList[item] + " / " + item, Toast.LENGTH_SHORT).show();
                // dialog.cancel();
                dialogItem = item;

            }
        });
        AlertDialog alert = alt_bld.create();
        alert.setButton(AlertDialog.BUTTON_POSITIVE, "확인",
                new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
//                        Intent intent = (dialogItem == 0) ? new Intent(MainActivity.this, RoadList_Activity.class) : new Intent (MainActivity.this, Treatment_Search_Activity.class);
//                        startActivity(intent);

                        Intent intent;

                        if (dialogItem == 0) {
                            intent = new Intent(MainActivity.this, RoadList_Activity.class);
                            intent.putExtra("startPoint", "외래접수동");
                            intent.putExtra("endPoint","채혈실");
                            startActivity(intent);
                        } else {
                            intent = new Intent (MainActivity.this, Treatment_Search_Activity.class);
                            intent.putExtra("startPoint", "외래접수동");
                            intent.putExtra("endPoint","CT촬영실");
                            startActivity(intent);
                        }
                        dialog.dismiss();
                    }
                });
        alert.show();

    }
}