package com.mizlicai.eudemon.service.impl;

import com.mizlicai.eudemon.entity.ErrorRequest;
import com.mizlicai.eudemon.entity.ErrorRequestExample;
import com.mizlicai.eudemon.mapper.ErrorRequestMapper;
import com.mizlicai.eudemon.service.ErrorRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by huangyt on 2017/6/6.
 */
@Service
public class ErrorRequestServiceImpl implements ErrorRequestService {

    @Autowired
    private ErrorRequestMapper errorRequestMapper;

    @Override
    public int deleteByExample(ErrorRequestExample example) {
        return errorRequestMapper.deleteByExample(example);
    }

    @Override
    public int delete(Integer id) {
        return errorRequestMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(ErrorRequest record) {
        return errorRequestMapper.insertSelective(record);
    }

    @Override
    public int update(ErrorRequest record) {

        return errorRequestMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<ErrorRequest> getServiceById(Integer serviceId) {
        ErrorRequestExample example = new ErrorRequestExample();
        example.createCriteria().andServiceIdEqualTo(serviceId.toString());
        return errorRequestMapper.selectByExample(example);
    }

    @Override
    public List<ErrorRequest> getErrorRequestByExample(ErrorRequestExample example) {
        return errorRequestMapper.selectByExample(example);
    }

    @Override
    public List<ErrorRequest> getServiceByName(String serviceName) {
        ErrorRequestExample example = new ErrorRequestExample();
        example.createCriteria().andServiceIdEqualTo(serviceName);
        return errorRequestMapper.selectByExample(example);
    }
}
