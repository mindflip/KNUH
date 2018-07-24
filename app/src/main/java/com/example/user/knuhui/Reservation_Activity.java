package com.example.user.knuhui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Reservation_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);

        Button button = (Button)findViewById(R.id.button1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"예약되었습니다.",Toast.LENGTH_LONG).show();
            }
        });
//        final TextView textView = (TextView)findViewById(R.id.textView1);
//        Spinner spinner = (Spinner)findViewById(R.id.spinner1);
//        spinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                textView.setText("position : "+parent.getItemAtPosition(position));
//            }
//
////            public void onNotingSelected(AdapterView<?> parent){
////
////            }
//        });
    }
}
