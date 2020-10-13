package com.miz.testframework.config;


import com.miz.testframework.config.impl.ConfigrationImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 *  配置项信息工厂类
 *
 */
public class ConfigrationFactory {

    protected static Logger logger = LoggerFactory.getLogger(ConfigrationFactory.class);


    private static Configration configImpl;
    public static final String  AUTO_CONFIG_BASE_DIR       = "config/";
    public static final String  AUTO_CONFIG_FILE_NAME      = "auto-config.properties";

    /**
     * 取得Configration对象
     *
     * 不需要加同步处理，Configration一般都是在系统启动时进行加载，启动的时候为单线程加载
     * @return
     */
    public static Configration getConfigration() {
        if (configImpl == null) {
            configImpl = new ConfigrationImpl();
            loadFromConfig(AUTO_CONFIG_BASE_DIR + AUTO_CONFIG_FILE_NAME);
        }

        return configImpl;
    }

    /**
     * 从配置文件中加载配置
     *
     * 一般就是auto-config.properties文件
     */
    public static void loadFromConfig(String confName) {
        logger.info("加载配置文件 [" + confName + "]");

        ClassLoader currentClassLoader = Thread.currentThread().getContextClassLoader();

        URL autoConfigUrl = currentClassLoader.getResource(confName);

        if (autoConfigUrl == null) {
            return;
        }

        Properties autoProperties = new Properties();
        try {
        	autoProperties.load(autoConfigUrl.openStream());
        } catch (Exception e) {
            return;
        }

        Set<Map.Entry<Object, Object>> entrySet = autoProperties.entrySet();
        for (Map.Entry<Object, Object> entry : entrySet) {
            Object keyObject = entry.getKey();
            Object valueObject = entry.getValue();
                configImpl.setProperty(keyObject.toString(), valueObject.toString());

        }
    }

}
