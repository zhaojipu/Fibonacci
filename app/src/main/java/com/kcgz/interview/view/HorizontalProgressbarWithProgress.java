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
 * Created by Administrator on 2017/3/23 0023.
 */

public class HorizontalProgressbarWithProgress extends ProgressBar {
    //设置默认的属性
    private static final int DEFAULT_TEXT_SIZE = 20;//SP
    private static final int DEFAULT_TEXT_COLOR = 0xFFC00D1;//
    private static final int DEFAULT_COLOR_UNREACH = 0xFFD3D6DA;//SP
    private static final int DEFAULT_HEIGHT_UNREACH = 2;//DP
    private static final int DEFAULT_COLOR_REACH = DEFAULT_TEXT_COLOR;
    private static final int DEFAULT_HEIGHT_REACH = 2;//DP
    private static final int DEFAULT_TEXT_OFFSET = 10;//DP

    //转化默认属性
    private int mTextSize;
    private int mTextOffset;
    private int mTextColor=DEFAULT_TEXT_COLOR;
    private int mUnReachColor=DEFAULT_COLOR_UNREACH;
    private int mUnReachHeight;
    private int mReachColor=DEFAULT_COLOR_REACH;
    private int mReachHeight;

    private Context mContext;
    private Paint mPaint=new Paint();
    private int mRealWidth;
    public HorizontalProgressbarWithProgress(Context context) {
        this(context, null);
    }

    public HorizontalProgressbarWithProgress(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public HorizontalProgressbarWithProgress(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext=context;
        mTextOffset = SizeUtils.dp2px(mContext,DEFAULT_TEXT_OFFSET);
        mUnReachHeight = SizeUtils.dp2px(mContext,DEFAULT_HEIGHT_UNREACH);
        mReachHeight = SizeUtils.dp2px(mContext,DEFAULT_HEIGHT_REACH);
        mTextSize = SizeUtils.sp2px(mContext,DEFAULT_TEXT_SIZE);
        obtainStyleAttrs(attrs);
    }

    /**
     * 获取自定义属性
     * @param attrs
     */
    private void obtainStyleAttrs(AttributeSet attrs) {
        TypedArray ta=getContext().obtainStyledAttributes(attrs,
                R.styleable.HorizontalProgressbarWithProgress);
        mTextColor=ta.getColor(R.styleable.HorizontalProgressbarWithProgress_progress_text_color,mTextColor);
        mTextOffset= (int) ta.getDimension(R.styleable.HorizontalProgressbarWithProgress_progress_text_offset,mTextOffset);
        mTextSize= (int) ta.getDimension(R.styleable.HorizontalProgressbarWithProgress_progress_text_size,mTextSize);
        mUnReachColor=ta.getColor(R.styleable.HorizontalProgressbarWithProgress_progress_unreach_color,mUnReachColor);
        mUnReachHeight= (int) ta.getDimension(R.styleable.HorizontalProgressbarWithProgress_progress_unreach_height,mUnReachHeight);
        mReachColor=ta.getColor(R.styleable.HorizontalProgressbarWithProgress_progress_reach_color,mReachColor);
        mReachHeight= (int) ta.getDimension(R.styleable.HorizontalProgressbarWithProgress_progress_reach_height,mReachHeight);

        mPaint.setTextSize(mTextSize);
        ta.recycle();
    }

    @Override
    protected synchronized void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        int widthMode=MeasureSpec.getMode(widthMeasureSpec);
        //用户必须指定进度条的宽度，所以不用根据mode来判断，直接通过下面的代码获取就行
        int widthVal=MeasureSpec.getSize(widthMeasureSpec);

        int height=measureHeight(heightMeasureSpec);

        //测量完必须调用，即给控件设置宽和高
        setMeasuredDimension(widthVal,height);

        mRealWidth=getMeasuredWidth()-getPaddingLeft()-getPaddingRight();
    }

    private int measureHeight(int heightMeasureSpec) {
        int result=0;
        int mode=MeasureSpec.getMode(heightMeasureSpec);
        int size=MeasureSpec.getSize(heightMeasureSpec);
        //如果测量模式为精确的，即用户给定了具体的值或者是matchParent
        if (mode==MeasureSpec.EXACTLY){
            result=size;
        }else {
            int textHeight= (int) (mPaint.descent()-mPaint.ascent());

            result=getPaddingBottom()
                    +getPaddingTop()
                    //取进度条跟文字高度的最大值
                    +Math.max(Math.max(mReachHeight,mUnReachHeight),Math.abs(textHeight));
            if (mode==MeasureSpec.AT_MOST){
                result=Math.max(size,result);
            }
        }
        return result;
    }

    @Override
    protected synchronized void onDraw(Canvas canvas) {
        canvas.save();
        String text=getProgress()+"%";
        int textWidth= (int) mPaint.measureText(text);
        //初始坐标的位置
        canvas.translate(getPaddingLeft(),getHeight()/2);
        //绘制已完成的部位及Reachbar
        float radio=getProgress()*1.0f/getMax();//完成进度
        float progressX=radio*mRealWidth;//已完成的进度条的x坐标
        boolean noNeedUnreach=false;//不需要绘制未到达的进度条，原因是当已完成的进度条的宽度+Textview的宽度大于整个进度条的宽度时，未完成的进度条会被Textview遮挡
        if (progressX+textWidth>mRealWidth){
            noNeedUnreach=true;
            progressX=mRealWidth-textWidth;
        }
        float endX=progressX-mTextOffset/2;
        if (endX>0){
            mPaint.setColor(mReachColor);//设置画笔的颜色
            mPaint.setStrokeWidth(mReachHeight);//设置画笔的宽度即所绘线条的宽度
            canvas.drawLine(0,0,endX,0,mPaint);
        }

        //绘制文本
        mPaint.setColor(mTextColor);
        int y= (int) (-(mPaint.descent()+mPaint.ascent())/2);
        canvas.drawText(text,progressX,y,mPaint);

        //绘制未完成的进度条
        if (!noNeedUnreach){
            float start=progressX+mTextOffset/2+textWidth;

            mPaint.setColor(mUnReachColor);
            mPaint.setStrokeWidth(mUnReachHeight);
            canvas.drawLine(start,0,mRealWidth,0,mPaint);
        }
        canvas.restore();
    }


}
