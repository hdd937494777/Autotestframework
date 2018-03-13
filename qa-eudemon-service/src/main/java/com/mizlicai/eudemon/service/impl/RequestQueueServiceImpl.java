package com.mizlicai.eudemon.service.impl;

import com.mizlicai.eudemon.entity.RequestQueue;
import com.mizlicai.eudemon.entity.RequestQueueExample;
import com.mizlicai.eudemon.mapper.RequestQueueMapper;
import com.mizlicai.eudemon.service.RequestQueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by MaiBenBen on 2017/6/2.
 */
@Service
public class RequestQueueServiceImpl implements RequestQueueService {
    @Autowired
    private RequestQueueMapper queueMapper;

    @Override
    public int deleteByExample(RequestQueueExample example) {
        return queueMapper.deleteByExample(example);
    }

    @Override
    public int delete(Integer id) {
        return queueMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(RequestQueue record) {
        return queueMapper.insertSelective(record);
    }

    @Override
    public int update(RequestQueue record) {
        return queueMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public RequestQueue getRequestQueueById(Integer id) {
        return queueMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<RequestQueue> getRequestQueueByExample(RequestQueueExample example) {
        return queueMapper.selectByExample(example);
    }

    @Override
    public List<RequestQueue> getByServiceId(Integer serviceId) {
        RequestQueueExample example = new RequestQueueExample();
        example.createCriteria().andServiceIdEqualTo(serviceId);
        return queueMapper.selectByExample(example);
    }
}
