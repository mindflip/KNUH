package com.example.user.knuhui.treatment;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.user.knuhui.BottomNaviSet;
import com.example.user.knuhui.R;

public class Treatment_Search_Activity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private BottomNaviSet bottomNaviSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treatment_search);

        android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.setTitle("처방 조회");

        bottomNaviSet = new BottomNaviSet(this,this.getClass().getSimpleName());
        bottomNavigationView = bottomNaviSet.getBottomNavigationView();

        Button button = (Button)findViewById(R.id.treatmentsearch);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ListView listView = (ListView) findViewById(R.id.listView1);
                Treatment_ListViewAdapter adapter = new Treatment_ListViewAdapter();

                listView.setAdapter(adapter);

                adapter.addItem("허수연","산부인과","2018/07/20","","","7회","5일","");
            }
        });
    }
}
