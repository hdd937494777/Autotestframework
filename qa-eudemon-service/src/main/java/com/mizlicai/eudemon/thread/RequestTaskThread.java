package com.mizlicai.eudemon.thread;

import com.mizlicai.eudemon.entity.RequestQueue;
import com.mizlicai.eudemon.service.RequestQueueService;
import com.mizlicai.eudemon.utils.CommUtil;
import com.mizlicai.eudemon.utils.HttpClientUtil;
import org.apache.http.StatusLine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by huangyt on 2017/6/5.
 */
public class RequestTaskThread implements Runnable{

    private Logger logger = LoggerFactory.getLogger(getClass());

    private CyclicBarrier cyclicBarrier;

    private RequestQueue requestQueue;

    private Map<String , Object> params;

    private RequestQueueService requestQueueService;


    int n ;

    public RequestTaskThread(int n , RequestQueueService requestQueueService, CyclicBarrier cyclicBarrier, RequestQueue requestQueue, Map<String , Object> params) {
        this.cyclicBarrier = cyclicBarrier;
        this.n = n;
        this.requestQueue = requestQueue;
        this.params = params;
        this.requestQueueService = requestQueueService;
    }

    @Override
    public void run() {
        try {
            // 等待所有任务准备就绪
            logger.info("任务：{}已经准备就绪",n);
            cyclicBarrier.await();
            logger.info("任务：{}已经开始执行,开始时间：{}",n,CommUtil.nowTime());

            HashMap<String,Object> responseData = (HashMap<String, Object>) HttpClientUtil.doRequest(requestQueue.getRequestUrl(),params,"utf-8",requestQueue.getRequestType());

            logger.info("任务：{}已经执行完成,结束时间：{}",n,CommUtil.nowTime());

            //异步插入响应数据
            requestQueue.setResponseTime(CommUtil.nowTime());
            ResponseTaskThread responseTaskThread = new ResponseTaskThread(requestQueue,responseData,requestQueueService);
            responseTaskThread.insertResponse();

        } catch (Exception e) {
            logger.error("并发请求异常",e);
        }
    }

}
