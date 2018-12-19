package com.example.user.knuhui.profile;

import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.user.knuhui.BottomNaviSet;
import com.example.user.knuhui.R;

public class ChangecarnumActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private BottomNaviSet bottomNaviSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changecarnum);

        android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.setTitle("차량번호 변경");

        bottomNaviSet = new BottomNaviSet(this,this.getClass().getSimpleName());
        bottomNavigationView = bottomNaviSet.getBottomNavigationView();
    }
}
