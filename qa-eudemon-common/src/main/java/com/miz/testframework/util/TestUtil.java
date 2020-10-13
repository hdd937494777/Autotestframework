package com.miz.testframework.util;

import com.alibaba.fastjson.JSONObject;

import com.miz.testframework.vo.XlsRowVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

public class TestUtil {
    /**
     * 解析csv并插入DB(适用实体mapper集成Basemapper的场景)
     *
     * @param csvfile    csv文件路径
     * @param basemapper 插入表对应mapper
     * @param clazz
     */

    public static <T> void insertDB(String csvfile, BaseMapper basemapper, Class<T> clazz) {
        if (!csvfile.isEmpty()) {
            CSVParseUtil util = null;
            try {
                util = new CSVParseUtil(csvfile);
            } catch (Exception e) {
                e.printStackTrace();
            }
            List<XlsRowVO> list = util.parseCSV();
            for (int i = 0; i < list.size(); i++) {
                Map<String, Object> data = list.get(i).getMapData();
                String param = JSONObject.toJSONString(data);
                T record = JSONObject.parseObject(param, clazz);
                basemapper.insert(record);
            }
        }
    }


    /**
     * 解析csv并插入DB(适用实体mapper不继承Basemapper的场景)
     *
     * @param csvfile    csv文件路径
     * @param basemapper 插入表对应mapper
     * @param clazz
     */

    public static <T> void insertDBnew(String csvfile, Object basemapper, Class<T> clazz) {
        if (!csvfile.isEmpty()) {
            CSVParseUtil util = null;
            try {
                util = new CSVParseUtil(csvfile);
            } catch (Exception e) {
                e.printStackTrace();
            }
            List<XlsRowVO> list = util.parseCSV();
            for (int i = 0; i < list.size(); i++) {
                Map<String, Object> data = list.get(i).getMapData();
                String param = JSONObject.toJSONString(data);
                T record = JSONObject.parseObject(param, clazz);
                Class cur_class = basemapper.getClass();
                Method[] methods=cur_class.getMethods();
                for (Method method : methods) {
                    if (method.getName().contains("insert")){
                        try {
                            method.invoke(basemapper,record);
                            break;
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }


}