package com.study.runningsnail.snailapp.activity;

import android.content.Intent;
import android.graphics.Camera;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.study.runningsnail.snailapp.R;
import com.study.runningsnail.snailapp.utils.LogcatUtils;

public class MainActivity extends AppCompatActivity {

    private LogcatUtils logcatUtils = LogcatUtils.getLogCat(MainActivity.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //主视图载入
        setContentView(R.layout.activity_main);
        initBottomArea();
    }

    public void initBottomArea(){
        Button goHomeBtn = (Button) findViewById(R.id.goHomeBtn);
        Button goAnimalListBtn = (Button) findViewById(R.id.goAnimalListBtn);
        Button logoutBtn = (Button) findViewById(R.id.logoutBtn);
        Button registerBtn = (Button) findViewById(R.id.registerBtn);
        Button goServiceBtn = (Button) findViewById(R.id.goServiceBtn);
        Button goCameraBtn = (Button) findViewById(R.id.goCameraBtn);
        BtnListener btnListener = new BtnListener();
        goHomeBtn.setOnClickListener(btnListener);
        goAnimalListBtn.setOnClickListener(btnListener);
        logoutBtn.setOnClickListener(btnListener);
        registerBtn.setOnClickListener(btnListener);
        goServiceBtn.setOnClickListener(btnListener);
        goCameraBtn.setOnClickListener(btnListener);
    }

    public void goHomeEvent(View v){
        logcatUtils.d("点击了进入主页界面");
        Intent intent = new Intent(MainActivity.this,HomeActivity.class);
        startActivity(intent);
    }

    public void goAnimalListEvent(View v){
        logcatUtils.d("点击了进入动物列表界面");
        Intent intent = new Intent(MainActivity.this,AnimalListActivity.class);
        startActivity(intent);
    }

    public void logoutEvent(View v){
        logcatUtils.d("点击了退出按钮");
    }

    public void registerEvent(View v){
        logcatUtils.d("系统提供的界面");
        Intent intent = new Intent(MainActivity.this,SystemSupportActivity.class);
        startActivity(intent);
    }
    public void goServiceEvent(View v){
        logcatUtils.d("打开服务测试界面");
        Intent intent = new Intent(MainActivity.this,ServiceActivity.class);
        startActivity(intent);
    }
    public void goCustomerCameraEvent(View v){
        logcatUtils.d("打开自定义照相机界面");
        Intent intent = new Intent(MainActivity.this,CameraActivity.class);
        startActivity(intent);
    }




    class BtnListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.goHomeBtn:goHomeEvent(v);break;
                case R.id.goAnimalListBtn:goAnimalListEvent(v);break;
                case R.id.logoutBtn:logoutEvent(v);break;
                case R.id.registerBtn:registerEvent(v);break;
                case R.id.goServiceBtn:goServiceEvent(v);break;
                case R.id.goCameraBtn:goCustomerCameraEvent(v);break;
            }
        }
    }
}
