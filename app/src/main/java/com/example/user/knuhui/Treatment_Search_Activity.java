package com.example.user.knuhui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class Treatment_Search_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treatment_search);

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
