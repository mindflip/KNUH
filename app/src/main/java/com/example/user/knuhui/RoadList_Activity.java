package com.example.user.knuhui;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.beardedhen.androidbootstrap.BootstrapEditText;
import com.example.user.knuhui.treatment.Treatment_Search_Activity;
import com.otaliastudios.zoom.ZoomLayout;

public class RoadList_Activity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private BottomNaviSet bottomNaviSet;

    private BootstrapEditText etStartPoint, etEndPoint;
    private ImageView ivLeft, ivLeftDown, ivUp, ivDownLeft;

    private Intent intent;

    private PathView pathView;

    private Handler handler, arrowhandler;

    private ZoomLayout zoomLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_road_list);

        ActionBar ab = getSupportActionBar();
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
        }, 48000);

        arrowhandler = new Handler();

        arrowDelay(ivLeft, 6000);
        arrowDelay(ivLeftDown,ivLeft, 13000);
        arrowDelay(ivDownLeft,ivLeftDown, 18000);
        arrowDelay(ivLeftDown,ivDownLeft, 23000);
        arrowDelay(ivDownLeft,ivLeftDown, 26000);
        arrowDelay(ivLeftDown,ivDownLeft, 33000);
        arrowDelayGone(ivLeftDown, 38000);
        // 1. 7 / 10 / 13 / 15 / 18
        // 2.
    }

    private void arrowDelay(final ImageView arrow, int seconds) {
        arrowhandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                arrow.setVisibility(View.VISIBLE);
            }
        }, seconds);
    }

    private void arrowDelayGone(final ImageView arrow, int seconds) {
        arrowhandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                arrow.setVisibility(View.GONE);
            }
        }, seconds);
    }

    private void arrowDelay(final ImageView arrow1, final ImageView arrow2, int seconds) {
        arrowhandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                arrow1.setVisibility(View.VISIBLE);
                arrow2.setVisibility(View.GONE);
            }
        }, seconds);
    }


    private void initLayout() {

        etStartPoint = (BootstrapEditText) findViewById(R.id.etStartPoint);
        etStartPoint.setFocusableInTouchMode(false);
        etEndPoint = (BootstrapEditText) findViewById(R.id.etEndPoint);
        etEndPoint.setFocusableInTouchMode(false);
        zoomLayout = (ZoomLayout) findViewById(R.id.zoomLayout);

        ivLeft = (ImageView) findViewById(R.id.ivLeft);
        ivDownLeft = (ImageView) findViewById(R.id.ivDownLeft);
        ivUp = (ImageView) findViewById(R.id.ivUp);
        ivLeftDown = (ImageView) findViewById(R.id.ivLeftDown);

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
//                Toast.makeText(getApplicationContext(), "검사항목 = "+testList[item] + " / " + item, Toast.LENGTH_SHORT).show();
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

                        arrowDelay(ivUp, 1500);
                        arrowDelayGone(ivUp,6000);
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                completeDialog();
                            }
                        }, 10000);
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
