package com.mizlicai.eudemon.utils;

import com.mizlicai.eudemon.entity.ErrorRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by huangyt on 2017/7/11.
 */
public class ObjectReflact {

    static Logger logger = LoggerFactory.getLogger(ObjectReflact.class);

    /**
     * 根据属性名获取属性值
     * */
    public static Object getFieldValueByName(String fieldName, Object o) {
        try {
            String firstLetter = fieldName.substring(0, 1).toUpperCase();
            String getter = "get" + firstLetter + fieldName.substring(1);
            Method method = o.getClass().getMethod(getter, new Class[] {});
            Object value = method.invoke(o, new Object[] {});
            return value;
        } catch (Exception e) {
            logger.error("对象反射根据属性名获取属性值异常", e);
            return null;
        }
    }

    /**
     * 获取属性名数组
     * */
    public  static  List<String> getFiledName(Object o){
        Field[] fields=o.getClass().getDeclaredFields();
        List<String> list = new ArrayList<>();
        for(int i=0;i<fields.length;i++){
            list.add(fields[i].getName());
        }
        return list;
    }

    /**
     * 获取属性类型(type)，属性名(name)，属性值(value)的map组成的list
     * */
    public static  List getFiledsInfo(Object o){
        Field[] fields=o.getClass().getDeclaredFields();
        String[] fieldNames=new String[fields.length];
        List list = new ArrayList();
        Map infoMap=null;
        for(int i=0;i<fields.length;i++){
            infoMap = new HashMap();
            infoMap.put("type", fields[i].getType().toString());
            infoMap.put("name", fields[i].getName());
            infoMap.put("value", getFieldValueByName(fields[i].getName(), o));
            list.add(infoMap);
        }
        return list;
    }

    /**
     * 获取对象的所有属性值，返回一个对象数组
     * */
    public static Object[] getFiledValues(Object o){
        List<String> fieldNames=getFiledName(o);
        Object[] value=new Object[fieldNames.size()];
        for(int i=0;i<fieldNames.size();i++){
            value[i]=getFieldValueByName(fieldNames.get(i), o);
        }
        return value;
    }

    public static  void main(String []args){
        ErrorRequest request = new ErrorRequest();
        List<String> names = getFiledName(request);
        for (String name:names ) {
            System.out.println(name.toString());
        }
    }
}
