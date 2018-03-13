package com.mizlicai.eudemon.utils;

import com.mizlicai.eudemon.exceptions.DataException;
import com.mizlicai.eudemon.exceptions.TestException;
import com.mizlicai.eudemon.exceptions.TestExceptionCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.HashMap;

/**
 * Created by penghc on 16/10/12.
 */
public class FileDataFormat {

    private  static  Logger logger = LoggerFactory.getLogger(FileDataFormat.class);

    public static HashMap<String,HashMap<String, Object>> fileToMap(String fileName) throws TestException {

        File f = new File(fileName);
        BufferedReader reader = null;
        String test_data = null;
        HashMap<String,HashMap<String, Object>> params = new HashMap<String, HashMap<String, Object>>();
        try {
            if (!f.exists()){
                throw new DataException("data file is not exists");
            }
            InputStreamReader isr = new InputStreamReader(new FileInputStream(f), "UTF-8");
            reader = new BufferedReader(isr);

            String[] p = reader.readLine().split(",");

            while ((test_data = reader.readLine())!=null){
                String[] datas = test_data.split(",");
                HashMap<String,Object> param = new HashMap<String, Object>();
                for(int i=1;i<datas.length;i++){
                    param.put(p[i],datas.length>=i+1 ? datas[i] : null);
                }
                params.put(datas[0],param);
            }

            reader.close();
        } catch (Exception e) {
            logger.error("读取文件异常",e);
            throw  new TestException(TestExceptionCode.SYSTEM_ERROR);
        }
    return  params;
  }

  public static void main(String []args) throws TestException {

      HashMap<String,HashMap<String, Object>> params = FileDataFormat.fileToMap("E:\\test-doc\\auth-init-request.txt");
      System.out.print(params.size());
  }

}
