package com.study.runningsnail.snailapp.configFile;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Map;

/**
 * Created by snail on 2016/9/22.
 */

public abstract class BaseSpOperate implements BaseSpOperateInterface {

    private String fileName;

    private int mode;

    public  void setFileName(String fileName){
        this.fileName = fileName;
    }
    public  void setMode(int mode){
        this.mode = mode;

    }

    public String getFileName(){
        return this.fileName;
    }
    public int getMode(){
        return this.mode;
    }
    
    public void put(Context context, String key, Object obj) {
        SharedPreferences sp = context.getSharedPreferences( fileName, context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        if (obj instanceof Boolean) {
            editor.putBoolean(key, (Boolean) obj);
        } else if (obj instanceof Float) {
            editor.putFloat(key, (Float) obj);
        } else if (obj instanceof Integer) {
            editor.putInt(key, (Integer) obj);
        } else if (obj instanceof Long) {
            editor.putLong(key, (Long) obj);
        } else {
            editor.putString(key, (String) obj);
        }
        editor.commit();
    }


    
    public Object get(Context context, String key, Object defaultObj) {
        SharedPreferences sp = context.getSharedPreferences( fileName, context.MODE_PRIVATE);
        if (defaultObj instanceof Boolean) {
            return sp.getBoolean(key, (Boolean) defaultObj);
        } else if (defaultObj instanceof Float) {
            return sp.getFloat(key, (Float) defaultObj);
        } else if (defaultObj instanceof Integer) {
            return sp.getInt(key, (Integer) defaultObj);
        } else if (defaultObj instanceof Long) {
            return sp.getLong(key, (Long) defaultObj);
        } else if (defaultObj instanceof String) {
            return sp.getString(key, (String) defaultObj);
        }
        return null;
    }

    
    public   void remove(Context context, String key) {
        SharedPreferences sp = context.getSharedPreferences( fileName, context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.remove(key);
        editor.commit();
    }


   
    public Map<String, ?> getAll(Context context) {
        SharedPreferences sp = context.getSharedPreferences( fileName, context.MODE_PRIVATE);
        Map<String, ?> map = sp.getAll();
        return map;
    }

    
    public   void clear(Context context) {
        SharedPreferences sp = context.getSharedPreferences( fileName, context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear();
        editor.commit();
    }

   
    public   boolean contains(Context context, String key) {
        SharedPreferences sp = context.getSharedPreferences( fileName, context.MODE_PRIVATE);
        return sp.contains(key);
    }

}
