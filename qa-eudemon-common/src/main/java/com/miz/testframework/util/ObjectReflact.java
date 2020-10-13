package com.miz.testframework.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ObjectReflact {

    static Logger logger = LoggerFactory.getLogger(ObjectReflact.class);

    private static List<String> filenameList = new ArrayList<>();

    private  static  List<Map<String ,String>> list = new ArrayList();

    /**
     * 获取属性类型(type)，属性名(name)，属性值(value)的map组成的list
     * */
    public static  List<Map<String ,String>>  getFiledsMap(Object obj){
        Class cur_class = obj.getClass();
        getFieldAndType(cur_class);
        return list;
    }

    static void getFieldAndType(Class cur_class) {
        String class_name = cur_class.getName();
        Field[] obj_fields = cur_class.getDeclaredFields();
        for (Field field : obj_fields) {
            field.setAccessible(true);

            Map<String ,String> infoMap = new HashMap<>();

            String name = field.getName();
            if (name.equals("id") || name.equals("serialVersionUID")){
                continue;
            }
            if (name.equals("createTime") || name.equals("updateTime")){
                continue;
            }
            infoMap.put("name", name);

            String type = field.getType().toString();
            String typeName ="";
            if (type.contains(".")){
                typeName = type.substring ( type.lastIndexOf(".")+1,type.length());
            }else{
                typeName = type;
            }
            infoMap.put("type", typeName);
            list.add(infoMap);
        }
        if (cur_class.getSuperclass() != null) {
            getFieldAndType(cur_class.getSuperclass());
        }

    }


    static void getClassFieldAndMethod(Class cur_class) {
        String class_name = cur_class.getName();
        Field[] obj_fields = cur_class.getDeclaredFields();
        for (Field field : obj_fields) {
            field.setAccessible(true);
            if ("serialVersionUID".equals(field.getName())){
                continue;
            }
            filenameList.add(field.getName());
            logger.info(class_name + ":" + field.getName());
        }
        if (cur_class.getSuperclass() != null) {
            getClassFieldAndMethod(cur_class.getSuperclass());
        }

    }
    /**
     * 获取对象的所有属性值包括父类，返回一个对象数组
     * */
    static List<String> getFiledName(Object obj){

        Class cur_class = obj.getClass();
        getClassFieldAndMethod(cur_class);
        return  filenameList;
    }

}
