package com.mizlicai.cashier.testcase.banklist;



import com.mizlicai.eudemon.exceptions.TestException;
import com.mizlicai.eudemon.utils.FileDataFormat;
import com.mizlicai.eudemon.utils.HttpClientUtil;

import java.util.HashMap;

/**
 * Created by MaiBenBen on 2017/6/1.
 */
public class UnbindBankList_Test {
    private final static String query_type = "GET";
    private final static String url = "http://121.43.148.191:8136/bank/list?";
    private final static String datafile = "unbinded_banklist.txt";
    private HashMap<String,HashMap<String , Object>> params = new HashMap<String, HashMap<String, Object>>();
    private HashMap<String,String> resultMap = new HashMap<String, String>();

    public UnbindBankList_Test(String resRoot) throws TestException {
        this.params = new FileDataFormat().fileToMap(resRoot+datafile);
    }

    public void test_correctRequest(){
        String[] keys ={"1","2","3","4","5","6","7","8","9"};
        for(int i =0 ;i<keys.length;i++){
            HashMap<String,Object> r = (HashMap<String, Object>) HttpClientUtil.doRequest(url,params.get(keys[i]),null,query_type);
            resultMap.put(keys[i], String.valueOf(r.get("code").equals("0")));
        }
    }

    //数据缺失
    public void test_lackParams(){
        String[] keys ={"10","11","12"};
        for(int i =0 ;i<keys.length;i++){
            HashMap<String,Object> r = (HashMap<String, Object>) HttpClientUtil.doRequest(url,params.get(keys[i]),null,query_type);
            //check判断逻辑
        }
    }

    public void test_wrongeParams(){
        String[] keys ={"13","14","15","16"};
        for(int i =0 ;i<keys.length;i++){
            HashMap<String,Object> r = (HashMap<String, Object>) HttpClientUtil.doRequest(url,params.get(keys[i]),null,query_type);
            //check判断逻辑
        }
    }

    public HashMap<String, HashMap<String, Object>> getResult(String[] keys){
        HashMap<String,HashMap<String,Object>> re = new HashMap<String, HashMap<String, Object>>();
        for(int i =0 ;i<keys.length;i++){
            HashMap<String,Object> r = (HashMap<String, Object>) HttpClientUtil.doRequest(url,params.get(keys[i]),null,query_type);
            re.put(keys[i],r);
        }
        return re;
    }

    public String getRunResult(String key){

        HashMap<String,Object> r = (HashMap<String, Object>) HttpClientUtil.doRequest(url,params.get(key),null,query_type);
        return r.get("code").toString();
    }

    public HashMap<String, HashMap<String, Object>> getParams() {
        return params;
    }

    public boolean runCase(String key){
        String result = this.getRunResult(key);
        return result.equals("0");
    }

}
