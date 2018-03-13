package com.miz.testframework.objckeck.comparers;



/**
 *
 * "N" flag 校验器
 *
 * Created by chuwenjun on 2017/7/19.
 */
public class NoCheckComparer implements Comparer {

    /**
     * 不校验，直接返回成功
     * 
     * @param expect
     * @param actual
     * @return
     */
    public boolean compare(String expect, Object actual) {
        return true;
    }

}
