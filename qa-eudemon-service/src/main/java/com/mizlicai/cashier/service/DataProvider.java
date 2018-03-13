package com.mizlicai.cashier.service;



import com.mizlicai.eudemon.exceptions.DataException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;

/**
 * Created by penghc on 16/10/14.
 */

public class DataProvider {

    @org.testng.annotations.DataProvider
    public Object[][] getCaseByName(String caseFile){

            File f = new File(caseFile);
            BufferedReader reader = null;
            String test_data = null;
            HashMap<String,HashMap<String, String>> params = new HashMap<String, HashMap<String, String>>();
           Object[][] result= new Object[100][];
            try {
                if (!f.exists()){
                    throw new DataException("data file is not exists");
                }
                reader = new BufferedReader(new FileReader(f));
                String[] p = reader.readLine().split(",");
                int j = 0;
                while ((test_data = reader.readLine())!=null){
                    String[] datas = test_data.split(",");
                    HashMap<String,String> param = new HashMap<String, String>();

                    for(int i=1;i<datas.length;i++){
                        param.put(p[i],datas.length>=i+1?datas[i]:null);

                    }
                    params.put(datas[0],param);
                    result[j] = new Object[]{param};
                    j++;
                }

                reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return  result;
        }

}
