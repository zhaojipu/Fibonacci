package com.kcgz.interview;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;

import com.kcgz.interview.view.HorizontalProgressbarWithProgress;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyProgressbarActivity extends AppCompatActivity {

    @BindView(R.id.progress1)
    HorizontalProgressbarWithProgress progress1;
    @BindView(R.id.progress2)
    HorizontalProgressbarWithProgress progress2;
    @BindView(R.id.progress3)
    HorizontalProgressbarWithProgress progress3;


    Handler handler=new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            progress1.setProgress(progress);
            progress2.setProgress(progress);
            progress3.setProgress(progress);
            progress++;
            if (progress==100){
                progress=0;
            }
            handler.postDelayed(null,100);
        }
    };
    int progress=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_progressbar);
        ButterKnife.bind(this);


        handler.sendMessageDelayed(handler.obtainMessage(),2000);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(null);
    }
}
