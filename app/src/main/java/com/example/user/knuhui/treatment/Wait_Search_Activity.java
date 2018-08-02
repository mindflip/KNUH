package com.example.user.knuhui.treatment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.user.knuhui.R;

public class Wait_Search_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.waittime_search);

        ListView listView = (ListView) findViewById(R.id.listView1);
        Wait_ListViewAdapter adapter = new Wait_ListViewAdapter();

        listView.setAdapter(adapter);

        adapter.addItem("방사선", "6", "30분");
        adapter.addItem("이비인후과", "5", "20분");
    }

}
