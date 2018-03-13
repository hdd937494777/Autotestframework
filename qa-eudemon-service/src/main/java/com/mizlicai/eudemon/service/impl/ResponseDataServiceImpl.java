package com.mizlicai.eudemon.service.impl;

import com.mizlicai.eudemon.entity.ResponseData;
import com.mizlicai.eudemon.entity.ResponseDataExample;
import com.mizlicai.eudemon.mapper.ResponseDataMapper;
import com.mizlicai.eudemon.service.ResponseDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by MaiBenBen on 2017/6/2.
 */
@Service
public class ResponseDataServiceImpl  implements ResponseDataService{

    @Autowired
    private ResponseDataMapper dataMapper;

    @Override
    public int deleteByExample(ResponseDataExample example) {
        return dataMapper.deleteByExample(example);
    }

    @Override
    public int delete(Integer id) {
        return dataMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(ResponseData record) {
        return dataMapper.insertSelective(record);
    }

    @Override
    public int update(ResponseData record) {
        return dataMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public ResponseData getResponseDataById(Integer id) {
        return dataMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<ResponseData> getResponseDataByExample(ResponseDataExample example) {
        return dataMapper.selectByExample(example);
    }

    @Override
    public List<ResponseData> getByServiceId(Integer serviceId) {
        ResponseDataExample example = new ResponseDataExample();
        example.createCriteria().andServiceIdEqualTo(serviceId.toString());
        return dataMapper.selectByExample(example);
    }
}
