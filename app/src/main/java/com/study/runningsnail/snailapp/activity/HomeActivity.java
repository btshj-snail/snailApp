package com.study.runningsnail.snailapp.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.study.runningsnail.snailapp.R;
import com.study.runningsnail.snailapp.fragment.HomeFragment;
import com.study.runningsnail.snailapp.utils.LogcatUtils;

/**
 * Created by snail on 2016/9/22.
 */

public class HomeActivity extends AppCompatActivity implements View.OnClickListener{

    private LogcatUtils logcatUtils = LogcatUtils.getLogCat(HomeActivity.class);
    private Context mContext;

    //UI Object
    private TextView txt_topbar;
    private TextView txt_channel;
    private TextView txt_message;
    private TextView txt_better;
    private TextView txt_setting;
    private FrameLayout ly_content;

    //Fragment Object
    private HomeFragment fg1,fg2,fg3,fg4;
    private FragmentManager fManager;
    private FragmentTransaction fTransaction=null;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(R.layout.activity_home);
        fManager = getFragmentManager();
        bindViews();
        txt_channel.performClick();   //模拟一次点击，既进去后选择第一项
    }

    public void bindViews(){
        txt_topbar = (TextView) findViewById(R.id.txt_topbar);
        txt_channel = (TextView) findViewById(R.id.txt_channel);
        txt_message = (TextView) findViewById(R.id.txt_message);
        txt_better = (TextView) findViewById(R.id.txt_better);
        txt_setting = (TextView) findViewById(R.id.txt_setting);
        ly_content = (FrameLayout) findViewById(R.id.ly_content);

        txt_channel.setOnClickListener(this);
        txt_message.setOnClickListener(this);
        txt_better.setOnClickListener(this);
        txt_setting.setOnClickListener(this);
    }

    public HomeFragment choseTab(View choseView,HomeFragment homeFragment,String content){
        clearSelectedState();
        hideAllFragment();
        choseView.setSelected(true);

        if(homeFragment==null){
            homeFragment = new HomeFragment();
            homeFragment.setContent(content);
            fTransaction.add(R.id.ly_content,homeFragment);
        }else{
            fTransaction.show(homeFragment);
        }
        fTransaction.commit();
        return homeFragment;
    }

    //隐藏所有Fragment
    private void hideAllFragment(){
        if(fTransaction!=null && fg1 != null)fTransaction.hide(fg1);
        if(fTransaction!=null && fg2 != null)fTransaction.hide(fg2);
        if(fTransaction!=null && fg3 != null)fTransaction.hide(fg3);
        if(fTransaction!=null && fg4 != null)fTransaction.hide(fg4);
    }

    //隐藏所有Fragment
    private void clearSelectedState(){
        if(txt_setting!=null) txt_setting.setSelected(false);
        if(txt_better!=null) txt_better.setSelected(false);
        if(txt_message!=null) txt_message.setSelected(false);
        if(txt_channel!=null) txt_channel.setSelected(false);
    }

    @Override
    public void onClick(View v) {
        fTransaction = fManager.beginTransaction();

        switch(v.getId()){
            case R.id.txt_channel :
                fg1 = choseTab(findViewById(R.id.txt_channel),fg1,"channel");
                break;
            case R.id.txt_message :
                fg2 = choseTab(findViewById(R.id.txt_message),fg2,"message");
                break;
            case R.id.txt_better :
                fg3 = choseTab(findViewById(R.id.txt_better),fg3,"my better");
                break;
            case R.id.txt_setting :
                fg4 =  choseTab(findViewById(R.id.txt_setting),fg4,"my setting");
                break;
        }
    }
}
