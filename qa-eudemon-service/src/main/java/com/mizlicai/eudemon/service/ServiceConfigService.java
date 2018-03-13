package com.mizlicai.eudemon.service;

import com.mizlicai.eudemon.entity.ServiceConfig;
import com.mizlicai.eudemon.entity.ServiceConfigExample;

import java.util.List;

/**
 * Created by MaiBenBen on 2017/6/2.
 */
public interface ServiceConfigService {
    int deleteByExample(ServiceConfigExample example);

    int delete(Integer id);

    int insert(ServiceConfig record);

    int update(ServiceConfig record);

    ServiceConfig getServiceConfigById(Integer id);

    List<ServiceConfig> getServiceConfigByExample(ServiceConfigExample example);

    ServiceConfig getByServiceId(Integer serviceId);

}
