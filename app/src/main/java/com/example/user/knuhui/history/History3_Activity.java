package com.example.user.knuhui.history;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.user.knuhui.BottomNaviSet;
import com.example.user.knuhui.R;

public class History3_Activity extends AppCompatActivity {

    private Button button;

    private BottomNavigationView bottomNavigationView;
    private BottomNaviSet bottomNaviSet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history3);

        android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.setTitle("진료비 영수증 확인");

        bottomNaviSet = new BottomNaviSet(this,this.getClass().getSimpleName());
        bottomNavigationView = bottomNaviSet.getBottomNavigationView();

        button = (Button)findViewById(R.id.button1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView imageView = (ImageView)findViewById(R.id.imageview1);

                imageView.setImageDrawable(getResources().getDrawable(R.drawable.location));

            }
        });
    }
}
