package com.kcgz.interview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;

/**
 * Author:zhao
 * VersionCode:1.0
 * Created by Administrator on 2017/2/22 0022.
 */

public class MyView1 extends TextView {
    public static final String TAG="MyView1";
    public MyView1(Context context) {
        super(context);
    }

    public MyView1(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView1(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed,l,t,r,b);
        ViewUtils.i(TAG,"onLayout");
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        ViewUtils.i(TAG,"onMeasure");
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        ViewUtils.i(TAG,"onDraw");
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        boolean dispatch=super.dispatchTouchEvent(ev);
        ViewUtils.viewLog(TAG+"dispatchTouchEvent",ev,dispatch);
        return dispatch;
    }



    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean dispatch=super.onTouchEvent(event);
        ViewUtils.viewLog(TAG+"dispatchTouchEvent",event,dispatch);
        return dispatch;
    }
}
