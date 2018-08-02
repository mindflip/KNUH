package com.example.user.knuhui.history;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.user.knuhui.R;

public class History4_Activity extends AppCompatActivity {
    private AlertDialog.Builder alertDialogBuilder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history4);

        Button button = (Button)findViewById(R.id.button1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialogBuilder = new AlertDialog.Builder(History4_Activity.this);
                alertDialogBuilder.setTitle("Warning");
                alertDialogBuilder.setMessage("영수증 내역이 존재하지 않습니다.");

                alertDialogBuilder.setPositiveButton( "OK", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which )
                    {
                        dialog.dismiss();  // AlertDialog를 닫는다.
                    }
                });

                alertDialogBuilder.show();

            }
        });
    }
}
