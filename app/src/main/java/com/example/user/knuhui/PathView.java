package com.example.user.knuhui;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class PathView extends View {

    public static int scenarioCount;

    private Path initPath, goPath, ctPath, trackCtPath;
    private Paint initPaint, goPaint, ctPaint, trackCtPaint, dotPaint;
    float length;
    private Bitmap pointImage, resizedPointImage, userImage, resizedUserImage;

    public PathView(Context context)
    {
        super(context);
        Log.i("callConsturctor","@@@@@@@@@@@@@@@@@@@@@@");
    }

    public PathView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    public PathView(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
    }

    public void trackingBlood()
    {
        scenarioCount = 0;
        Resources res = getContext().getResources();
        pointImage = BitmapFactory.decodeResource(res, R.drawable.point);
        userImage = BitmapFactory.decodeResource(res, R.drawable.user);
        resizedPointImage = Bitmap.createScaledBitmap(pointImage, 100,100,true);
        resizedUserImage = Bitmap.createScaledBitmap(userImage, 100,100,true);

        initPaint = new Paint();
        initPaint.setColor(Color.GREEN);
        initPaint.setStrokeWidth(7);
        initPaint.setStyle(Paint.Style.STROKE);
        initPaint.setStrokeJoin(Paint.Join.ROUND);    // set the join to round you want
        initPaint.setStrokeCap(Paint.Cap.ROUND);      // set the paint cap to round too
        initPaint.setPathEffect(new CornerPathEffect(10) );   // set the path effect when they join.
        initPaint.setAntiAlias(true);                         // set anti alias so it smooths

        initPath = new Path();
        initPath.moveTo(2100,700);
        initPath.lineTo(1820,700);
        initPath.lineTo(1820,900);
        initPath.lineTo(1650,900);
        initPath.lineTo(1650,1060);
        initPath.lineTo(1460,1060);
        initPath.lineTo(1460,1200);

        // Measure the path
        PathMeasure measure = new PathMeasure(initPath, false);
        length = measure.getLength();
        Log.d("checkLength1", String.valueOf(length) + "@@@@@@@@@@@");

        float[] intervals = new float[]{length, length};

        ObjectAnimator animator = ObjectAnimator.ofFloat(PathView.this, "phase", 1.0f, 0.0f);
        animator.setDuration(2000);
        animator.start();

    }

    public void goToBlood()
    {
        goPaint = new Paint();
        goPaint.setColor(Color.GRAY);
        goPaint.setStrokeWidth(12);
        goPaint.setStyle(Paint.Style.STROKE);
        goPaint.setStrokeJoin(Paint.Join.ROUND);    // set the join to round you want
        goPaint.setStrokeCap(Paint.Cap.ROUND);      // set the paint cap to round too
        goPaint.setPathEffect(new CornerPathEffect(10) );   // set the path effect when they join.
        goPaint.setAntiAlias(true);                         // set anti alias so it smooths

        goPath = new Path();
        goPath.moveTo(2100,700);
        goPath.lineTo(1820,700);
        goPath.lineTo(1820,900);
        goPath.lineTo(1650,900);
        goPath.lineTo(1650,1060);
        goPath.lineTo(1460,1060);
        goPath.lineTo(1460,1200);

        trackingBlood();
    }

    public void goToCt() {

        ctPaint = new Paint();
        ctPaint.setColor(Color.GRAY);
        ctPaint.setStrokeWidth(12);
        ctPaint.setStyle(Paint.Style.STROKE);
        ctPaint.setStrokeJoin(Paint.Join.ROUND);    // set the join to round you want
        ctPaint.setStrokeCap(Paint.Cap.ROUND);      // set the paint cap to round too
        ctPaint.setPathEffect(new CornerPathEffect(10) );   // set the path effect when they join.
        ctPaint.setAntiAlias(true);                         // set anti alias so it smooths

        ctPath = new Path();
        ctPath.moveTo(1460,1200);
        ctPath.lineTo(1460,1060);
        ctPath.lineTo(1440,1060);

    }

    public void trackingCt() {

        trackCtPaint = new Paint();
        trackCtPaint.setColor(Color.GREEN);
        trackCtPaint.setStrokeWidth(7);
        trackCtPaint.setStyle(Paint.Style.STROKE);
        trackCtPaint.setStrokeJoin(Paint.Join.ROUND);    // set the join to round you want
        trackCtPaint.setStrokeCap(Paint.Cap.ROUND);      // set the paint cap to round too
        trackCtPaint.setPathEffect(new CornerPathEffect(10) );   // set the path effect when they join.
        trackCtPaint.setAntiAlias(true);

        trackCtPath = new Path();
        trackCtPath.moveTo(1460,1200);
        trackCtPath.lineTo(1460,1060);
        trackCtPath.lineTo(1440,1060);

        // Measure the path
        PathMeasure measure = new PathMeasure(trackCtPath, false);
        length = measure.getLength();
        Log.d("checkLength2", String.valueOf(length) + "@@@@@@@@@@@");

        float[] intervals = new float[]{length, length};

        ObjectAnimator ctAnimator = ObjectAnimator.ofFloat(PathView.this, "phase", 1.0f, 0.0f);
        ctAnimator.setDuration(3000);
        ctAnimator.start();

    }

    //is called by animtor object
    public void setPhase(float phase)
    {
        Log.d("pathview","setPhase called with:" + String.valueOf(phase));
        if (scenarioCount==0) {
            initPaint.setPathEffect(createPathEffect(length, phase, 0.0f));
        } else {
            trackCtPaint.setPathEffect(createPathEffect(length, phase, 0.0f));
        }
//        goPaint.setPathEffect(createPathEffect(length, phase, 0.0f));
        invalidate();//will calll onDraw
    }

    private static PathEffect createPathEffect(float pathLength, float phase, float offset)
    {
        return new DashPathEffect(new float[] { pathLength, pathLength },
                Math.max(phase * pathLength, offset));
    }

    @Override
    public void onDraw(final Canvas c)
    {
        super.onDraw(c);

        if(scenarioCount ==0) {
            c.drawPath(goPath, goPaint);

            c.drawPath(initPath, initPaint);

            c.drawBitmap(resizedUserImage, 2050,600, null);
            c.drawBitmap(resizedPointImage, 1415,1170, null);
        } else {

            c.drawPath(ctPath, ctPaint);
            c.drawPath(trackCtPath, trackCtPaint);
            c.drawBitmap(resizedUserImage, 1415,1180, null);
            c.drawBitmap(resizedPointImage, 1340,960, null);

        }

    }
}
