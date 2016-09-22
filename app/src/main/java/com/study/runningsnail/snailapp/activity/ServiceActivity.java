package com.study.runningsnail.snailapp.activity;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.study.runningsnail.snailapp.R;
import com.study.runningsnail.snailapp.service.TestService;
import com.study.runningsnail.snailapp.utils.LogcatUtils;

/**
 * Created by snail on 2016/9/21.
 */

public class ServiceActivity extends AppCompatActivity {
    private LogcatUtils logcatUtils = LogcatUtils.getLogCat(ServiceActivity.class);
    private Intent intent = null;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);


        //创建启动Service的Intent,以及Intent属性
          intent = new Intent(this,TestService.class);
        intent.setAction("com.jay.example.service.TEST_SERVICE1");
        intent.setPackage(this.getPackageName());


        Button startBtn = (Button) findViewById(R.id.startService);
        Button stopBtn = (Button) findViewById(R.id.stopService);
        ServiceActivityOnClickListener serviceActivityOnClickListener = new ServiceActivityOnClickListener();
        startBtn.setOnClickListener(serviceActivityOnClickListener);
        stopBtn.setOnClickListener(serviceActivityOnClickListener);




    }


    public void startService(){
        logcatUtils.d("**********************************************************开始调用启动服务程序**********************************************************");
        startService(intent);
    }
    public void stopService(){
        logcatUtils.d("**********************************************************开始调用关闭服务程序**********************************************************");
        stopService(intent);
    }

    class ServiceActivityOnClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.startService : startService();break;
                case R.id.stopService : stopService();break;
            }
        }
    }
}
