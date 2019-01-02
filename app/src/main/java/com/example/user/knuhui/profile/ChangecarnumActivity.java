package com.example.user.knuhui.profile;

import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.user.knuhui.BottomNaviSet;
import com.example.user.knuhui.R;
import com.example.user.knuhui.networkmanager.NetworkManager;
import com.example.user.knuhui.networkmanager.model.userinfo.getUserInfo.GetUserInfo;
import com.example.user.knuhui.networkmanager.model.userinfo.getUserInfo.GetUserInfoResult;
import com.example.user.knuhui.networkmanager.service.RelayService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChangecarnumActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private BottomNaviSet bottomNaviSet;

    private TextView tvCarNumber;
    private EditText etChangeCarNumber;
    private Button btChangeCarNumber;

    private RelayService relayService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changecarnum);

        android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.setTitle("차량번호 변경");

        bottomNaviSet = new BottomNaviSet(this,this.getClass().getSimpleName());
        bottomNavigationView = bottomNaviSet.getBottomNavigationView();
        initLayout();

        relayService = NetworkManager.getRelayService();
        callUserCarNum();

    }

    private void initLayout() {
        tvCarNumber = (TextView) findViewById(R.id.tvCarNumber);
        etChangeCarNumber = (EditText) findViewById(R.id.etChangeCarNumber);
        btChangeCarNumber = (Button) findViewById(R.id.btChangeCarNumber);


    }


    private Button.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btChangeAddrNumber :


                    break;
            }

        }
    };

    private void callUserCarNum() {
        Call<GetUserInfo> call = relayService.getUserInfo("93888");

        call.enqueue(new Callback<GetUserInfo>() {
            @Override
            public void onResponse(Call<GetUserInfo> call, Response<GetUserInfo> response) {
                if (response.isSuccessful()) {
                    GetUserInfoResult item = response.body().getResultinfo().getResult();

                    tvCarNumber.setText(item.getVehicleNo());
                }
            }

            @Override
            public void onFailure(Call<GetUserInfo> call, Throwable t) {
                Log.e("Not Response", t.getLocalizedMessage());
            }
        });
    }
}
