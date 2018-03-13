package com.mizlicai.eudemon.task;

import com.mizlicai.eudemon.biz.CommonRequestBiz;
import com.mizlicai.eudemon.entity.ServicesExample;
import com.mizlicai.eudemon.exceptions.TestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Created by huangyt on 2017/6/6.
 */
public class ServicesTask {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private CommonRequestBiz commonRequestBiz;

    @Scheduled(cron = "0 0 0/1 * * ?")
    public void sendRequest(){
        try {
            logger.info("进入服务列表请求定时任务");
            ServicesExample example = new ServicesExample();
            commonRequestBiz.commonQuest(example);
            logger.info("退出服务请求定时任务");
        } catch (TestException e) {
            logger.error("服务请求异常",e);
        }
    }
}
