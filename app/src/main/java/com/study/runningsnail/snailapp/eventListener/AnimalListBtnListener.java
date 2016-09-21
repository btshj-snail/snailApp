package com.study.runningsnail.snailapp.eventListener;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ListView;

import com.study.runningsnail.snailapp.R;
import com.study.runningsnail.snailapp.adapter.AnimalAdapter;
import com.study.runningsnail.snailapp.domain.Animal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by snail on 2016/9/20.
 */

public class AnimalListBtnListener implements View.OnClickListener {

    private AnimalAdapter animalAdapter;
    private AppCompatActivity appCompatActivity;

    public AnimalListBtnListener (AnimalAdapter animalAdapter,AppCompatActivity appCompatActivity){
        this.animalAdapter = animalAdapter;
        this.appCompatActivity = appCompatActivity;
    }
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.addBtn : addBtnOper();break;
            case R.id.delBtn :delBtnOper();break;
            case R.id.delAllBtn:delAllBtnOper();break;
        }
    }


    public void addBtnOper(){
        animalAdapter.add(new Animal("dog say","hello ,i am a dog",R.drawable.dog,true) );
    }

    public void delBtnOper(){
        List<Integer> list = new ArrayList<>();
        ListView listView = (ListView) appCompatActivity.findViewById(R.id.list_animate);
        for(int i=0,l=listView.getChildCount();i<l;i++){
            View view = listView.getChildAt(i);
            CheckBox checkBox = (CheckBox) view.findViewById(R.id.checkbox);
            //不一定每一行都会有checkbox标签，主要是因为有表头，表尾
            if(checkBox!=null && checkBox.isChecked()){
                list.add(i-1);
            }
        }
        animalAdapter.delete(list);
    }

    public void delAllBtnOper(){
        animalAdapter.deleteAll();
    }
}
