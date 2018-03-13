package ${classEntity.scriptPackage};
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

import ${classEntity.className};
import ${classEntity.returnType};

<#list classEntity.requestParameters as parameterName>
import  ${parameterName};
</#list>
import com.miz.autotest.base.AutoBaseTest;
import com.miz.testframework.database.DBcheckUtil;
import com.miz.testframework.objckeck.ObjectCheckUtil;
import com.miz.testframework.util.CSVUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

/**
* Created by huangyt on ${.now}
*/
public class ${classEntity.scriptClassName} extends AutoBaseTest{

    protected static Logger logger = Logger.getLogger(${classEntity.scriptClassName}.class);

	@Autowired
	private ${classEntity.shortClassName} ${classEntity.shortClassName};

	@Autowired
	private ${classEntity.shortRequestName}Mapper ${classEntity.shortRequestName}Mapper;



	@Test(dataProvider = "CsvDataProvider", description = "")
	public void ${classEntity.methodName}(final String caseId, final String description,<#list classEntity.methodParameter as parameter> ${parameter.type}  ${parameter.name}, </#list> ) {
		//请求对象设置
		Object request1 = CSVUtil.requestfromCSV(reqfile,${classEntity.shortRequestName},0);
       ${classEntity.shortRequestName} request = (${classEntity.shortRequestName})request1;



		//数据准备
		String condition = null;
		String table=null;
		this.deleteDB(table,condition);
		this.insertDB(dbfile,${classEntity.shortRequestName}Mapper);


		try {
			//方法执行
			${classEntity.shortReturnType} response = ${classEntity.shortClassName}.${classEntity.methodName}(request);

			//结果校验
			Assert.assertTrue(ObjectCheckUtil.check(responsefile,response,0),"返回结果检验失败");
			Assert.assertTrue(DBcheckUtil.DBCheckWithoutCondition(dbcheckfile,1),"DB结果校验失败");

		}catch (Exception e){
			logger.error(e.getMessage());
			Assert.assertTrue(false);
		}finally {
			//数据清理
			this.deleteDB(table,condition);

	}

	}
}
