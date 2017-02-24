package com.kcgz.interview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * Author:zhao
 * VersionCode:1.0
 * Created by Administrator on 2017/2/22 0022.
 */

public class ViewGroup2 extends LinearLayout {
    public static final String TAG="viewgroup2";
    public ViewGroup2(Context context) {
        super(context);
    }

    public ViewGroup2(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ViewGroup2(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }



    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        boolean dispatch=super.dispatchTouchEvent(ev);
        ViewUtils.viewLog(TAG+"dispatchTouchEvent",ev,dispatch);
        return dispatch;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        boolean dispatch=super.onInterceptTouchEvent(ev);
        ViewUtils.viewLog(TAG+"onInterceptTouchEvent",ev,dispatch);
        return dispatch;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean dispatch=super.onTouchEvent(event);
        ViewUtils.viewLog(TAG+"dispatchTouchEvent",event,dispatch);
        return dispatch;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        ViewUtils.i(TAG,"onMeasure先");
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        ViewUtils.i(TAG,"onMeasure后");
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        ViewUtils.i(TAG,"onLayout先");
        super.onLayout(changed, l, t, r, b);
        ViewUtils.i(TAG,"onLayout后");
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        ViewUtils.i(TAG,"dispatchDraw先");
        super.dispatchDraw(canvas);
        ViewUtils.i(TAG,"dispatchDraw后");
    }
    @Override
    protected void onDraw(Canvas canvas) {
        ViewUtils.i(TAG,"onDraw先");
        super.onDraw(canvas);
        ViewUtils.i(TAG,"onDraw后");
    }
}
