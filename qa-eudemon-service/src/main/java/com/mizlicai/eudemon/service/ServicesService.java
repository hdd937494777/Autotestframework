package com.mizlicai.eudemon.service;

import com.mizlicai.eudemon.entity.Services;
import com.mizlicai.eudemon.entity.ServicesExample;

import java.util.List;

/**
 * Created by MaiBenBen on 2017/6/2.
 */
public interface ServicesService {

    int deleteByExample(ServicesExample example);

    int delete(Integer id);

    int insert(Services record);

    int update(Services record);

    Services getServiceById(Integer serviceId);

     List<Services> getServicesByExample(ServicesExample example);

    Services getServiceByName(String  serviceName);

}
