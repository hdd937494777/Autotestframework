package testng;

import com.mizlicai.cashier.service.CSVDataProvider;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by MaiBenBen on 2017/6/1.
 */
public class CalculatorCSVTest {
    @BeforeClass
    public void beforeClass() {
        long id = Thread.currentThread().getId();
        System.out.println("Before test-class. Thread id is: " + id);
    }
    @DataProvider(name="num", parallel = true)
    public Iterator<Object[]> Numbers() throws IOException {
        return (Iterator<Object[]>)new CSVDataProvider("add.csv");
    }
    @Test(dataProvider="num",threadPoolSize = 3, invocationCount = 10,  timeOut = 10)
    public void testAdd(Map<String, String> data){
        float num1=Float.parseFloat(data.get("n1"));
        float num2=Float.parseFloat(data.get("n2"));
        float expectedResult=Float.parseFloat(data.get("r1"));
        Float actual=num1+num2;
        Assert.assertEquals(actual, expectedResult);
    }

    @AfterClass
    public void afterClass() {
        long id = Thread.currentThread().getId();
        System.out.println("After test-class. Thread id is: " + id);
    }
}
