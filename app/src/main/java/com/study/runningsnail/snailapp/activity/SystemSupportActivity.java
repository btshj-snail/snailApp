package com.study.runningsnail.snailapp.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Contacts;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.study.runningsnail.snailapp.R;
import com.study.runningsnail.snailapp.adapter.SystemActAdapter;
import com.study.runningsnail.snailapp.domain.SupportAct;
import com.study.runningsnail.snailapp.utils.LogcatUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by snail on 2016/9/21.
 */

public class SystemSupportActivity extends AppCompatActivity {

    private LogcatUtils logcatUtils = LogcatUtils.getLogCat(SystemSupportActivity.class);

    List<SupportAct> list = null;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_system_support_activity);
        initListView();
    }

    public void initListView(){

        list = new ArrayList<>();
        list.add(new SupportAct("callPhone","拨打10086电话",R.drawable.videos_disable));
        list.add(new SupportAct("sendMessage","发送短信",R.drawable.play_disable));
        list.add(new SupportAct("sendFile","发送彩信",R.drawable.photos_normal));
        list.add(new SupportAct("opeBaidu","打开百度",R.drawable.camera));
        list.add(new SupportAct("playVideo","播放媒体",R.drawable.videos_disable));
        list.add(new SupportAct("openCamera","打开照相机",R.drawable.play_disable));
        list.add(new SupportAct("openContact","打开联系人",R.drawable.camera));

        SystemActAdapter systemActAdapter = new SystemActAdapter(list,SystemSupportActivity.this);
        GridView list_supportAct = (GridView) findViewById(R.id.supportActivityGrid);
        list_supportAct.setAdapter(systemActAdapter);

        list_supportAct.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               String actId =  list.get(position).getId();
                if(actId=="callPhone"){
                    //给移动客服10086拨打电话
                    Uri uri = Uri.parse("tel:10086");
                    Intent intent = new Intent(Intent.ACTION_DIAL, uri);
                    startActivity(intent);
                }else if(actId=="sendMessage"){
                    Uri uri = Uri.parse("smsto:10086");
                    Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
                    intent.putExtra("sms_body", "Hello");
                    startActivity(intent);
                }
                else if(actId=="sendFile"){
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.putExtra("sms_body", "Hello");
                    Uri uri = Uri.parse("content://media/external/images/media/23");
                    intent.putExtra(Intent.EXTRA_STREAM, uri);
                    intent.setType("image/png");
                    startActivity(intent);
                }
                else if(actId=="opeBaidu"){
                    Uri uri = Uri.parse("http://www.baidu.com");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if(actId=="playVideo"){
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    Uri uri = Uri.parse("file:///sdcard/foo.mp3");
                    intent.setDataAndType(uri, "audio/mp3");
                    startActivity(intent);
                }
                else if(actId=="openCamera"){
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(intent, 0);
                    // 取出照片数据
                    Bundle extras = intent.getExtras();
                    Bitmap bitmap = (Bitmap) extras.get("data");
                }
                else if(actId=="openContact"){
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_VIEW);
                    intent.setData(Contacts.People.CONTENT_URI);
                    startActivity(intent);
                }
            }
        });
    }

}
