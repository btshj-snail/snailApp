package com.study.runningsnail.snailapp.configFile;

import android.content.Context;

import java.util.Map;

/**
 * Created by snail on 2016/9/22.
 */

public class UserPreferenceOperate extends BaseSpOperate implements ExtendSpOperateIntreface{
    private static final String FILE_NAME = "userPreference";

    private Context mContext ;

    public UserPreferenceOperate(Context context,int mode){
        this.mContext = context;
        this.setMode(mode);
        this.setFileName(FILE_NAME);
    }

    public UserPreferenceOperate(Context context){
        this.mContext = context;
        this.setMode(context.MODE_PRIVATE);
        this.setFileName(FILE_NAME);
    }


    @Override
    public void put(String key, Object obj) {
        put(mContext,key,obj);
    }

    @Override
    public Object get(String key, Object defaultObj) {
        return get(mContext,key,defaultObj);
    }

    @Override
    public void remove(String key) {
        remove(mContext,key);
    }

    @Override
    public Map<String, ?> getAll() {
        return getAll(mContext);
    }

    @Override
    public void clear() {
        clear(mContext);
    }

    @Override
    public boolean contains(String key) {
        return contains(mContext,key);
    }
}
