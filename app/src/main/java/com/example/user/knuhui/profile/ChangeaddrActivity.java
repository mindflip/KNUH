package com.example.user.knuhui.profile;

import android.content.DialogInterface;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.knuhui.BottomNaviSet;
import com.example.user.knuhui.R;
import com.example.user.knuhui.networkmanager.NetworkManager;
import com.example.user.knuhui.networkmanager.model.userinfo.getUserInfo.GetUserInfo;
import com.example.user.knuhui.networkmanager.model.userinfo.getUserInfo.GetUserInfoResult;
import com.example.user.knuhui.networkmanager.model.userinfo.updateAddress.UpdateAddress;
import com.example.user.knuhui.networkmanager.model.userinfo.updateAddress.UpdateAddressResult;
import com.example.user.knuhui.networkmanager.service.RelayService;
import com.example.user.knuhui.reservation.Reservation_Activity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.user.knuhui.networkmanager.service.TempUsers.EMR_TEST_USER;

public class ChangeaddrActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private BottomNaviSet bottomNaviSet;

    private TextView tvAddrNumber;
    private EditText etChangeZipcode, etChangeZipcodetxt, etChangeAddr;
    private Button btChangeAddrNumber;

    private RelayService relayService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changeaddr);

        android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.setTitle("주소 변경");

        bottomNaviSet = new BottomNaviSet(this,this.getClass().getSimpleName());
        bottomNavigationView = bottomNaviSet.getBottomNavigationView();

        initLayout();

        relayService = NetworkManager.getRelayService();
        callUserAddr();
    }

    private void initLayout() {
        tvAddrNumber = (TextView) findViewById(R.id.tvAddrNumber);
        etChangeZipcode = (EditText) findViewById(R.id.etChangeZipcode);
        etChangeZipcodetxt = (EditText) findViewById(R.id.etChangeZipcodetxt);
        etChangeAddr = (EditText) findViewById(R.id.etChangeAddr);
        btChangeAddrNumber = (Button) findViewById(R.id.btChangeAddrNumber);

        btChangeAddrNumber.setOnClickListener(onClickListener);
    }

    private Button.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btChangeAddrNumber :

                    String zipcode = etChangeZipcode.getText().toString();
                    String zipcodetxt = etChangeZipcodetxt.getText().toString();
                    String address = etChangeAddr.getText().toString();

                    if (zipcode.equals("") | zipcodetxt.equals("") | address.equals("")) {
                        Toast.makeText(ChangeaddrActivity.this, "모든 주소를 입력해주세요.", Toast.LENGTH_SHORT).show();
                    } else {
                        Call<UpdateAddress> call = relayService.updateAddress(EMR_TEST_USER, zipcode, zipcodetxt,address);

                        call.enqueue(new Callback<UpdateAddress>() {
                            @Override
                            public void onResponse(Call<UpdateAddress> call, Response<UpdateAddress> response) {
                                UpdateAddressResult result = response.body().getResultinfo().getResult();
                                Log.d("updateSuccess", result.toString());
                                if(result.getCount().equals("1")){
                                    noticeDialog("", "주소를 등록하였습니다.");
                                    callUserAddr();
                                }
                            }

                            @Override
                            public void onFailure(Call<UpdateAddress> call, Throwable t) {
                                Log.e("Not Response", t.getLocalizedMessage());
                                noticeDialog("서버연결 오류","주소를 다시 전송해주세요.");
                            }
                        });
                    }
                    break;
            }
        }
    };

    private void callUserAddr() {
        Call<GetUserInfo> call = relayService.getUserInfo(EMR_TEST_USER);

        call.enqueue(new Callback<GetUserInfo>() {
            @Override
            public void onResponse(Call<GetUserInfo> call, Response<GetUserInfo> response) {
                if (response.isSuccessful()) {
                    GetUserInfoResult item = response.body().getResultinfo().getResult();

                    tvAddrNumber.setText(item.getZipCode() + " / " + item.getZipCodeTxt() + " " + item.getAddress());

                }
            }

            @Override
            public void onFailure(Call<GetUserInfo> call, Throwable t) {
                Log.e("Not Response", t.getLocalizedMessage());
            }
        });
    }

    private void noticeDialog(String title, String message) {
        AlertDialog alertDialog = new AlertDialog.Builder(ChangeaddrActivity.this).create();
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
}
