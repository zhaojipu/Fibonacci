package com.kcgz.interview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class FibonacciActivity extends AppCompatActivity {

    //展示菲薄函数的列表
    private ListView listView;
    private TextView textView;
    LinearLayout vg001;

    public static final String TAG="MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fibonacci);
//vg001= (LinearLayout) findViewById(R.id.vg001);
//        textView=new TextView(this);
//        textView.setText("测试的Textview");
//
//        vg001.addView(textView);

        Log.i("kdsj","");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("kdsj","");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("kdsj","");
    }

    
}
