package com.miz.testframework.dataprovider;


import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import au.com.bytecode.opencsv.CSVReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.Iterator;

/**
 * 数据驱动Provider
 * 
 * Create at：2017年7月12日 下午10:38:08
 * 
 * @author chuwenjun
 */
public class DriverDataProvider
        implements Iterator<Object[]>
{
    CSVReader reader = null;
    private Class<?>[] parameterTypes;
    private Converter[] parameterConverters;
    public int sum = 0;

    private static final Log log = LogFactory.getLog(DriverDataProvider.class);

    private String[] last;

    public DriverDataProvider(Class<?> cls, Method method, String csvFilePath) throws UnsupportedEncodingException
    {
        InputStream is = null;
        is = cls.getClassLoader().getResourceAsStream(csvFilePath);
        try {
            InputStreamReader isr = new InputStreamReader(is,"UTF-8");
            this.reader = new CSVReader(isr, ',', '"', 1);
            this.parameterTypes = method.getParameterTypes();
            int len = this.parameterTypes.length;
            this.parameterConverters = new Converter[len];
            for (int i = 0; i < len; i++)
                this.parameterConverters[i] = ConvertUtils.lookup(this.parameterTypes[i]);

        }
        catch (RuntimeException e) {
            log.error(e);
            log.error(cls.getName() + "." + method.getName() + " TestData is not exist!");
        }

    }

    public boolean hasNext()
    {
        try
        {
            if (this.reader == null) {
                return false;
            }
            this.last = this.reader.readNext();
        }
        catch (IOException e)
        {
            log.error("Read row data error!");
        }
        return this.last != null;
    }

    private String[] getNextLine()
    {
        if (this.last == null) {
            try {
                this.last = this.reader.readNext();
            } catch (IOException ioe) {
                log.error("get next line error!");
                throw new RuntimeException(ioe);
            }
        }
        return this.last;
    }

    public Object[] next()
    {
        String[] next;
        if (this.last != null)
            next = this.last;
        else {
            next = getNextLine();
        }
        this.last = null;
        Object[] args = parseLine(next);
        return args;
    }

    private Object[] parseLine(String[] svals)
    {
        if (svals.length != this.parameterTypes.length) {
            log.error("驱动数据个数 [" + svals.length + "] 与参数个数 [" + this.parameterTypes.length + "] 不相等 , " + svals[0]);

            return null;
        }

        int len = svals.length;
        Object[] result = new Object[len];
        log.info("=============== START [" + svals[0] + "] ===============");
        log.debug("======> 测试数据 用例ID [" + svals[0] + "] <======");

        for (int i = 0; i < len; i++)
        {
            String curSval = svals[i];


            result[i] = this.parameterConverters[i].convert(this.parameterTypes[i], curSval);
            log.debug(result[i]);
        }
        return result;
    }
}