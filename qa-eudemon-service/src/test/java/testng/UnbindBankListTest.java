package testng;

import com.mizlicai.cashier.data.XlsRowVO;
import com.mizlicai.cashier.newtestcase.NewUnbindBankList_Test;
import com.mizlicai.cashier.service.CSVDataProvider;
import com.mizlicai.eudemon.utils.ExcelUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by MaiBenBen on 2017/6/1.
 */
public class UnbindBankListTest {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    NewUnbindBankList_Test test;


    @BeforeClass
    public void beforeClass() {
         test = new NewUnbindBankList_Test();
    }

    @BeforeMethod
    public void beforeTest(){
        long id = Thread.currentThread().getId();
        logger.info("Before test-class. Thread id is:{} " , id);
    }

    @DataProvider(name="num", parallel = true)
    public Iterator<Object[]> Numbers(ITestContext testContext) throws IOException {
        return (Iterator<Object[]>)new CSVDataProvider("unbinded_banklist.txt");
    }

    @Test(dataProvider="num",invocationCount = 2,threadPoolSize = 2,timeOut = 100000)
    public void testAdd(Map<String, Object> data){
        HashMap<String,Object> r  = test.getResult(data);
        Assert.assertEquals("0000000",r.get("code"));
    }

   @AfterMethod
   public void afterTest(){
       long id = Thread.currentThread().getId();
       logger.info("After test-class. Thread id is:{} " ,id);
   }

    @AfterClass
    public void afterClass() {
        for (HashMap<String , Object> v : test.getResultParams().values()) {
            logger.info("value:{}" ,v);
        }
    }

    @Test
    public void test() throws FileNotFoundException {
        String path = "D:\\work\\openAccountRequestSms.xls";
        List<XlsRowVO> dataList = ExcelUtils.parseXls(path,0);
        System.out.println(dataList.size());
    }
}
