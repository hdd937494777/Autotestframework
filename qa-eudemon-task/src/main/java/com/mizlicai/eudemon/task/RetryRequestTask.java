package com.mizlicai.eudemon.task;

import com.mizlicai.eudemon.biz.RetryRequestBiz;
import com.mizlicai.eudemon.exceptions.TestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Created by huangyt on 2017/7/10.
 */
public class RetryRequestTask {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private RetryRequestBiz retryRequestBiz;

    @Scheduled(cron = "0 0/10 * * * ? ")
    public void retry(){
        try {
            logger.info("退出异常服务重试定时任务");
            retryRequestBiz.retryRequest();
            logger.info("退出异常服务重试定时任务");
        } catch (TestException e) {
            logger.error("异常服务重试异常",e);
        }
    }
}
