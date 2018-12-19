package com.example.user.knuhui.reservation;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.telecom.Call;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.user.knuhui.BottomNaviSet;
import com.example.user.knuhui.R;
import com.example.user.knuhui.networkmanager.NetworkManager;
import com.example.user.knuhui.networkmanager.model.reservation.booking.getRevDept.GetRevDept;
import com.example.user.knuhui.networkmanager.model.reservation.booking.getRevDept.GetRevDeptResult;
import com.example.user.knuhui.networkmanager.model.reservation.booking.getRevDoc.GetRevDoc;
import com.example.user.knuhui.networkmanager.model.reservation.search.getRevList.GetRevListResult;
import com.example.user.knuhui.networkmanager.service.RelayService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Callback;
import retrofit2.Response;

public class Reservation_Activity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private BottomNaviSet bottomNaviSet;

    private Spinner spDept, spDoc, spDate, spTime;
    private Spinner spinnerTest;

    private NetworkManager getNetworkManager;
    private NetworkManager postNetworkManager;
    private RelayService relayService;
    private String[] Temp0, Temp1;

    private GetRevListResult getRevListResult;

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

        getNetworkManager = new NetworkManager(NetworkManager.RELAY_URL_GET);
        postNetworkManager = new NetworkManager(NetworkManager.RELAY_URL_POST);

        relayService = getNetworkManager.getRelayService();

        getRevDept();


//        Temp0 = getResources().getStringArray(R.array.getRevDept);
//        for ( String i : Temp0) {
//            Log.d("StringArrayRes", "///////////    " + i);
//        }

        Button button = (Button)findViewById(R.id.btReservation);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"예약되었습니다.",Toast.LENGTH_LONG).show();
                Log.d("Reservation", getRevListResult.toString());
            }
        });
    }

    Spinner.OnItemSelectedListener onItemSelectedListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

             switch (parent.getId()) {
                case R.id.spDept :
                    switch (parent.getItemAtPosition(position).toString()) {
                        case "방사선종양학과" :
                            getItem(R.array.getRevDoc_2170000000, spDoc);
                            break;

                        case "산부인과" :
                            getItem(R.array.getRevDoc_2100000000, spDoc);
                            break;

                        case "이비인후과" :
                            getItem(R.array.getRevDoc_2130000000, spDoc);
                            break;

                        case "재활의학과" :
                            getItem(R.array.getRevDoc_2220000000, spDoc);
                            break;

                        case  "정형외과" :
                            getItem(R.array.getRevDoc_2050000000, spDoc);
                            break;

                        case "핵의학과" :
                            getItem(R.array.getRevDoc_2180000000, spDoc);
                            break;

                        case "흉부외과" :
                            getItem(R.array.getRevDoc_2070000000, spDoc);
                            break;
                    }
                    getRevListResult.setDepartmentNm(parent.getItemAtPosition(position).toString());

                    break;

                case R.id.spDoc :
                    switch (parent.getItemAtPosition(position).toString()) {
                        case "김재철" :
                            getItem(R.array.getRevDate_kjc, spDate);
                            break;

                        case "이택후" :

                            break;

                        case "김정수" :

                            break;

                        case "김애령" :

                            break;

                        case "김준우" :

                            break;

                        case "안병철" :

                            break;

                        case "김근직" :

                            break;
                    }
                    getRevListResult.setDoctorNm(parent.getItemAtPosition(position).toString());

                    break;

                case R.id.spDate :
                    switch (parent.getItemAtPosition(position).toString()) {
                        case "20181220" :
                            getItem(R.array.getRevTime, spTime);
                            break;

                        case "20181221" :

                            break;
                    }
                    getRevListResult.setDataDate(parent.getItemAtPosition(position).toString());

                    break;

                case R.id.spTime :
                    switch (parent.getItemAtPosition(position).toString()) {
                        case "0900" :

                            break;
                    }
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
        // Service 메서드는 바뀔 수 있음 / 지금은 테스트용
        retrofit2.Call<GetRevDept> call = relayService.getRevDept();
        call.enqueue(new Callback<GetRevDept>() {
            @Override
            public void onResponse(retrofit2.Call<GetRevDept> call, Response<GetRevDept> response) {
                if(response.isSuccessful()) {
                    List<GetRevDeptResult> item = response.body().getResultinfo().getResult();
                    List<String> spinnerArray =  new ArrayList<String>();

                    for(int i=0; i < item.size(); i++) {
                        Log.d("resultResp", item.get(i).toString());
                        spinnerArray.add(item.get(i).getDepartmentNm());
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
            }
        });
    }

    private void initLayout() {
        spDept = (Spinner) findViewById(R.id.spDept);
        spDoc = (Spinner) findViewById(R.id.spDoc);
        spDate = (Spinner) findViewById(R.id.spDate);
        spTime = (Spinner) findViewById(R.id.spTime);

        spDept.setOnItemSelectedListener(onItemSelectedListener);
        spDoc.setOnItemSelectedListener(onItemSelectedListener);
        spDate.setOnItemSelectedListener(onItemSelectedListener);
        spTime.setOnItemSelectedListener(onItemSelectedListener);

    }
}
