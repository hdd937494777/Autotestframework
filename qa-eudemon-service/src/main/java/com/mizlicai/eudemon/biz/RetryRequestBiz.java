package com.mizlicai.eudemon.biz;

import com.mizlicai.eudemon.exceptions.TestException;

/**
 * Created by huangyt on 2017/7/10.
 */
public interface RetryRequestBiz {

    void retryRequest() throws TestException;
}
