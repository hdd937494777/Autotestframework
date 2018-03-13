package dbtest;

import com.mizlicai.eudemon.entity.ServiceConfig;
import com.mizlicai.eudemon.entity.Services;
import com.mizlicai.eudemon.service.ServiceConfigService;
import com.mizlicai.eudemon.service.ServicesService;
import com.mizlicai.eudemon.utils.CommUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by huangyt on 2017/6/5.
 */
public class ServicesTest  extends BaseSpringContextTest {

    @Autowired
    private ServicesService servicesService;

    @Autowired
    private ServiceConfigService configService;

    @Test
    public void servicesInsert(){
        Services services = new Services();
        services.setCreateTime(CommUtil.nowTime());
        services.setUpdateTime(CommUtil.nowTime());
        services.setRequestUrl("http://121.43.148.191:8136/bank/list");
        services.setRequestType("GET");
        services.setRequestUrl("F:\\unbinded_banklist.txt");
        services.setDescription("查询银行卡列表");
        services.setNeedParameter("Y");
        services.setOperatorId("1");
        services.setOperatorName("黄玉婷");
        services.setProject("收银台");
        services.setServiceName("银行卡列表");
        servicesService.insert(services);
    }


    @Test
    public void configServiceInsert(){
        ServiceConfig config = new ServiceConfig();
        config.setCreateTime(CommUtil.nowTime());
        config.setConcurrentCount(1);
        config.setServiceId(1);
        config.setTimeOut(10);
        configService.insert(config);
    }

    @Test
    public void test(){
        ServiceConfig config = new ServiceConfig();
        config.setCreateTime(CommUtil.nowTime());
        config.setConcurrentCount(1);
        config.setServiceId(1);
        config.setTimeOut(10);
        configService.insert(config);
    }

}
