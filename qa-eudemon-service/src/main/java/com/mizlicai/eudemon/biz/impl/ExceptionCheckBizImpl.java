package com.mizlicai.eudemon.biz.impl;

import com.mizlicai.eudemon.biz.ExceptionCheckBiz;
import com.mizlicai.eudemon.context.AppContext;
import com.mizlicai.eudemon.entity.*;
import com.mizlicai.eudemon.service.ErrorRequestService;
import com.mizlicai.eudemon.service.RequestQueueService;
import com.mizlicai.eudemon.service.ServicesService;
import com.mizlicai.eudemon.utils.CommUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * Created by huangyt on 2017/6/6.
 */
@Service
public class ExceptionCheckBizImpl implements ExceptionCheckBiz {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private RequestQueueService requestQueueService;

    @Autowired
    private ErrorRequestService errorRequestService;

    @Autowired
    private ServicesService servicesService;

    @Override
    public void checkException() throws InvocationTargetException, IllegalAccessException {
        RequestQueueExample example = new RequestQueueExample();
        RequestQueueExample.Criteria criteria = example.createCriteria();
        criteria.andIsCheckEqualTo(AppContext.YES_OR_NO.NO.name());
        List<RequestQueue> list  = requestQueueService.getRequestQueueByExample(example);
        if (CollectionUtils.isEmpty(list)){
            logger.info("无请求需要监控是否异常");
             return ;
        }
        for (RequestQueue requestQueue:list) {
            Services services = servicesService.getServiceById(requestQueue.getServiceId());
              if (requestQueue.getResponseStatus() == null || !requestQueue.getResponseStatus().equals("200")){
                  ErrorRequest errorRequest = new ErrorRequest();
                  BeanUtils.copyProperties(errorRequest, requestQueue);
                  errorRequest.setResult(AppContext.ERROR_CODE.SYSTEM_ERROR.getLabel());
                  errorRequestService.insert(errorRequest);
                  services.setIsNormal(AppContext.YES_OR_NO.NO.name());
              }else if (!requestQueue.getResponseStatus().equals(requestQueue.getExpectResponseStatus())){
                  ErrorRequest errorRequest = new ErrorRequest();
                  BeanUtils.copyProperties(errorRequest, requestQueue);
                  errorRequest.setResult(AppContext.ERROR_CODE.STATUS_ERROR.getLabel());
                  errorRequestService.insert(errorRequest);
                  services.setIsNormal(AppContext.YES_OR_NO.NO.name());
              }
              else if (!requestQueue.getResponseCode().equals(requestQueue.getExpectResponseCode())){
                  ErrorRequest errorRequest = new ErrorRequest();
                  BeanUtils.copyProperties(errorRequest, requestQueue);
                  errorRequest.setResult(AppContext.ERROR_CODE.CODE_ERROR.getLabel());
                  errorRequestService.insert(errorRequest);
                  services.setIsNormal(AppContext.YES_OR_NO.NO.name());
              }else{
                  ErrorRequestExample errorRequestExample = new ErrorRequestExample();
                  errorRequestExample.createCriteria().andServiceIdEqualTo(services.getId().toString());
                  errorRequestService.deleteByExample(errorRequestExample);
              }
              services.setUpdateTime(CommUtil.nowTime());
              requestQueue.setIsCheck(AppContext.YES_OR_NO.YES.name());
              requestQueue.setUpdateTime(CommUtil.nowTime());
              servicesService.update(services);
              requestQueueService.update(requestQueue);
        }

    }
}
