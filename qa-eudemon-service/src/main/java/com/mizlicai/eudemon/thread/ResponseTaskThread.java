package com.mizlicai.eudemon.thread;

import com.alibaba.fastjson.JSONObject;
import com.mizlicai.eudemon.context.AppContext;
import com.mizlicai.eudemon.entity.RequestQueue;
import com.mizlicai.eudemon.service.RequestQueueService;
import com.mizlicai.eudemon.utils.CommUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.StatusLine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

/**
 * Created by huangyt on 2017/6/6.
 */
public class ResponseTaskThread  {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private RequestQueue requestQueue;

    HashMap<String,Object> responseData;

    private RequestQueueService requestQueueService;

    public ResponseTaskThread(RequestQueue requestQueue, HashMap<String,Object> responseData,RequestQueueService requestQueueService){
        this.requestQueue = requestQueue;
        this.responseData = responseData;
        this.requestQueueService = requestQueueService;

    }

    public void insertResponse(){
        logger.info("进去异步插入请求响应数据");
        new Thread(){
            public void run() {
                requestQueue.setResponseData(responseData.toString());
                requestQueue.setResponseTime(CommUtil.nowTime());
                if (null != responseData.get("status") ){
                    StatusLine statusLine = (StatusLine)responseData.get("status");
                    requestQueue.setResponseStatus(String.valueOf(statusLine.getStatusCode()));
                }
                if (null !=responseData.get("result") ){
                    JSONObject jsonObject = JSONObject.parseObject((String)responseData.get("result"));
                    String code = jsonObject.get("code") == null ? ""  : (String)jsonObject.get("code") ;
                    requestQueue.setResponseData((String)responseData.get("result"));
                    requestQueue.setResponseCode(code);
                }
                requestQueue.setIsCheck(AppContext.YES_OR_NO.NO.name());
                requestQueue.setCreateTime(CommUtil.nowTime());
                requestQueueService.insert(requestQueue);
            }
        }.start();
    }
}
