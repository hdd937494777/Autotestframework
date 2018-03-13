package com.mizlicai.eudemon.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by penghc on 16/10/12.
 */
public class TypeTrantfer {

    public static String MapToString(Map<String, Object> params){
        String result = "";
        for(Map.Entry<String, Object> entry : params.entrySet()){
            if(entry.getValue()!=null && !entry.getValue().equals("null")) {
                result = result + entry.getKey() + "=" + entry.getValue() + "&";
            }
        }
        result=(result=="")?result:result.substring(0,result.length()-1);
        return result;
    }


}
