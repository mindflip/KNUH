package com.example.user.knuhui;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;

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
        PopupMenu pum = new PopupMenu(MainActivity.this, findViewById(imageView));
        pum.inflate(menu);
        pum.show();
    }

}