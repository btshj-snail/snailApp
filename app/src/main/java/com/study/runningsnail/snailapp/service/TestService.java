package com.study.runningsnail.snailapp.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.study.runningsnail.snailapp.utils.LogcatUtils;

/**
 * Created by snail on 2016/9/21.
 */

public class TestService extends Service {
    private LogcatUtils logcatUtils = LogcatUtils.getLogCat(TestService.class);
    private final String TAG = "TestService1";
    //必须要实现的方法  
    @Override
    public IBinder onBind(Intent intent) {
        logcatUtils.i(   "onBind方法被调用!");
        return null;
    }

    //Service被创建时调用  
    @Override
    public void onCreate() {
        logcatUtils.i("onCreate方法被调用!");
        super.onCreate();
    }

    //Service被启动时调用  
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        logcatUtils.i(   "onStartCommand方法被调用!");
        return super.onStartCommand(intent, flags, startId);
    }

    //Service被关闭之前回调  
    @Override
    public void onDestroy() {
        logcatUtils.i(   "onDestory方法被调用!");
        super.onDestroy();
    }
}