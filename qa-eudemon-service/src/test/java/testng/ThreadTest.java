package testng;

import com.mizlicai.cashier.testcase.banklist.UnbindBankList_Test;
import com.mizlicai.eudemon.exceptions.TestException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;

/**
 * Created by MaiBenBen on 2017/6/1.
 */
public class ThreadTest {
    @BeforeClass
    public void beforeClass() {
        long id = Thread.currentThread().getId();
        System.out.println("Before test-class. Thread id is: " + id);
    }

    @Test(invocationCount = 10,threadPoolSize = 2)
    public void test() throws TestException {
            String[] keys = new String[1];
            keys[0]="1";
            UnbindBankList_Test auth_test = new UnbindBankList_Test(UnbindBankList_Test.class.getClassLoader().getResource("cashier").getPath()+ File.separator);
            auth_test.getResult(keys);
    }
    @AfterClass
    public void afterClass() {
        long id = Thread.currentThread().getId();
        System.out.println("After test-class. Thread id is: " + id);
    }
}
