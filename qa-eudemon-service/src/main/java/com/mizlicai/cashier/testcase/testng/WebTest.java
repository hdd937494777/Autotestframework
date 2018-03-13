package com.mizlicai.cashier.testcase.testng;

import org.testng.annotations.Test;

/**
 * Created by huangyt on 2017/7/11.
 */
public class WebTest {

    private int m_numberOfTimes;

    public WebTest(int m_numberOfTimes){
        this.m_numberOfTimes = m_numberOfTimes;
    }

    @Test
    public void testServer(){
        for (int i =0; i<m_numberOfTimes; i++){
            System.out.println("access the web page,times"+i+", this intance is "+this);
        }
    }

}
