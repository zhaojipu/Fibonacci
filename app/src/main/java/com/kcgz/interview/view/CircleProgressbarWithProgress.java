package com.kcgz.interview.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.ProgressBar;

import com.kcgz.interview.R;
import com.kcgz.interview.utils.SizeUtils;

/**
 * Author:zhao
 * VersionCode:1.0
 * Created by Administrator on 2017/3/24 0024.
 */

public class CircleProgressbarWithProgress extends ProgressBar {

    //默认属性，即用户直接拿来使用的属性
    private static final int PROGRESS_TEXT_COLOR = 0xF58407;
    private static final int PROGRESS_TEXT_SIZE = 20;//Sp
    private static final int PROGRESS_TEXT_OFFSET = 10;//dp
    private static final int PROGRESS_REACH_COLOR = 0xFF0000;
    private static final int PROGRESS_REACH_HEIGHT = 2;//dp

    private static int mTextColor;
    private static int mTextSize;
    private static int mTextOffset;
    private static int mReachColor;
    private static int mReachHeight;

    private Paint mPaint = new Paint();

    public CircleProgressbarWithProgress(Context context) {
        this(context, null);
    }

    public CircleProgressbarWithProgress(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircleProgressbarWithProgress(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        obtainStyleAttrs(context, attrs);
    }


    private void obtainStyleAttrs(Context context, AttributeSet attrs) {
        mReachHeight = SizeUtils.dp2px(context, PROGRESS_REACH_HEIGHT);
        mTextSize = SizeUtils.sp2px(context, PROGRESS_TEXT_SIZE);
        mTextOffset = SizeUtils.dp2px(context, PROGRESS_TEXT_OFFSET);
        TypedArray ta = context.obtainStyledAttributes(attrs,
                R.styleable.CircleProgressbarWithProgress);
        mReachColor = ta.getColor(R.styleable.CircleProgressbarWithProgress_progress_reach_color, mReachColor);
        mReachHeight = ta.getColor(R.styleable.CircleProgressbarWithProgress_progress_reach_height, mReachHeight);
        mTextColor = ta.getColor(R.styleable.CircleProgressbarWithProgress_progress_text_color, mTextColor);
        mTextOffset = ta.getColor(R.styleable.CircleProgressbarWithProgress_progress_text_offset, mTextOffset);
        mTextSize = ta.getColor(R.styleable.CircleProgressbarWithProgress_progress_text_size, mTextSize);
        ta.recycle();
    }

    @Override
    protected synchronized void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = measureWidth(widthMeasureSpec);
        int height = measureHeight(heightMeasureSpec);

        setMeasuredDimension(width, height);
    }

    /**
     * 如果用户指定值，则使用改值，否则给一个默认的100
     */
    private int measureHeight(int heightMeasureSpec) {
        int result = 0;
        int mode = MeasureSpec.getMode(heightMeasureSpec);
        if (mode == MeasureSpec.EXACTLY) {
            result = MeasureSpec.getSize(heightMeasureSpec);
        } else {
            result = 100;
        }
        return result;
    }

    /**
     * 如果用户指定值，则使用改值，否则给一个默认的100
     */
    private int measureWidth(int widthMeasureSpec) {
        int result = 0;
        int mode = MeasureSpec.getMode(widthMeasureSpec);
        if (mode == MeasureSpec.EXACTLY)
            result = MeasureSpec.getSize(widthMeasureSpec);
        else
            result = 100;
        return result;
    }

    @Override
    protected synchronized void onDraw(Canvas canvas) {
        canvas.save();
        String text=getProgress()+"%";
        int textWidth= (int) mPaint.measureText(text);
        mPaint.setStrokeWidth(mReachHeight);
        mPaint.setColor(mReachColor);
        int cx=getTop()+textWidth/2;
        int cy=getLeft()+textWidth/2;
        canvas.drawCircle(cx,cy,(textWidth+mTextOffset+getPaddingRight()+getPaddingLeft())/2,mPaint);
        mPaint.setColor(mTextColor);
        canvas.drawText(text,cx,cy,mPaint);
        canvas.restore();
    }
}
