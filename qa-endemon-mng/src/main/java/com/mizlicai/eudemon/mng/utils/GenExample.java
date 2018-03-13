package com.mizlicai.eudemon.mng.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by djq on 2016/6/12.
 * Copyright © mizhuanglicai
 * 生产Mybatis 条件对象
 * @author djq
 */
public class GenExample {

    public static <T> T genExample(Object vo,Class<T> clazz){
        try {
             T t = clazz.newInstance();
            //获取VO字段列表
            Class voClass = vo.getClass();
            Field[] fields = voClass.getFields();
            Method method;
            if(null != fields && fields.length > 0){
                for(int i=0;i<fields.length;i++){
                    //获取Example相应的method
//                    method =
                }
            }
            return t;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


        return null;
    }
}
