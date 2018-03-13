package com.mizlicai.eudemon.utils;

import com.miz.mekansm.common.utils.JsonUtil;
import org.apache.commons.collections.map.HashedMap;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.util.*;
import java.util.Map.Entry;

/**
 * Created by penghc on 16/10/11.
 */
public class HttpClientUtil {
    private  static  Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);

    //https post方法
    public static  Map<String,Object> doPost(String url,Map<String,Object> map,String charset){
        HttpClient httpClient = null;
        HttpPost httpPost = null;
        String result = null;
        Map<String,Object> responseMap = new HashMap<String,Object>();
        try{
            httpClient = new SSLClient();
            httpPost = new HttpPost(url);
            //设置参数
            List<NameValuePair> list = new ArrayList<NameValuePair>();
            Iterator iterator = map.entrySet().iterator();
            while(iterator.hasNext()){
                Entry<String,String> elem = (Entry<String, String>) iterator.next();
                     list.add(new BasicNameValuePair(elem.getKey(),elem.getValue()));
            }
            if(list.size() > 0){
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list,charset);
                httpPost.setEntity(entity);
            }
            HttpResponse response = httpClient.execute(httpPost);
            if(response != null){
                responseMap.put("status",response.getStatusLine());
                HttpEntity resEntity = response.getEntity();
                if(resEntity != null){
                    result = EntityUtils.toString(resEntity,charset);
                    responseMap.put("result",result);
                }
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return responseMap;
    }

    // https get 方法
    public static  Map<String,Object>  doGet(String url,String charset){
        if(null == charset){
            charset = "utf-8";
        }
        HttpClient httpClient = null;
        HttpGet httpGet= null;
        String result = null;
        Map<String,Object> responseMap = new HashMap<String,Object>();
        try {
            httpClient = new SSLClient();
            URI uri = new URI(url);
            logger.info("发送get请求，请求地址为："+uri.toString());
            httpGet = new HttpGet(uri);

            HttpResponse response = httpClient.execute(httpGet);
            if(response != null){
                responseMap.put("status",response.getStatusLine());
                HttpEntity resEntity = response.getEntity();
                if(resEntity != null){
                    result = EntityUtils.toString(resEntity,charset);
                    responseMap.put("result",result);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return responseMap;
    }

    public static Map<String, Object> doRequest(String url,Map<String ,Object> InputData,String charset,String queryType){
        Map<String,Object> responseMap = null;
        if ("GET".equals(queryType)) {
            responseMap  = doGet(url +"?"+ TypeTrantfer.MapToString(InputData), charset);
        }
        else {
            responseMap  = doPost(url,InputData, charset);
        }
        logger.info("请求返回的数据：{}",responseMap);
        return   responseMap;//JsonUtil.fromJson(result);
    }

}
