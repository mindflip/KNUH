package com.example.user.knuhui.treatment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.user.knuhui.BottomNaviSet;
import com.example.user.knuhui.R;
import com.example.user.knuhui.networkmanager.NetworkManager;
import com.example.user.knuhui.networkmanager.model.prescription.getPrescList.GetPrescList;
import com.example.user.knuhui.networkmanager.model.prescription.getPrescList.GetPrescListResult;
import com.example.user.knuhui.networkmanager.service.RelayService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Treatment_Search_Activity extends AppCompatActivity {

    private RelayService relayService;

    private List<GetPrescListResult> getPrescListResult;

    private ListView lvGetPrescList;
    private Button btGetPrescList;

    private Treatment_ListViewAdapter adapter;

    private BottomNavigationView bottomNavigationView;
    private BottomNaviSet bottomNaviSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treatment_search);

        android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.setTitle("처방 조회");

        bottomNaviSet = new BottomNaviSet(this,this.getClass().getSimpleName());
        bottomNavigationView = bottomNaviSet.getBottomNavigationView();

        relayService = NetworkManager.getRelayService();
        getPrescList();

        initLayout();
    }

    private void initLayout() {
        lvGetPrescList = (ListView) findViewById(R.id.lvGetPrescList);
        btGetPrescList = (Button) findViewById(R.id.btGetPrescList);

        adapter = new Treatment_ListViewAdapter();
        lvGetPrescList.setAdapter(adapter);

        btGetPrescList.setOnClickListener(onClickListener);
        lvGetPrescList.setOnItemClickListener(onItemClickListener);
    }

    private Button.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            callListItems();
        }
    };

    private ListView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            int listSize = getPrescListResult.size();
            TreatmentItem item = (TreatmentItem) adapter.getItem(position);

            callDangerDialog(item.getDangerNote());
        }
    };

    private void callDangerDialog(String msg){
        AlertDialog alertDialog = new AlertDialog.Builder(Treatment_Search_Activity.this).create();
        alertDialog.setTitle("주의사항");
        alertDialog.setMessage(msg);
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }

    private void callListItems() {
        if(getPrescListResult == null) {
            Toast.makeText(getApplicationContext(), "서버에서 값을 불러오지 못 했습니다.", Toast.LENGTH_SHORT).show();
        } else {
            for (int i = getPrescListResult.size(); i > 0; i--) {
                GetPrescListResult item = getPrescListResult.get(i-1);
                adapter.addItem(item.getDepartmentNm(), item.getPrescriptionDt(), item.getMedicineNm(), item.getUsageNm(), item.getEffectNm(), item.getDangerNote());
                Log.i("checkItemContent",item.toString());
            }
        }

        adapter.notifyDataSetChanged();
    }

    private void getPrescList() {
        Call<GetPrescList> call = relayService.getPrescList("3258059", "20150101", "20191231");

        call.enqueue(new Callback<GetPrescList>() {
            @Override
            public void onResponse(Call<GetPrescList> call, Response<GetPrescList> response) {
                if(response.isSuccessful() && response.body() != null) {
                    getPrescListResult = response.body().getResultinfo().getResult();
                    callListItems();
                }
            }

            @Override
            public void onFailure(Call<GetPrescList> call, Throwable t) {
                Log.e("Not Response", t.getLocalizedMessage());
            }
        });
    }


}
