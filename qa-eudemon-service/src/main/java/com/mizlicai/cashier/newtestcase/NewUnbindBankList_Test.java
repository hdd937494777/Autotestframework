package com.mizlicai.cashier.newtestcase;

import com.mizlicai.eudemon.utils.HttpClientUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by MaiBenBen on 2017/6/1.
 */
public class NewUnbindBankList_Test {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    private final static String query_type = "GET";
    private final static String url = "http://121.43.148.191:8136/bank/list?";
    private HashMap<String,HashMap<String , Object>> resultParams = new HashMap<String, HashMap<String, Object>>();
    private HashMap<String,String> resultMap = new HashMap<String, String>();
    private Integer size =0;

    public HashMap<String, Object> getResult(Map<String ,Object> params){
      HashMap<String,Object> r = (HashMap<String, Object>) HttpClientUtil.doRequest(url,params,null,query_type);
      resultParams.put(size.toString(),r);
      size++;
        logger.info("进程:{}进入请求",size);
      return r;
    }

    public static String getQuery_type() {
        return query_type;
    }

    public static String getUrl() {
        return url;
    }

    public HashMap<String, HashMap<String, Object>> getResultParams() {
        return resultParams;
    }

    public void setResultParams(HashMap<String, HashMap<String, Object>> resultParams) {
        this.resultParams = resultParams;
    }

    public HashMap<String, String> getResultMap() {
        return resultMap;
    }

    public void setResultMap(HashMap<String, String> resultMap) {
        this.resultMap = resultMap;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
