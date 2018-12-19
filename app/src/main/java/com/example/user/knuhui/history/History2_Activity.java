package com.example.user.knuhui.history;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.user.knuhui.BottomNaviSet;
import com.example.user.knuhui.R;

public class History2_Activity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private BottomNaviSet bottomNaviSet;


    AlertDialog.Builder alertDialogBuilder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history2);

        android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.setTitle("수진이력정보조회(입원)");

        bottomNaviSet = new BottomNaviSet(this,this.getClass().getSimpleName());
        bottomNavigationView = bottomNaviSet.getBottomNavigationView();

        Button button = (Button)findViewById(R.id.button1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialogBuilder = new AlertDialog.Builder(History2_Activity.this);
                alertDialogBuilder.setTitle("Warning");
                alertDialogBuilder.setMessage("진료이력이 존재하지 않습니다.");

                alertDialogBuilder.setPositiveButton( "OK", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick( DialogInterface dialog, int which )
                    {
                        dialog.dismiss();  // AlertDialog를 닫는다.
                    }
                });

//                alertDialogBuilder.setNegativeButton("아니오", new DialogInterface.OnClickListener()
//                {
//                    @Override
//                    public void onClick( DialogInterface dialog, int which ) {
//                        dialog.dismiss();  // AlertDialog를 닫는다.
//                    }
//                });
                alertDialogBuilder.show();

            }
        });
    }
}
