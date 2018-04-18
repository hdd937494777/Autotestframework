package com.miz.testframework.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * dongdong Created by 下午2:28  2018/3/30
 */
@Component
    public class SpringContextUtil implements ApplicationContextAware {
        private static ApplicationContext applicationContext;

        public SpringContextUtil() {
        }

        public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
            this.applicationContext = applicationContext;
        }

        public static ApplicationContext getApplicationContext() {
            return applicationContext;
        }

        public static <T> T getBean(String name) throws BeansException {
            return (T)applicationContext.getBean(name);
        }

        public static <T> T getBean( Class<T> requiredType) throws BeansException {
            return applicationContext.getBean(requiredType);
        }

}

