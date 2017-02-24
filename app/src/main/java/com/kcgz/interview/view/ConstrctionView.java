package com.kcgz.interview.view;

import android.content.Context;
import android.widget.TextView;

/**
 * Author:zhao
 * VersionCode:1.0
 * Created by Administrator on 2017/2/24 0024.
 */

public class ConstrctionView extends TextView {
    //只重写这一个构造器，系统将会抛异常
    public ConstrctionView(Context context) {
        super(context);
    }

}
