package com.study.runningsnail.snailapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.study.runningsnail.snailapp.R;
import com.study.runningsnail.snailapp.domain.Animal;
import com.study.runningsnail.snailapp.domain.SupportAct;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by snail on 2016/9/20.
 */

public class SystemActAdapter extends BaseAdapter {

    static class ViewHolder{
        TextView text_aName;
        ImageView img_icon;
    }

    private List<SupportAct> supportActs;
    private Context context;

    public SystemActAdapter(List<SupportAct> supportActs, Context context){
        this.supportActs = supportActs;
        this.context = context;
    }


    @Override
    public int getCount() {
        return supportActs.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        SupportAct supportAct  = supportActs.get(position);
        //其实这个convertView是系统提供给我们的可供复用的View 的缓存对象。因此可以做个判断，如果已经有了我们不用再去让其解析xml了。
        if(convertView==null){
            //将R.layout.animal_list_item.xml 进行解析，生成view对象。
            convertView = LayoutInflater.from(context).inflate(R.layout.system_support_activity_item,parent,false);
            viewHolder = new ViewHolder();
            //每次都要获取item里面的这些标签元素，因此将标签对象直接装到一个静态类中，然后将这个静态类放到系统提供给我们可复用的View的缓存对象，即convertView对象中。这样下次再用这个时，就不用去findViewById了。
            viewHolder.img_icon = (ImageView) convertView.findViewById(R.id.supportActivityImage);
            viewHolder.text_aName = (TextView) convertView.findViewById(R.id.supportActivityName);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        ImageView img_icon  = viewHolder.img_icon;
        TextView text_aName = viewHolder.text_aName;

        img_icon.setImageResource(supportAct.getImage());
        text_aName.setText(supportAct.getName());
        return convertView;
    }

}

