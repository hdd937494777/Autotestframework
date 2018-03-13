package com.mizlicai.cashier.testcase.testng;

import org.testng.annotations.Factory;

/**
 * Created by huangyt on 2017/7/11.
 */
public class WebTestFactory {

    /**
     * factory返回一个对象工厂，这些对象将作为测试类，这个方法必须返回Object[]
     * 一般可以用做
     * @return
     */
    @Factory
    public Object[] createInstances(){
        Object[] result = new Object[5];
        for (int i =0 ;i<5; i++){
            result[i] = new WebTest(i+1);
        }
        return result;
    }
}
