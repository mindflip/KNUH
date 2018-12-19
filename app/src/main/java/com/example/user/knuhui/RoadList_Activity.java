package com.example.user.knuhui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.beardedhen.androidbootstrap.BootstrapEditText;
import com.example.user.knuhui.treatment.Treatment_Search_Activity;
import com.otaliastudios.zoom.ZoomLayout;

public class RoadList_Activity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private BottomNaviSet bottomNaviSet;

    private BootstrapEditText etStartPoint, etEndPoint;

    private Intent intent;

    private PathView pathView;

    private Handler handler;

    private ZoomLayout zoomLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_road_list);

        android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.setTitle("진료실, 검사실 위치 안내");

        bottomNaviSet = new BottomNaviSet(this,this.getClass().getSimpleName());
        bottomNavigationView = bottomNaviSet.getBottomNavigationView();

        initLayout();

        if(getIntent().hasExtra("startPoint")) {
            intent = getIntent();

            String startPoint = intent.getExtras().getString("startPoint", "테스트");
            String endPoint = intent.getExtras().getString("endPoint");

            Log.d("test@@@", startPoint);

            if (!startPoint.equals("")) {
                etStartPoint.setText(startPoint);
                etEndPoint.setText(endPoint);
            }
        }

        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                testReservDialog();
            }
        }, 4000);
    }

    private void initLayout() {

        etStartPoint = (BootstrapEditText) findViewById(R.id.etStartPoint);
        etStartPoint.setFocusableInTouchMode(false);
        etEndPoint = (BootstrapEditText) findViewById(R.id.etEndPoint);
        etEndPoint.setFocusableInTouchMode(false);
        zoomLayout = (ZoomLayout) findViewById(R.id.zoomLayout);

        pathView = (PathView) findViewById(R.id.pathView);
        pathView.goToBlood();

        pathView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                Log.d("ITPANGPANG","(x,y)=>" + "(" + (int)event.getX() + "," + (int)event.getY() + ")");

                return false;
            }
        });

    }

    private void testReservDialog() {

        final CharSequence[] testList = {"CT촬영실로 가세요."};
        AlertDialog.Builder alt_bld = new AlertDialog.Builder(this);
        alt_bld.setTitle("1건의 검사예약이 있습니다");
        alt_bld.setSingleChoiceItems(testList, -1, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                Toast.makeText(getApplicationContext(), "검사항목 = "+testList[item] + " / " + item, Toast.LENGTH_SHORT).show();
                // dialog.cancel();
            }
        });
        AlertDialog alert = alt_bld.create();
        alert.setButton(AlertDialog.BUTTON_POSITIVE, "확인",
                new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        PathView.scenarioCount++;
                        pathView.goToCt();
                        pathView.trackingCt();
                        pathView.invalidate();
                        etStartPoint.setText("채혈실");
                        etEndPoint.setText("CT촬영실");

                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                completeDialog();
                            }
                        }, 3000);
                        dialog.dismiss();
                    }
                });
        alert.show();
    }

    private void completeDialog() {
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("검사 완료");
        alertDialog.setMessage("모든 검사가 완료되었습니다.");
        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "닫기",
                new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
        alertDialog.show();
    }
}
