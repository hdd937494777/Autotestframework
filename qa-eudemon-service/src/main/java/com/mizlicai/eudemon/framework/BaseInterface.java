package com.mizlicai.eudemon.framework;


import java.util.HashMap;

/**
 * Created by penghc on 16/10/25.
 */
public interface BaseInterface {

    public HashMap<String, HashMap<String, Object>> getResult(String[] keys);
    public String getRunResult(String key);
    public HashMap<String, HashMap<String, Object>> getParams();
    public boolean runCase(String key);

}
