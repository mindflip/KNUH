package com.example.user.knuhui;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ProfileActivity extends AppCompatActivity {

    static final String[] LIST_MENU = {"동의서 조회", "비밀번호 변경",
            "차량번호 변경", "휴대전화번호 변경", "주소 변경"};
    private ListView lvProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, LIST_MENU);
        lvProfile = (ListView) findViewById(R.id.lvProfile);
        lvProfile.setAdapter(adapter);

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