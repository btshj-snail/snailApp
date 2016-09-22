package com.study.runningsnail.snailapp.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.study.runningsnail.snailapp.R;
import com.study.runningsnail.snailapp.utils.LogcatUtils;

/**
 * Created by snail on 2016/9/22.
 */

public class CustomViewDemoActivity extends AppCompatActivity {

    private LogcatUtils logcatUtils = LogcatUtils.getLogCat(CustomViewDemoActivity.class);
    private Context mContext;

    @Override
    public void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        mContext = CustomViewDemoActivity.this;
        setContentView(R.layout.activity_custom_view);
    }
}
