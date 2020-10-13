package com.miz.testframework.objckeck.comparers;

public interface Comparer {

    /**
     *  比较时将回调该方法
     *
     * @param expect 期望值
     * @param actual 实际对象
     * @return
     */
    public boolean compare(String expect, Object actual);
}
