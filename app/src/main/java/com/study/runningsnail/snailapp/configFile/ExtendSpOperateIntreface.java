package com.study.runningsnail.snailapp.configFile;

import java.util.Map;

/**
 * Created by snail on 2016/9/22.
 */

public interface ExtendSpOperateIntreface {
    /**
     * 保存数据
     */
    void put(String key, Object obj);

    /**
     * 获取指定数据
     */
    Object get(String key, Object defaultObj);

    /**
     * 删除指定数据
     */
    void remove(String key);

    /**
     * 返回所有键值对
     */
    Map<String, ?> getAll();

    /**
     * 删除所有数据
     */
    void clear();

    /**
     * 检查key对应的数据是否存在
     */
    boolean contains(String key);
}
