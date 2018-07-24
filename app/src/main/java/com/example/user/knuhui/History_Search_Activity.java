package com.example.user.knuhui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class History_Search_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history__search);

        ListView listView = (ListView) findViewById(R.id.listView1);
        History_ListViewAdapter adapter = new History_ListViewAdapter();

        listView.setAdapter(adapter);

        adapter.addItem("수진이력정보조회(외래)", ContextCompat.getDrawable(this, R.drawable.arrow));
        adapter.addItem("수진이력정보조회(입원)",ContextCompat.getDrawable(this, R.drawable.arrow));
        adapter.addItem("진료비 영수증 확인",ContextCompat.getDrawable(this, R.drawable.arrow));
        adapter.addItem("진료비 영수증 목록",ContextCompat.getDrawable(this, R.drawable.arrow));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                // get item
                HistoryItem item = (HistoryItem) parent.getItemAtPosition(position) ;

                String menu = item.getMenu();

                //각 리스트뷰 항목 클릭시 해당 메뉴로 이동함
                if(position==0){
                    Intent intent = new Intent(History_Search_Activity.this,History1_Activity.class);
                    startActivity(intent);
                }

                else if(position==1){
                    Intent intent = new Intent(History_Search_Activity.this,History2_Activity.class);
                    startActivity(intent);
                }

                else if(position==2){
                    Intent intent = new Intent(History_Search_Activity.this,History3_Activity.class);
                    startActivity(intent);
                }

                else if(position==3){
                    Intent intent = new Intent(History_Search_Activity.this,History4_Activity.class);
                    startActivity(intent);
                }

            }
        }) ;



    }
}
