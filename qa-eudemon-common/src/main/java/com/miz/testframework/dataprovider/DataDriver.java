package com.miz.testframework.dataprovider;


import com.miz.testframework.config.PropertyConfig;
import com.miz.testframework.util.StringUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Iterator;


/**
 * 数据驱动类
 * 
 */
public class DataDriver extends AbstractTestNGSpringContextTests{

	private static final Log log = LogFactory.getLog(DataDriver.class);


	@BeforeClass
	protected void setUp() throws Exception {
		PropertyConfig.initDBConfigs();
	}

	@DataProvider(name = "CsvDataProvider")
	public Iterator<?> getDataProvider(Method method) throws IOException {
		return getDataProvider(method.getDeclaringClass(), method);
	}


	public Iterator<?> getDataProvider(Class<?> cls, Method method) throws IOException {
		String className = cls.getSimpleName();
		String dirPlusPrefix = "";
		String[] testresDir = null;
		String fileName = "";
		String filePath = "";

		String firstDir = "testers";

		if (className.indexOf("NormalTest") != -1) {
			dirPlusPrefix = firstDir + "/normal/";
			testresDir = className.split("NormalTest");
		} else if (className.indexOf("FuncExceptionTest") != -1) {
			dirPlusPrefix = firstDir + "/funcExp/";
			testresDir = className.split("FuncExceptionTest");
		}
		fileName = className + "." + method.getName() + ".csv";

		if (null != testresDir && StringUtil.isNotBlank(testresDir[0])) {
			filePath = dirPlusPrefix + testresDir[0] + "/" + fileName;
		}

		System.out.println("测试驱动数据: " + filePath);

		return new DriverDataProvider(cls, method, filePath);
	}


}
