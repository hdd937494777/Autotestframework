package com.mizlicai.cashier.testcase.pay;


import com.mizlicai.eudemon.exceptions.TestException;
import com.mizlicai.eudemon.framework.BaseInterface;
import com.mizlicai.eudemon.utils.FileDataFormat;

import java.util.HashMap;

/**
 * Created by penghc on 16/10/28.
 */
public class NeedChecked implements BaseInterface {
    private final static String query_type = "GET";
    private final static String url = "https://121.43.148.191:8443/cashier-project-web/bank/list.json?";
    private final static String datafile = "banklist.txt";
    private HashMap<String,HashMap<String , Object>> params = new HashMap<String, HashMap<String, Object>>();
    private HashMap<String,String> resultMap = new HashMap<String, String>();
    public NeedChecked(String resRoot) throws TestException {
        this.params = new FileDataFormat().fileToMap(resRoot+datafile);
    }

    public HashMap<String, HashMap<String, Object>> getResult(String[] keys) {
        return null;
    }

    public String getRunResult(String key) {
        return null;
    }

    public HashMap<String, HashMap<String, Object>> getParams() {
        return null;
    }

    public boolean runCase(String key) {
        return false;
    }
}
