package com.miz.testframework.config;

import java.util.Map;

/**
 *  配置项信息
 * 
 * Create at：2017年7月12日 上午10:46:38
 * @author chuwenjun 
 */
public interface Configration {

    /**
     * 取得配置信息
     * <p/>
     * <p>
     * 这里返回的Map的是安全的，可以随便修改
     * </p>
     * 
     * @return
     */
    public Map<String, String> getConfig();

    /**
     * 根据key取得配置信息
     * 
     * @param key
     * @return
     */
    public String getPropertyValue(String key);

    /**
     * 设置属性值
     * @param key
     * @param value
     */
    public void setProperty(String key, String value);
}
