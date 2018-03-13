package com.mizlicai.eudemon.biz.impl;

import com.mizlicai.eudemon.biz.RetryRequestBiz;
import com.mizlicai.eudemon.context.AppContext;
import com.mizlicai.eudemon.entity.ErrorRequest;
import com.mizlicai.eudemon.entity.ErrorRequestExample;
import com.mizlicai.eudemon.entity.Services;
import com.mizlicai.eudemon.entity.ServicesExample;
import com.mizlicai.eudemon.exceptions.TestException;
import com.mizlicai.eudemon.service.ErrorRequestService;
import com.mizlicai.eudemon.service.ServicesService;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by huangyt on 2017/7/10.
 */
@Service
public class RetryRequestBizImpl implements RetryRequestBiz {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ErrorRequestService errorRequestService;


    @Autowired
    private CommonRequestBizImpl commonRequestBiz ;

    @Autowired
    private ServicesService servicesService;


    @Override
    public void retryRequest() throws TestException {
        logger.info("进入异常请求的服务重试服务");
        ServicesExample example = new ServicesExample();
        example.createCriteria().andIsNormalEqualTo(AppContext.YES_OR_NO.NO.name());
        List<Services> list =  servicesService.getServicesByExample(example);
       if (CollectionUtils.isEmpty(list)){
           logger.info("无异常请求的服务");
           return ;
       }
        commonRequestBiz.commonQuest(example);
        logger.info("退出异常请求的服务重试服务");
    }
}
