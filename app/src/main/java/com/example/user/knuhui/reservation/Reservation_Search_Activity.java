package com.example.user.knuhui.reservation;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.user.knuhui.R;

public class Reservation_Search_Activity extends AppCompatActivity {
    private AlertDialog.Builder alertDialogBuilder;
    private ListView listView;
    private Reservation_ListViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation_search);

        Button button = (Button) findViewById(R.id.button1);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listView = (ListView) findViewById(R.id.listView1);
                adapter = new Reservation_ListViewAdapter();

                listView.setAdapter(adapter);
              //  Log.i("Click","//////////////////////");
                adapter.addItem("산부인과", "이택후", "2018년 7월 30일", "09:00");
                adapter.addItem("정형외과", "김준우", "2018년 8월 2일", "15:30");
            }
        });


//        listView.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View v) {
//                alertDialogBuilder = new AlertDialog.Builder(Reservation_Search_Activity.this);
//                alertDialogBuilder.setTitle("취소");
//                alertDialogBuilder.setMessage("예약을 취소하시겠습니까?");
//
//                // '예' 버튼이 클릭되면
//                alertDialogBuilder.setPositiveButton( "예", new DialogInterface.OnClickListener()
//                {
//                    @Override
//                    public void onClick( DialogInterface dialog, int which )
//                    {
//                        item.remove(selectedPos);
//
//                        // 아래 method를 호출하지 않을 경우, 삭제된 item이 화면에 계속 보여진다.
//                        adapter.notifyDataSetChanged();
//                        dialog.dismiss();  // AlertDialog를 닫는다.
//                    }
//                });
//
//                // '아니오' 버튼이 클릭되면
//                alertDialogBuilder.setNegativeButton("아니오", new DialogInterface.OnClickListener()
//                {
//                    @Override
//                    public void onClick( DialogInterface dialog, int which ) {
//                        dialog.dismiss();  // AlertDialog를 닫는다.
//                    }
//                });
//                alertDialogBuilder.show();
//                return false;
//            }
//        });
//
//    }

    }
}
