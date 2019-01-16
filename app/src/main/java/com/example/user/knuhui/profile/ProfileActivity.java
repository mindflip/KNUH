package com.example.user.knuhui.profile;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.user.knuhui.BottomNaviSet;
import com.example.user.knuhui.R;

public class ProfileActivity extends AppCompatActivity {

    static final String[] LIST_MENU = {"동의서 조회", "비밀번호 변경",
            "차량번호 변경", "휴대전화번호 변경", "주소 변경"};
    private ListView lvProfile;

    private BottomNavigationView bottomNavigationView;
    private BottomNaviSet bottomNaviSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.setTitle("사용자 관리");

        bottomNaviSet = new BottomNaviSet(this,this.getClass().getSimpleName());
        bottomNavigationView = bottomNaviSet.getBottomNavigationView();

        Profile_ListViewAdapter adapter = new Profile_ListViewAdapter();

//        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, LIST_MENU);
        lvProfile = (ListView) findViewById(R.id.lvProfile);
        lvProfile.setAdapter(adapter);
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.hc_icon_consent), "동의서 조회", ContextCompat.getDrawable(this, R.drawable.arrow));
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.hc_icon_pw),"회원정보 조회", ContextCompat.getDrawable(this, R.drawable.arrow));
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.hc_icon_carnum),"차량번호 변경", ContextCompat.getDrawable(this, R.drawable.arrow));
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.hc_icon_pnum),"휴대전화번호 변경", ContextCompat.getDrawable(this, R.drawable.arrow));
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.hc_icon_addr),"주소 변경", ContextCompat.getDrawable(this, R.drawable.arrow));

        lvProfile.setOnItemClickListener(onItemClickListener);
    }

    AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent intent;
            switch (position){
                case 0:
                    intent = new Intent(ProfileActivity.this, ConsentActivity.class);
                    startActivity(intent);
                    break;
                case 1:
                    intent = new Intent(ProfileActivity.this, ChangepwActivity.class);
                    startActivity(intent);
                    break;
                case 2:
                    intent = new Intent(ProfileActivity.this, ChangecarnumActivity.class);
                    startActivity(intent);
                    break;
                case 3:
                    intent = new Intent(ProfileActivity.this, ChangephnumActivity.class);
                    startActivity(intent);
                    break;
                case 4:
                    intent = new Intent(ProfileActivity.this, ChangeaddrActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    };
}