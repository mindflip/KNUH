package com.example.user.knuhui.profile;

import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.user.knuhui.BottomNaviSet;
import com.example.user.knuhui.R;

public class ChangephnumActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private BottomNaviSet bottomNaviSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changephnum);

        android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.setTitle("휴대전화번호 변경");

        bottomNaviSet = new BottomNaviSet(this,this.getClass().getSimpleName());
        bottomNavigationView = bottomNaviSet.getBottomNavigationView();
    }
}
