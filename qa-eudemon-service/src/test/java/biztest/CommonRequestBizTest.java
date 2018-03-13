package biztest;

import com.mizlicai.eudemon.biz.CommonRequestBiz;
import com.mizlicai.eudemon.entity.ServicesExample;
import com.mizlicai.eudemon.exceptions.TestException;
import dbtest.BaseSpringContextTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by huangyt on 2017/6/5.
 */
public class CommonRequestBizTest extends BaseSpringContextTest{

    @Autowired
    private CommonRequestBiz commonRequestBiz;

    @Test
    public  void test() throws TestException {
        ServicesExample example = new ServicesExample();
        example.createCriteria().andIdEqualTo(1);
        commonRequestBiz.commonQuest(example);
    }
}
