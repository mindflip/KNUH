package com.example.user.knuhui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;

import com.beardedhen.androidbootstrap.BootstrapEditText;

public class RoadList_Activity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private BottomNaviSet bottomNaviSet;

    private BootstrapEditText etStartPoint, etEndPoint;

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_road_list);

        android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.setTitle("진료실, 검사실 위치 안내");

        bottomNaviSet = new BottomNaviSet(this,this.getClass().getSimpleName());
        bottomNavigationView = bottomNaviSet.getBottomNavigationView();

        initLayout();

        if(getIntent().hasExtra("startPoint")) {
            intent = getIntent();

            String startPoint = intent.getExtras().getString("startPoint", "테스트");
            String endPoint = intent.getExtras().getString("endPoint");

            Log.d("test@@@", startPoint);

            if (!startPoint.equals("")) {
                etStartPoint.setText(startPoint);
                etEndPoint.setText(endPoint);
            }
        }
    }

    private void initLayout() {
        etStartPoint = (BootstrapEditText) findViewById(R.id.etStartPoint);
        etEndPoint = (BootstrapEditText) findViewById(R.id.etEndPoint);
    }
}
