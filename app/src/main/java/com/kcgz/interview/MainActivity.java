package com.kcgz.interview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.button_1)
    Button button1;
    @BindView(R.id.button_2)
    Button button2;
    @BindView(R.id.button_3)
    Button button3;
    @BindView(R.id.button_4)
    Button button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.button_1, R.id.button_2, R.id.button_3, R.id.button_4})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_1:
                startActivity(new Intent(this,ConstructionActivity.class));
                break;
            case R.id.button_2:
                startActivity(new Intent(this,FibonacciActivity.class));
                break;
            case R.id.button_3:
                startActivity(new Intent(this,MyProgressbarActivity.class));
                break;
            case R.id.button_4:
                break;
        }
    }
}
