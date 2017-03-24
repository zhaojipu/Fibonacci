package com.kcgz.interview.utils;

import android.content.Context;
import android.util.TypedValue;

/**
 * Author:zhao
 * VersionCode:1.0
 * Created by Administrator on 2017/3/24 0024.
 */

public class SizeUtils {
    /**
     * 将dp单位转化为px
     * @param dpVal 传入的dp值
     * @return 返回的px值
     */
    public static int dp2px(Context context,int dpVal){
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,dpVal,context.getResources().getDisplayMetrics());
    }
    public static  int sp2px(Context context,int spVal){
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,spVal,context.getResources().getDisplayMetrics());
    }
}
