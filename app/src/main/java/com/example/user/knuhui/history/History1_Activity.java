package com.example.user.knuhui.history;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.user.knuhui.BottomNaviSet;
import com.example.user.knuhui.R;

public class History1_Activity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private BottomNaviSet bottomNaviSet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history1);

        bottomNaviSet = new BottomNaviSet(this,this.getClass().getSimpleName());
        bottomNavigationView = bottomNaviSet.getBottomNavigationView();

        android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.setTitle("수진이력정보조회(외래");

        Button button = (Button)findViewById(R.id.button1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ListView listView = (ListView)findViewById(R.id.listView1);
                History1_ListViewAdapter adapter = new History1_ListViewAdapter();

                listView.setAdapter(adapter);

                adapter.addItem("산부인과","이택후","2018/07/20");
                adapter.addItem("정형외과","김은수","2018/07/13");
            }
        });
    }
}
