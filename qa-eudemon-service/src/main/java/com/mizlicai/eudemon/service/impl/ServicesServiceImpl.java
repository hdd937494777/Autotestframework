package com.mizlicai.eudemon.service.impl;

/**
 * Created by MaiBenBen on 2017/6/2.
 */

import com.mizlicai.eudemon.entity.Services;
import com.mizlicai.eudemon.entity.ServicesExample;
import com.mizlicai.eudemon.mapper.ServicesMapper;
import com.mizlicai.eudemon.service.ServicesService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = false)
public class ServicesServiceImpl implements ServicesService {

    @Autowired
    private ServicesMapper servicesMapper;


    @Override
    public int deleteByExample(ServicesExample example) {
        return servicesMapper.deleteByExample(example);
    }

    @Override
    public int delete(Integer id) {
        return servicesMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Services record) {
        return servicesMapper.insertSelective(record);
    }

    @Override
    public int update(Services record) {
        return servicesMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public Services getServiceById(Integer serviceId) {
        return servicesMapper.selectByPrimaryKey(serviceId);
    }

    @Override
    public List<Services> getServicesByExample(ServicesExample example) {
        return servicesMapper.selectByExample(example);
    }

    @Override
    public Services getServiceByName(String serviceName) {
        ServicesExample servicesExample = new ServicesExample();
        servicesExample.createCriteria().andServiceNameEqualTo(serviceName);
        List<Services>  servicesList =  servicesMapper.selectByExample(servicesExample);
        if (CollectionUtils.isEmpty(servicesList)){
            return  null;
        }
        return servicesList.get(0);
    }
}
