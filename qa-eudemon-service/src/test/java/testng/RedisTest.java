package testng;

import com.alibaba.fastjson.JSONObject;
import com.mizlicai.cashier.data.RequestInfoBo;
import com.mizlicai.cashier.enums.OperationType;
import com.mizlicai.cashier.enums.RedisKeysType;
import com.mizlicai.eudemon.utils.CSVDataProvider;
import com.mizlicai.eudemon.utils.DesUtil;
import com.mizlicai.eudemon.utils.TokenHelp;
import dbtest.BaseSpringContextTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by MaiBenBen on 2017/6/1.
 */
public class RedisTest extends BaseSpringContextTest {

    @Resource
    private CSVDataProvider.RedisOperaHelper redisOperaHelper;
    @Autowired
    private TokenHelp tokenHelp;

    @Test
    public void test() throws Exception {
        RequestInfoBo bo = new RequestInfoBo();
        bo.setRequestId("111111111111111");
        bo.setMerchantAccount("004306b3f1a2b646e9");
        bo.setBuyerUserId(65564L);
        bo.setMobile("15757116309");
        bo.setUserName("黄玉婷");
        bo.setCertNo("520121199308192820");
        bo.setPlatform("h5");
        bo.setOutOrderNo("123456789");
        bo.setTradeAmount(100000L);
        bo.setOutOrderCreateDate(new Date());
        bo.setProductName("米财");
        bo.setProductType("micai");
        bo.setAmountEditable(false);
        bo.setType(OperationType.PAY);
        bo.setNotifyUrl("http://localhost:8136/.json");
        bo.setReturnUrl("http://localhost:8136/.json");
        bo.setToken("60f66bef1ba0468d85876e08ccbd9e4a");
        bo.setIp("123.0.0.3");
        String token = tokenHelp.createToken(bo.getRequestId());
        System.out.println(token);
        bo.setToken(token);
        redisOperaHelper.set(RedisKeysType.CASHIER_REQUEST_CONTEXT, "1111111111111117", JSONObject.toJSONString(bo));


        String cipher = DesUtil.encrypt(JSONObject.toJSONString(bo));


/*
        String json = redisOperaHelper.get(RedisKeysType.CASHIER_REQUEST_CONTEXT, "1111111111111115");
        RequestInfoBo requestInfo = JSONObject.parseObject(json, RequestInfoBo.class);
        System.out.println(json);
        System.out.println(requestInfo);*/

    }
}
