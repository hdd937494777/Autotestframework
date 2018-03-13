package com.mizlicai.eudemon.mng.service.impl;

import com.mizlicai.eudemon.mng.entity.IpConfig;
import com.mizlicai.eudemon.mng.entity.IpConfigExample;
import com.mizlicai.eudemon.mng.mapper.IpConfigMapper;
import com.mizlicai.eudemon.mng.service.IpConfigService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by chars on 2015 下午2:49:48.
 * <p/>
 * Copyright © mizhuanglicai
 */
@Service
public class IpConfigServiceImpl implements IpConfigService {

    @Resource
    private IpConfigMapper ipConfigMapper;

    @Override
    public boolean findByIp(String ip) {
        IpConfigExample example = new IpConfigExample();

        example.createCriteria().andIpEqualTo(ip);

        long count=  ipConfigMapper.countByExample(example);
        if(count == 0) return false;
        else if(count > 0) return true;
        else return false;
    }

    @Override
    public boolean deleteByName(String name) {
        IpConfigExample example = new IpConfigExample();

        example.createCriteria().andNameEqualTo(name);
        return ipConfigMapper.deleteByExample(example) > 0;
    }

    @Override
    public boolean addIpConfig(String remoteAddr, String name) {
        IpConfig ipConfig = new IpConfig();
        ipConfig.setIp(remoteAddr);
        ipConfig.setName(name);

        return ipConfigMapper.insert(ipConfig) > 0;
    }

}
