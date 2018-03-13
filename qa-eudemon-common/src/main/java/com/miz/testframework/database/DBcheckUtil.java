package com.miz.testframework.database;

import java.io.UnsupportedEncodingException;

/**
 * Created by chuwenjun on 2017/7/24.
 */
public class DBcheckUtil {

    /**
     * 通过单一CSV文件校验数据，查询条件由CSV文件中"flag=C"的字段组成，默认检验文件第1列
     *
     * @param path 路径
     * @param index 指定列 (1开始)
     * @return 数据检查状态
     * @throws UnsupportedEncodingException
     */
    public static boolean DBCheckWithoutCondition(String path, int index) throws UnsupportedEncodingException {
        return DBUtils.DBCheckWithoutCondition(path, index);
    }



}
