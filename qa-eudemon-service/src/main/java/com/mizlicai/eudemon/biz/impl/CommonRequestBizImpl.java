package com.mizlicai.eudemon.biz.impl;

import com.mizlicai.cashier.data.XlsRowVO;
import com.mizlicai.eudemon.biz.CommonRequestBiz;
import com.mizlicai.eudemon.entity.*;
import com.mizlicai.eudemon.exceptions.TestException;
import com.mizlicai.eudemon.exceptions.TestExceptionCode;
import com.mizlicai.eudemon.service.RequestQueueService;
import com.mizlicai.eudemon.service.ServiceConfigService;
import com.mizlicai.eudemon.service.ServicesService;
import com.mizlicai.eudemon.thread.RequestTaskThread;
import com.mizlicai.eudemon.thread.ResponseTaskThread;
import com.mizlicai.eudemon.utils.CommUtil;
import com.mizlicai.eudemon.utils.ExcelUtils;
import com.mizlicai.eudemon.utils.FileDataFormat;
import com.mizlicai.eudemon.utils.HttpClientUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by huangyt on 2017/6/3.
 */
@Service
public class CommonRequestBizImpl implements CommonRequestBiz {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ServicesService servicesService;

    @Autowired
    private RequestQueueService requestQueueService;

    public void commonQuest(ServicesExample example ) throws TestException {
        List<Services> list = servicesService.getServicesByExample(example);
        if (CollectionUtils.isEmpty(list)){
            logger.info("无测试服务需要测试");
            return ;
        }
        for (Services services:list) {
            //ServiceConfig serviceConfig =  serviceConfigService.getByServiceId(services.getId());
            String requestDataUrl = services.getRequestDataUrl();
            String responseDataURL = services.getResponseDataUrl();
            if (StringUtils.isBlank(requestDataUrl) ||StringUtils.isBlank(responseDataURL)){
                logger.error("测试服务所需参数不存在");
                throw new TestException(TestExceptionCode.PARAM_MISS);
            }
            /**
             * 数据读取组装
             */
            List<XlsRowVO> requestParams = ExcelUtils.parseXls(requestDataUrl,0);


           /* List<XlsRowVO>  responseParams = ExcelUtils.parseXls(responseDataURL);*/

            //并发请求
            if (services.getConcurrentCount() != null){
                logger.info("进入并发执行任务,任务并发数：{},测试用例数:{}",services.getConcurrentCount(),requestParams.size());
                ExecutorService executorService = Executors.newFixedThreadPool(services.getConcurrentCount());
                final CyclicBarrier cyclicBarrier = new CyclicBarrier(services.getConcurrentCount());
                for (int j =0 ;j < requestParams.size();){
                    for (int i = 1; i <= services.getConcurrentCount(); i++) {
                        //插入请求实体
                        logger.info("j:{}",j);
                        if (j>requestParams.size()){
                            RequestQueue requestQueue = createRequest(services,requestParams.get(requestParams.size()).getMapData()/*,responseParams.get(requestParams.size()).getMapData()*/);
                            //创建请求线程
                            executorService.execute(new RequestTaskThread( j,requestQueueService,cyclicBarrier,requestQueue,requestParams.get(requestParams.size()).getMapData()));
                            j++;
                        }else{
                            RequestQueue requestQueue = createRequest(services,requestParams.get(j).getMapData()/*,responseParams.get(j).getMapData()*/);
                            //创建请求线程
                            executorService.execute(new RequestTaskThread( j,requestQueueService,cyclicBarrier,requestQueue,requestParams.get(j).getMapData()));
                            j++;
                        }

                    }
                }
                executorService.shutdown();//关闭线程池
                while (!executorService.isTerminated()) {
                    try {
                        // 所有线程池中的线程执行完毕，执行后续操作
                        logger.info("==============thread is sleep============");
                        Thread.sleep(10000);
                        logger.info("==============threadd is wake============");

                    } catch (InterruptedException e) {
                        logger.error("线程池链接异常",e);
                    }
                }
            }else{
                logger.info("进入串行执行任务");
                for(int i = 1 ;i<= requestParams.size();i++){
                    //组装请求实体
                    RequestQueue requestQueue = createRequest(services,requestParams.get(i).getMapData()/*,responseParams.get(i).getMapData()*/);
                    //发送请求体
                    HashMap<String,Object> responseData = (HashMap<String, Object>) HttpClientUtil.doRequest(services.getRequestUrl(),requestParams.get(i).getMapData(),null, services.getRequestType());
                    ResponseTaskThread responseTaskThread = new ResponseTaskThread(requestQueue,responseData,requestQueueService);
                    responseTaskThread.insertResponse();
                }
            }
        }

    }


    private Object getFieldValue(Object thisClass, String fieldName)
    {
        Object value = new Object();
        Method method = null;
        try {
            String methodName = fieldName.substring(0, 1).toUpperCase()+ fieldName.substring(1);
            method = thisClass.getClass().getMethod("get" + methodName);
            value = method.invoke(thisClass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }

    private RequestQueue createRequest(Services services, Map<String , Object> requestParams/*, Map<String , Object> responseParams*/){
        RequestQueue requestQueue = new RequestQueue();
        requestQueue.setCreateTime(CommUtil.nowTime());
        requestQueue.setServiceName(services.getServiceName());
        requestQueue.setRequestType(services.getRequestType());
        requestQueue.setRequestUrl(services.getRequestUrl());
        requestQueue.setRequestData(requestParams.toString());
        requestQueue.setServiceId(services.getId());
        requestQueue.setRequestTime(CommUtil.nowTime());
        requestQueue.setTestPoint(requestParams.get("testPoint") == null ? ""  :(String) requestParams.get("testPoint"));
        requestQueue.setExpectResponseStatus(requestParams.get("expect_response_status") == null ? "" : (String) requestParams.get("expect_response_status"));
        requestQueue.setExpectResponseData(requestParams.get("expect_response_data") == null ? "" : (String)requestParams.get("expect_response_data"));
        requestQueue.setExpectResponseCode(requestParams.get("expect_response_code") == null ? "" : (String)requestParams.get("expect_response_code"));
        return  requestQueue;
    }
}
