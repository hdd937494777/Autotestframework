package com.mizlicai.eudemon.task;

import com.mizlicai.eudemon.biz.ExceptionCheckBiz;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * Created by huangyt on 2017/6/6.
 */
public class ExceptionCheckTask {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ExceptionCheckBiz exceptionCheckBiz;

    @Scheduled(cron = "0 0/10 * * * ? ")
    public void check(){
        try {
            logger.info("进入检查异常请求定时任务");
            exceptionCheckBiz.checkException();
            logger.info("推出检查异常请求定时任务");
        } catch (Exception e) {
            logger.error("检查异常请求异常",e);
        }
    }
}
