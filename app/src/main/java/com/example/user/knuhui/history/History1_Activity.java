package com.example.user.knuhui.history;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.user.knuhui.BottomNaviSet;
import com.example.user.knuhui.R;
import com.example.user.knuhui.networkmanager.NetworkManager;
import com.example.user.knuhui.networkmanager.model.history.getOutList.GetOutList;
import com.example.user.knuhui.networkmanager.model.history.getOutList.GetOutListResult;
import com.example.user.knuhui.networkmanager.service.RelayService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class History1_Activity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private BottomNaviSet bottomNaviSet;

    private RelayService relayService;

    private List<GetOutListResult> getOutListResult;

    private Button btGetOutList;
    private ListView lvGetOutList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history1);

        bottomNaviSet = new BottomNaviSet(this,this.getClass().getSimpleName());
        bottomNavigationView = bottomNaviSet.getBottomNavigationView();

        android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.setTitle("수진이력정보조회(외래)");

        relayService = NetworkManager.getRelayService();
        getOutList();

        initLayout();
    }

    private void initLayout() {
        lvGetOutList = (ListView) findViewById(R.id.lvGetOutList);
        btGetOutList = (Button) findViewById(R.id.btGetOutList);
        btGetOutList.setOnClickListener(onClickListener);
    }

    private Button.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            callListItems();
        }
    };

    private void callListItems() {
        History1_ListViewAdapter adapter = new History1_ListViewAdapter();

        lvGetOutList.setAdapter(adapter);

        if(getOutListResult == null) {
            Toast.makeText(getApplicationContext(), "서버에서 값을 불러오지 못 했습니다.", Toast.LENGTH_SHORT).show();
        } else {
            for (GetOutListResult item : getOutListResult) {
                adapter.addItem(item.getDepartmentNm(), item.getDoctorNm(), item.getDataDate());
            }
        }
    }

    private void getOutList() {
        Call<GetOutList> call = relayService.getOutList("93888", "20180101", "20191231");

        call.enqueue(new Callback<GetOutList>() {
            @Override
            public void onResponse(Call<GetOutList> call, Response<GetOutList> response) {
                if(response.isSuccessful() && response.body() != null) {
                    getOutListResult = response.body().getResultinfo().getResult();
                    callListItems();
                }
            }

            @Override
            public void onFailure(Call<GetOutList> call, Throwable t) {
                Log.e("Not Response", t.getLocalizedMessage());
            }
        });
    }
}
