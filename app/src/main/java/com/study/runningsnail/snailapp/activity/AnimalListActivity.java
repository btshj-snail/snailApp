package com.study.runningsnail.snailapp.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.study.runningsnail.snailapp.R;
import com.study.runningsnail.snailapp.adapter.AnimalAdapter;
import com.study.runningsnail.snailapp.domain.Animal;
import com.study.runningsnail.snailapp.eventListener.AnimalListBtnListener;
import com.study.runningsnail.snailapp.utils.LogcatUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by snail on 2016/9/21.
 */

public class AnimalListActivity extends AppCompatActivity {

    private List<Animal> animalList = null;
    private Context context;
    private AnimalAdapter animalAdapter = null;
    private ListView list_animal;
    private LogcatUtils logcatUtils = LogcatUtils.getLogCat(AnimalListActivity.class);

    private AnimalListBtnListener animalListBtnListener = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //主视图载入
        setContentView(R.layout.activity_animal_list);

        context = AnimalListActivity.this;

        //获取每一行的标签
        list_animal = (ListView) findViewById(R.id.list_animate);

        //注入表头和表尾标签文件
        final LayoutInflater inflater = LayoutInflater.from(this);
        View headView = inflater.inflate(R.layout.view_animal_list_header,null,false);
        View footView = inflater.inflate(R.layout.view_animal_list_footer, null, false);

        //组装列表数据
        animalList = new ArrayList<>();
        animalList.add(new Animal("dog say","hello ,i am a dog",R.drawable.dog,true));
        animalList.add(new Animal("dog say","hello ,i am a dog",R.drawable.dog,true));
        animalList.add(new Animal("dog say","hello ,i am a dog",R.drawable.dog,true));
        animalList.add(new Animal("dog say","hello ,i am a dog",R.drawable.dog,false));
        animalList.add(new Animal("dog say","hello ,i am a dog",R.drawable.dog,false));
        animalList.add(new Animal("cattle say","hello ,i am a cattle,i can produce milk",R.drawable.cattle,false));
        animalList.add(new Animal("duck say","hello ,i am a duck,i can swim",R.drawable.duck,false));
        animalList.add(new Animal("fish say","hello ,i am a fish,duck is bad guys",R.drawable.fish,false));
        if(animalList.size()!=0){
            //实例化适配器，将数据写入适配器中
            animalAdapter = new AnimalAdapter(animalList,context);
            list_animal.addHeaderView(headView);
            list_animal.addFooterView(footView);

            //适配器和视图关联
            list_animal.setAdapter(animalAdapter);
            list_animal.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(context,"你点击了第"+position+"项",Toast.LENGTH_SHORT).show();
                    logcatUtils.i("点击生效，点击了第"+position+"项");
                }
            });
        }else{
            TextView noSizeTipView = (TextView) findViewById(R.id.noSize);
            noSizeTipView.setVisibility(View.VISIBLE);
        }

        //实例化监听器
        animalListBtnListener = new AnimalListBtnListener(animalAdapter,this);

        //按钮监听
        Button addBtn = (Button) findViewById(R.id.addBtn);
        addBtn.setOnClickListener(animalListBtnListener);

        Button delBtn = (Button) findViewById(R.id.delBtn);
        delBtn.setOnClickListener(animalListBtnListener);

        Button delAllBtn = (Button) findViewById(R.id.delAllBtn);
        delAllBtn.setOnClickListener(animalListBtnListener);
    }
}
