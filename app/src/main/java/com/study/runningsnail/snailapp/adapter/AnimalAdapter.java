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

import java.util.ArrayList;
import java.util.List;

/**
 * Created by snail on 2016/9/20.
 */

public class AnimalAdapter extends BaseAdapter {

    static class ViewHolder{
        TextView text_aName;
        TextView text_aSpeak;
        ImageView img_icon;
        CheckBox checkbox;
    }

    private List<Animal> animalList;
    private Context context;

    public AnimalAdapter(List<Animal> animalList,Context context){
        this.animalList = animalList;
        this.context = context;
    }


    @Override
    public int getCount() {
        return animalList.size();
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
        Animal animal  = animalList.get(position);
        //其实这个convertView是系统提供给我们的可供复用的View 的缓存对象。因此可以做个判断，如果已经有了我们不用再去让其解析xml了。
        if(convertView==null){
            //将R.layout.animal_list_item.xml 进行解析，生成view对象。
            convertView = LayoutInflater.from(context).inflate(R.layout.animal_list_item,parent,false);
            viewHolder = new ViewHolder();
            //每次都要获取item里面的这些标签元素，因此将标签对象直接装到一个静态类中，然后将这个静态类放到系统提供给我们可复用的View的缓存对象，即convertView对象中。这样下次再用这个时，就不用去findViewById了。
            viewHolder.img_icon = (ImageView) convertView.findViewById(R.id.img_icon);
            viewHolder.text_aName = (TextView) convertView.findViewById(R.id.text_aName);
            viewHolder.text_aSpeak = (TextView) convertView.findViewById(R.id.text_aSpeak);
            viewHolder.checkbox = (CheckBox) convertView.findViewById(R.id.checkbox);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        ImageView img_icon  = viewHolder.img_icon;
        TextView text_aName = viewHolder.text_aName;
        TextView text_aSpeak = viewHolder.text_aSpeak;
        CheckBox checkBox = viewHolder.checkbox;

        img_icon.setBackgroundResource(animal.getaIcon());
        text_aName.setText(animal.getaName()+":");
        text_aSpeak.setText(animal.getaSpeak());
        checkBox.setChecked(animal.isCheckFlag());
        return convertView;
    }

    public void add(Animal animal) {
        if (animalList == null ) {
            animalList = new ArrayList<>();
        }
        animalList.add(animal);
        notifyDataSetChanged();
    }

    public void delete(List<Integer> list){
        for(int i=0,l=list.size();i<l;i++){
            int position = list.get(i);
            if(position<animalList.size()){
                animalList.remove(position);
            }

        }
        notifyDataSetChanged();
    }
    public void deleteAll(){
            animalList.clear();
        notifyDataSetChanged();
    }
}

