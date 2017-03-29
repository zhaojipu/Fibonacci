package com.kcgz.interview;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.kcgz.interview.silding.HorizontalScrollView;
import com.kcgz.interview.utils.MyUtils;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SlidingActicity extends AppCompatActivity {

    @BindView(R.id.myHorizontal)
    HorizontalScrollView myHorizontal;
    /*@BindView(R.id.lvo1)
    ListView lvo1;
    @BindView(R.id.lvo2)
    ListView lvo2;
    @BindView(R.id.lvo3)
    ListView lvo3;
    String[] datas=new String[]{"q","q","q","q","q","q","q","q","q","q","q","q"};*/
    private static final String TAG = "SlidingActicity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sliding);
        ButterKnife.bind(this);
        Log.d(TAG,"onCreate");
        initView();
    }

    private void initView() {
//        lvo1.setAdapter(new ArrayAdapter<String>(this,R.layout.content_list_item,R.id.name,datas));
//        lvo2.setAdapter(new ArrayAdapter<String>(this,R.layout.content_list_item,R.id.name,datas));
//        lvo3.setAdapter(new ArrayAdapter<String>(this,R.layout.content_list_item,R.id.name,datas));

        LayoutInflater inflater = getLayoutInflater();
        final int screenWidth = MyUtils.getScreenMetrics(this).widthPixels;
        final int screenHeight = MyUtils.getScreenMetrics(this).heightPixels;
        for (int i = 0; i < 3; i++) {
            ViewGroup layout = (ViewGroup) inflater.inflate(
                    R.layout.content_layout, myHorizontal, false);
            layout.getLayoutParams().width = screenWidth;
            TextView textView = (TextView) layout.findViewById(R.id.title);
            textView.setText("page " + (i + 1));
            layout.setBackgroundColor(Color.rgb(255 / (i + 1), 255 / (i + 1), 0));
            createList(layout);
            myHorizontal.addView(layout);
        }
    }
    private void createList(ViewGroup layout) {
        ListView listView = (ListView) layout.findViewById(R.id.list);
        ArrayList<String> datas = new ArrayList<String>();
        for (int i = 0; i < 50; i++) {
            datas.add("name " + i);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.content_list_item, R.id.name, datas);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(SlidingActicity.this, "click item",
                        Toast.LENGTH_SHORT).show();

            }
        });
    }
}
