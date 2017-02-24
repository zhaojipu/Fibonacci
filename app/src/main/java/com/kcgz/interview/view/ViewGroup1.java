package com.kcgz.interview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * Author:zhao
 * VersionCode:1.0
 * Created by Administrator on 2017/2/22 0022.
 */

public class ViewGroup1 extends LinearLayout {
    public static final String TAG="viewgroup1";

    //这里只重写了两个参数的构造函数
    public ViewGroup1(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        ViewUtils.i(TAG,"onMeasure开始执行");
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        ViewUtils.i(TAG,"onMeasure执行完毕");
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        ViewUtils.i(TAG,"onLayout开始执行");
        super.onLayout(changed, l, t, r, b);
        ViewUtils.i(TAG,"onLayout执行完毕");
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        ViewUtils.i(TAG,"dispatchDraw开始执行");
        super.dispatchDraw(canvas);
        ViewUtils.i(TAG,"dispatchDraw执行完毕");
    }
    @Override
    protected void onDraw(Canvas canvas) {
        ViewUtils.i(TAG,"onDraw开始执行");
        super.onDraw(canvas);
        ViewUtils.i(TAG,"onDraw执行完毕");
    }
}
