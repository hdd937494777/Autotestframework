package com.mizlicai.eudemon.service.impl;

import com.mizlicai.eudemon.entity.ServiceConfig;
import com.mizlicai.eudemon.entity.ServiceConfigExample;
import com.mizlicai.eudemon.mapper.ServiceConfigMapper;
import com.mizlicai.eudemon.service.ServiceConfigService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by MaiBenBen on 2017/6/2.
 */
@Service
public class ServiceConfigServiceImpl implements ServiceConfigService{

    @Autowired
    private ServiceConfigMapper configMapper;

    @Override
    public int deleteByExample(ServiceConfigExample example) {
        return configMapper.deleteByExample(example);
    }

    @Override
    public int delete(Integer id) {
        return configMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(ServiceConfig record) {
        return configMapper.insertSelective(record);
    }

    @Override
    public int update(ServiceConfig record) {
        return configMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public ServiceConfig getServiceConfigById(Integer id) {
        return configMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<ServiceConfig> getServiceConfigByExample(ServiceConfigExample example) {
        return configMapper.selectByExample(example);
    }

    @Override
    public ServiceConfig getByServiceId(Integer serviceId) {
        ServiceConfigExample example = new ServiceConfigExample();
        example.createCriteria().andServiceIdEqualTo(serviceId);
        List<ServiceConfig> list = configMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)){
            return null;
        }
        return list.get(0);
    }
}
