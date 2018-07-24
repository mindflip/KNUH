package com.example.user.knuhui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class History1_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history1);

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
