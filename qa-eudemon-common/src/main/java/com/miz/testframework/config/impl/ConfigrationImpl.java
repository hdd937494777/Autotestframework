package com.miz.testframework.config.impl;


import com.miz.testframework.config.Configration;

import java.util.HashMap;
import java.util.Map;



/**
 *  配置项信息实现
 *
 * Created by chuwenjun on 2017/7/24.
 */
public class ConfigrationImpl implements Configration {

    /**
     * 配置Map
     */
    private Map<String, String> autoConfigMap = new HashMap<String, String>();


    public Map<String, String> getConfig() {
        Map<String, String> map = new HashMap<String, String>();
        map.putAll(this.autoConfigMap);
        return map;
    }

    public void setConfig(Map<String, String> map) {
        this.autoConfigMap.putAll(map);
    }

    public String getPropertyValue(String key) {
        return this.autoConfigMap.get(key);
    }

    /**
     * 设置配置属性
     *
     * @param key
     * @param value
     */
    public void setProperty(String key, String value) {
        this.autoConfigMap.put(key, value);
    }

}
