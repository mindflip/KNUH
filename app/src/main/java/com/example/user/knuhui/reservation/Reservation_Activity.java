package com.example.user.knuhui.reservation;

import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.telecom.Call;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.knuhui.BottomNaviSet;
import com.example.user.knuhui.MainActivity;
import com.example.user.knuhui.R;
import com.example.user.knuhui.networkmanager.NetworkManager;
import com.example.user.knuhui.networkmanager.model.reservation.booking.getRevDate.GetRevDate;
import com.example.user.knuhui.networkmanager.model.reservation.booking.getRevDate.GetRevDateEtcmsg;
import com.example.user.knuhui.networkmanager.model.reservation.booking.getRevDate.GetRevDateResult;
import com.example.user.knuhui.networkmanager.model.reservation.booking.getRevDept.GetRevDept;
import com.example.user.knuhui.networkmanager.model.reservation.booking.getRevDept.GetRevDeptResult;
import com.example.user.knuhui.networkmanager.model.reservation.booking.getRevDoc.GetRevDoc;
import com.example.user.knuhui.networkmanager.model.reservation.booking.getRevDoc.GetRevDocResult;
import com.example.user.knuhui.networkmanager.model.reservation.booking.getRevTime.GetRevTime;
import com.example.user.knuhui.networkmanager.model.reservation.booking.getRevTime.GetRevTimeResult;
import com.example.user.knuhui.networkmanager.model.reservation.booking.reservation.Reservation;
import com.example.user.knuhui.networkmanager.model.reservation.booking.reservation.ReservationResult;
import com.example.user.knuhui.networkmanager.model.reservation.search.getRevList.GetRevList;
import com.example.user.knuhui.networkmanager.model.reservation.search.getRevList.GetRevListResult;
import com.example.user.knuhui.networkmanager.service.RelayService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import okhttp3.HttpUrl;
import retrofit2.Callback;
import retrofit2.Response;

public class Reservation_Activity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private BottomNaviSet bottomNaviSet;

    private Spinner spDept, spDoc, spDate, spTime;
    private Spinner spinnerTest;
    private TextView tvExpDate;
    private Button btReservation;

    private NetworkManager networkManager;
    private RelayService relayService;
    private String[] Temp0, Temp1;

    private List<GetRevDateResult> getRevDateResult;
    private List<GetRevDeptResult> getRevDeptResult;
    private List<GetRevDocResult> getRevDocResult;
    private List<GetRevTimeResult> getRevTimeResult;
//    private ReservationResult reservationResult;

    private GetRevListResult getRevListResult;

    private String currentDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);

        ActionBar ab = getSupportActionBar();
        ab.setTitle("진료 예약");

        bottomNaviSet = new BottomNaviSet(this, this.getClass().getSimpleName());
        bottomNavigationView = bottomNaviSet.getBottomNavigationView();

        initLayout();

        getRevListResult = new GetRevListResult();

        networkManager = NetworkManager.getInstance();
        relayService = networkManager.getRelayService();

        getRevDept();

//        Temp0 = getResources().getStringArray(R.array.getRevDept);
//        for ( String i : Temp0) {
//            Log.d("StringArrayRes", "///////////    " + i);
//        }
//
//        Button button = (Button)findViewById(R.id.btReservation);
//
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
////                Toast.makeText(getApplicationContext(),"예약되었습니다.",Toast.LENGTH_LONG).show();
//                Log.d("Reservation", getRevListResult.toString());
//
//            }
//        });
    }

    Spinner.OnItemSelectedListener onItemSelectedListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

             switch (parent.getId()) {
                case R.id.spDept :
                    getRevListResult.setDepartmentNm(parent.getItemAtPosition(position).toString());
                    for(int i = 0; i < getRevDeptResult.size(); i++){
                        if(getRevListResult.getDepartmentNm().equals(getRevDeptResult.get(i).getDepartmentNm())){
                            getRevListResult.setDepartmentCd(getRevDeptResult.get(i).getDepartmentCd());
                        }
                    }

                    getRevDoc();

                    break;

                case R.id.spDoc :
                    getRevListResult.setDoctorNm(parent.getItemAtPosition(position).toString());
                    for(int i=0; i < getRevDocResult.size(); i++) {
                        if(getRevListResult.getDoctorNm().equals(getRevDocResult.get(i).getDoctorNm())){
                            getRevListResult.setDoctorId(getRevDocResult.get(i).getDoctorId());
                        }
                    }

                    Log.d("checkDocId", getRevListResult.getDoctorId());
                    getRevDate();
                    break;

                case R.id.spDate :
                    getRevListResult.setDataDate(parent.getItemAtPosition(position).toString());
                    for(int i=0; i < getRevDateResult.size(); i++) {
                        if(getRevListResult.getDataDate().equals(getRevDateResult.get(i).getDataDate())){
                            getRevListResult.setDataDate(getRevDateResult.get(i).getDataDate());
                        }
                    }

                    getRevTime();
                    break;

                case R.id.spTime :
                    getRevListResult.setDataTime(parent.getItemAtPosition(position).toString());

                    break;
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };

    private void getItem (int ResId, Spinner spinner) {
        List<String> spinnerArray =  new ArrayList<String>();
        Temp0 = getResources().getStringArray(ResId);
        for (String str : Temp0) {
            spinnerArray.add(str);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getApplicationContext(), android.R.layout.simple_spinner_item, spinnerArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
    }

    private void getRevDept() {
        // Service 메서드는 바뀔 수 있음 / 지금은 테스트용 (아님)
        retrofit2.Call<GetRevDept> call = relayService.getRevDept();
        call.enqueue(new Callback<GetRevDept>() {
            @Override
            public void onResponse(retrofit2.Call<GetRevDept> call, Response<GetRevDept> response) {
                if(response.isSuccessful()) {
                    getRevDeptResult = response.body().getResultinfo().getResult();
                    List<String> spinnerArray =  new ArrayList<String>();

                    for(int i=0; i < getRevDeptResult.size(); i++) {
                        Log.d("resultResp", getRevDeptResult.get(i).toString());
                        spinnerArray.add(getRevDeptResult.get(i).getDepartmentNm());
                    }

                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                            getApplicationContext(), android.R.layout.simple_spinner_item, spinnerArray);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                    spDept.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(retrofit2.Call<GetRevDept> call, Throwable t) {
                Log.e("Not Response", t.getLocalizedMessage());
                Toast.makeText(getApplicationContext(), "서버와 연결이 불안정합니다.\n해당 화면에 다시 접속해주세요.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getRevDoc() {
        spDate.setAdapter(null);
        spTime.setAdapter(null);
        retrofit2.Call<GetRevDoc> call = relayService.getRevDoc(getRevListResult.getDepartmentCd(), "93888");
        call.enqueue(new Callback<GetRevDoc>() {
            @Override
            public void onResponse(retrofit2.Call<GetRevDoc> call, Response<GetRevDoc> response) {
                if(response.isSuccessful()) {
                    getRevDocResult = response.body().getResultinfo().getResult();
                    List<String> spinnerArray = new ArrayList<>();

                    for(int i=0; i< getRevDocResult.size(); i++) {
                        Log.d("resultResp", getRevDocResult.get(i).toString());
                        spinnerArray.add(getRevDocResult.get(i).getDoctorNm());
                    }

                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                            getApplicationContext(), android.R.layout.simple_spinner_item, spinnerArray);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                    spDoc.setAdapter(adapter);

                }
            }

            @Override
            public void onFailure(retrofit2.Call<GetRevDoc> call, Throwable t) {
                Log.e("Not Response", t.getLocalizedMessage());

            }
        });
    }

    private void getRevDate() {
        spTime.setAdapter(null);

        retrofit2.Call<GetRevDate> call = relayService.getRevDate(getRevListResult.getDepartmentCd(), getRevListResult.getDoctorId(), currentDate);

//        Log.d("checkDocId", getRevListResult.getDoctorId());
        call.enqueue(new Callback<GetRevDate>() {
            @Override
            public void onResponse(retrofit2.Call<GetRevDate> call, Response<GetRevDate> response) {
                if(response.isSuccessful()) {
                    getRevDateResult = response.body().getResultinfo().getResult();
                    List<String> spinnerArray = new ArrayList<>();

                    if (getRevDateResult == null) {
                        GetRevDateEtcmsg getRevDateEtcmsg = response.body().getResultinfo().getEtcmsg();
                        Log.d("checkErrorMsg", getRevDateEtcmsg.getErrormsg());
                        errorDialog("날짜 선택", getRevDateEtcmsg.getErrormsg());
                        return;
                    }


                    for(int i=0; i< getRevDateResult.size(); i++) {
                        Log.d("resultResp", getRevDateResult.get(i).toString());
                        spinnerArray.add(getRevDateResult.get(i).getDataDate());
                    }

                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                            getApplicationContext(), android.R.layout.simple_spinner_item, spinnerArray);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                    spDate.setAdapter(adapter);
            }
        }

            @Override
            public void onFailure(retrofit2.Call<GetRevDate> call, Throwable t) {
                Log.e("Not Response", t.getLocalizedMessage());
            }
        });
    }

    private void getRevTime() {
        retrofit2.Call<GetRevTime> call = relayService.getRevTime(getRevListResult.getDepartmentCd(), getRevListResult.getDoctorId(), getRevListResult.getDataDate(), "93888", "전산실.");

        call.enqueue(new Callback<GetRevTime>() {
            @Override
            public void onResponse(retrofit2.Call<GetRevTime> call, Response<GetRevTime> response) {
                if(response.isSuccessful()) {
                    getRevTimeResult = response.body().getResultinfo().getResult();
                    List<String> spinnerArray = new ArrayList<>();

                    if (getRevTimeResult == null)
                        return;

                    for(int i=0; i< getRevTimeResult.size(); i++) {
                        Log.d("resultResp", getRevTimeResult.get(i).toString());
                        spinnerArray.add(getRevTimeResult.get(i).getDataTime());
                    }

                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                            getApplicationContext(), android.R.layout.simple_spinner_item, spinnerArray);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                    spTime.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(retrofit2.Call<GetRevTime> call, Throwable t) {
                Log.e("Not Response", t.getLocalizedMessage());
            }
        });
    }

    private void reservation() {
        retrofit2.Call<Reservation> call = relayService.reservation(getRevListResult.getDepartmentCd(), getRevListResult.getDoctorId(), getRevListResult.getDataDate(),
                "93888", "전산실.", getRevListResult.getDataTime(), "증상입니다");

        call.enqueue(new Callback<Reservation>() {
            @Override
            public void onResponse(retrofit2.Call<Reservation> call, Response<Reservation> response) {
                if(response.isSuccessful()) {
                    ReservationResult reservationResult = response.body().getResultinfo().getResult();

                    if(reservationResult.getCount().equals("1")) {
                        Toast.makeText(getApplicationContext(),"예약되었습니다.",Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(),"서버 문제로 예약에 실패하였습니다.",Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onFailure(retrofit2.Call<Reservation> call, Throwable t) {
                Log.e("Not Response", t.getLocalizedMessage());
            }
        });
    }

    private void errorDialog(String title, String message) {
        AlertDialog alertDialog = new AlertDialog.Builder(Reservation_Activity.this).create();
        alertDialog.setTitle(title);
        alertDialog.setMessage(message);
        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "닫기",
                new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }

    private void initLayout() {
        spDept = (Spinner) findViewById(R.id.spDept);
        spDoc = (Spinner) findViewById(R.id.spDoc);
        spDate = (Spinner) findViewById(R.id.spDate);
        spTime = (Spinner) findViewById(R.id.spTime);
        tvExpDate = (TextView) findViewById(R.id.tvExpDate);
        currentDate = new SimpleDateFormat("yyyyMM", Locale.getDefault()).format(new Date());
        tvExpDate.setText("*날짜 - " + currentDate + " 기준");
        btReservation = (Button) findViewById(R.id.btReservation);

        btReservation.setOnClickListener(onClickListener);
        spDept.setOnItemSelectedListener(onItemSelectedListener);
        spDoc.setOnItemSelectedListener(onItemSelectedListener);
        spDate.setOnItemSelectedListener(onItemSelectedListener);
        spTime.setOnItemSelectedListener(onItemSelectedListener);
    }

    Button.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            reservation();
        }
    };
}
