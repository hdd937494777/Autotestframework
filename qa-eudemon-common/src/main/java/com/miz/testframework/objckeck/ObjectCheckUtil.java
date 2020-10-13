package com.miz.testframework.objckeck;

import java.io.UnsupportedEncodingException;

/**
 * 对象校验工具类
*/
public class ObjectCheckUtil {

    /**
     * 校验指定列的期望值
     *
     * @param csvPath 数据文件路径，resources下的相对路径
     * @param actual  校验对象
     * @param index   期望值的列序号，基数默认为0
     * @return
     */
    public static boolean check(String csvPath, Object actual, int index) throws UnsupportedEncodingException {
        return new ObjectCheck().check(csvPath, actual, index);
    }

}
