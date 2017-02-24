package com.kcgz.interview.view;

import android.util.Log;
import android.view.MotionEvent;

/**
 * Author:zhao
 * VersionCode:1.0
 * Created by Administrator on 2017/2/22 0022.
 */

public class ViewUtils {
    public static void viewLog(String tag, MotionEvent event, boolean flag) {
        Log.i(tag, flag + "");
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.i(tag, "***MotionEvent.ACTION_DOWN");
                break;

            case MotionEvent.ACTION_MOVE:
                Log.i(tag, "***MotionEvent.ACTION_MOVE");
                break;

            case MotionEvent.ACTION_UP:
                Log.i(tag, "***MotionEvent.ACTION_UP");
                break;
        }

    }

    public static void i(String tag,String msg){
        Log.i(tag, msg);
    }
}
