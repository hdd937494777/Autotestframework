package com.mizlicai.eudemon.utils;

import com.mizlicai.cashier.enums.RedisKeysType;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CSVDataProvider implements Iterator<Object[]> {
    BufferedReader in;
    ArrayList<String> csvList=new ArrayList<String>();
    int rowNum=0;     //行数
    int columnNum=0;  //列数
    int curRowNo=0;   //当前行数
    String columnName[];  //列名
    /**
     * 在TestNG中由@DataProvider(dataProvider = "name")修饰的方法
     * 取csv.txt文件数据时时，调用此类构造方法（此方法会得到列名并将当前行移到下以后）执行后，转发到
     * TestNG自己的方法中去，然后由它们调用此类实现的hasNext()、next()方法
     * 得到一行数据，然后返回给由@Test(dataProvider = "name")修饰的方法，如此
     * 反复到数据读完为止
     * @param fileName
     * @throws IOException
     */
    public CSVDataProvider(String fileName) throws IOException{
        String absolutePath=CSVDataProvider.class.getClassLoader().getResource("cashier").getPath()+ File.separator+fileName;
        System.out.println(absolutePath);
        File csv=new File(absolutePath);
        in=new BufferedReader(new FileReader(csv));
        while (in.ready()) {
            csvList.add(in.readLine());
            this.rowNum++;
        }
        String[] str=csvList.get(0).split(",");
        this.columnNum=str.length;
        columnName=new String[columnNum];
        //获取列名
        for (int i = 0; i < columnNum; i++) {
            columnName[i]=str[i];
        }
        this.curRowNo++;
    }
    @Override
    public boolean hasNext() {
        // TODO Auto-generated method stub
        if(rowNum==0||curRowNo>=rowNum){
            try {
                in.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return false;
        }else{
            return true;
        }
    }
    /**
     * 获取一组参数，即一行数据
     */
    @Override
    public Object[] next() {
        // TODO Auto-generated method stub
        Map<String,String> s=new TreeMap<String,String>();
        String csvCell[]=csvList.get(curRowNo).split(",");
        for(int i=0;i<this.columnNum;i++){
            s.put(columnName[i], csvCell[i]);
        }
        Object[] d=new Object[1];
        d[0]=s;
        this.curRowNo++;
        return d;
    }

    @Override
    public void remove() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("remove unsupported");
    }

    /**
     * redis缓存操作服务
     *
     * @author yueny09 <deep_blue_yang@163.com>
     * @DATE 2016年11月15日 下午4:32:05
     */
    @Component
    public static class RedisOperaHelper {


        @Resource
        private RedisTemplate<String, String> stringRedisTemplate;

        /**
         * 获取redis值
         * redis
         *
         * @param type 枚举
         * @param key  key
         * @return value
         */
        public String get(final RedisKeysType type, final String key) {
            return stringRedisTemplate.opsForValue().get(getRedisKey(type, key));
        }

        /**
         * 获取redis key
         *
         * @param type 枚举
         * @param key  key
         * @return redis key
         */
        private String getRedisKey(final RedisKeysType type, final String key) {
            final StringBuilder localKey = new StringBuilder(type.getKey());
            localKey.append(key);
            // 这个需要每天一个key 单独判断
            if (RedisKeysType.CASHIER_SMS_DAY_COUNT.equals(type)) {
                localKey.append(new Date());
            }
            return localKey.toString();
        }

        /**
         * redis设置值
         *
         * @param type  枚举
         * @param key   key
         * @param value 值
         */
        public void set(final RedisKeysType type, final String key,
                        final String value) {
            stringRedisTemplate.opsForValue().set(getRedisKey(type, key), value,
                    type.getTimeout(), type.getUnit());
        }

        /**
         * 删除 redis值
         *
         * @param type 枚举
         * @param key  key
         */
        public void delete(final RedisKeysType type, final String key) {
            stringRedisTemplate.delete(getRedisKey(type, key));
        }


        /**
         * 更新 redis值
         *
         * @param type  枚举
         * @param key   key
         * @param value 值
         */
        public void update(final RedisKeysType type, final String key,
                           final String value) {

            long timeout = stringRedisTemplate.getExpire(getRedisKey(type, key));

            stringRedisTemplate.opsForValue().set(getRedisKey(type, key), value,
                    timeout, type.getUnit());

        }
    }
}