package com.mizlicai.cashier.testcase.auth;



import com.mizlicai.eudemon.exceptions.TestException;
import com.mizlicai.eudemon.framework.BaseInterface;
import com.mizlicai.eudemon.utils.FileDataFormat;
import com.mizlicai.eudemon.utils.HttpClientUtil;

import java.io.File;
import java.util.HashMap;

/**
 * Created by penghc on 16/10/11.
 */
public class Auth_Test implements BaseInterface {
    private final static String query_type = "POST";
    private final static String url = "https://121.43.148.191:8443/cashier-project-web/auth/auth.json?";
    private final static String datafile = "auth.txt";
    private HashMap<String,HashMap<String , Object>> params = new HashMap<String, HashMap<String, Object>>();
    private HashMap<String,String> resultMap = new HashMap<String, String>();

    public Auth_Test(String resRoot) throws TestException {
        this.params = new FileDataFormat().fileToMap(resRoot+datafile);
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
