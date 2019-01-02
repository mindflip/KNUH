package com.example.user.knuhui.profile;

import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.user.knuhui.BottomNaviSet;
import com.example.user.knuhui.R;
import com.example.user.knuhui.networkmanager.NetworkManager;
import com.example.user.knuhui.networkmanager.model.reservation.search.getRevList.GetRevListResult;
import com.example.user.knuhui.networkmanager.model.userinfo.getUserInfo.GetUserInfo;
import com.example.user.knuhui.networkmanager.model.userinfo.getUserInfo.GetUserInfoResult;
import com.example.user.knuhui.networkmanager.service.RelayService;

import org.w3c.dom.Text;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChangepwActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private BottomNaviSet bottomNaviSet;

    private TextView tvUserName, tvUserBirth, tvUserPhone, tvUserId, tvUserGender, tvUserAddr;
    private NetworkManager networkManager;
    private RelayService relayService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changepw);

        android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.setTitle("회원정보 조회");

        networkManager = NetworkManager.getInstance();
        relayService = networkManager.getRelayService();

        bottomNaviSet = new BottomNaviSet(this,this.getClass().getSimpleName());
        bottomNavigationView = bottomNaviSet.getBottomNavigationView();

        initLayout();

        callUserInfo();
    }

    private void initLayout() {
        tvUserName = (TextView) findViewById(R.id.tvUserName);
        tvUserBirth = (TextView) findViewById(R.id.tvUserBirth);
        tvUserPhone = (TextView) findViewById(R.id.tvUserPhone);
        tvUserId = (TextView) findViewById(R.id.tvUserId);
        tvUserGender = (TextView) findViewById(R.id.tvUserGender);
        tvUserAddr = (TextView) findViewById(R.id.tvUserAddr);

    }

    private void callUserInfo() {
        Call<GetUserInfo> call = relayService.getUserInfo("93888");

        call.enqueue(new Callback<GetUserInfo>() {
            @Override
            public void onResponse(Call<GetUserInfo> call, Response<GetUserInfo> response) {
                if (response.isSuccessful()) {
                    GetUserInfoResult item = response.body().getResultinfo().getResult();

                    tvUserName.setText(item.getPNm());
                    tvUserBirth.setText(item.getBirthDt());
                    tvUserPhone.setText(item.getCellphoneNo());
                    tvUserId.setText(item.getPId());
                    tvUserGender.setText(item.getGenderCd());
                    tvUserAddr.setText(item.getZipCode() + " / " + item.getZipCodeTxt());
                }
            }

            @Override
            public void onFailure(Call<GetUserInfo> call, Throwable t) {
                Log.e("Not Response", t.getLocalizedMessage());
            }
        });

    }
}