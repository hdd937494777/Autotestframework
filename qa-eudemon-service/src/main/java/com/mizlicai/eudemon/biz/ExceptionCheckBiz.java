package com.mizlicai.eudemon.biz;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by huangyt on 2017/6/6.
 */
public interface ExceptionCheckBiz {

    /**
     * 定期检查异常请求
     */
    public  void checkException() throws InvocationTargetException, IllegalAccessException;
}
