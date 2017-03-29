package com.kcgz.interview;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;

import java.io.File;

public class OkGoActivity extends AppCompatActivity {
    File file;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ok_go);
        boolean storageEmulated = Environment.isExternalStorageEmulated();
        if (storageEmulated){
            file= Environment.getExternalStorageDirectory();

        }else
            file=Environment.getRootDirectory();


    }

}
