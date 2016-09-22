package com.study.runningsnail.snailapp.configFile;

import android.content.Context;

import java.util.Map;

/**
 * Created by snail on 2016/9/22.
 */

public interface BaseSpOperateInterface {

    /**
     * 保存数据
     */
     void put(Context context, String key, Object obj);

    /**
     * 获取指定数据
     */
     Object get(Context context, String key, Object defaultObj);

    /**
     * 删除指定数据
     */
     void remove(Context context, String key);

    /**
     * 返回所有键值对
     */
    Map<String, ?> getAll(Context context);

    /**
     * 删除所有数据
     */
    void clear(Context context);

    /**
     * 检查key对应的数据是否存在
     */
    boolean contains(Context context, String key);
}
