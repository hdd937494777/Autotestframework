package com.mizlicai.eudemon.mng.biz.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mizlicai.cashier.util.StringUtil;
import com.mizlicai.eudemon.biz.CommonRequestBiz;
import com.mizlicai.eudemon.context.AppContext;
import com.mizlicai.eudemon.entity.*;
import com.mizlicai.eudemon.exceptions.TestException;
import com.mizlicai.eudemon.mapper.ErrorRequestMapper;
import com.mizlicai.eudemon.mapper.RequestQueueMapper;
import com.mizlicai.eudemon.mapper.ServicesMapper;
import com.mizlicai.eudemon.mng.biz.InterfaceServicesBiz;
import com.mizlicai.eudemon.utils.CommUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by huangyt on 2017/6/7.
 */
@Service
public class InterfaceServicesBizImpl implements InterfaceServicesBiz {

    @Autowired
    private ServicesMapper servicesMapper;

    @Autowired
    private RequestQueueMapper requestQueueMapper;

    @Autowired
    private ErrorRequestMapper errorRequestMapper;

    @Autowired
    private CommonRequestBiz commonRequestBiz;

    @Override
    public PageInfo<Services> getServicePage(int pageNum, int pageSize ,Services services ) {
        ServicesExample example = new ServicesExample();
        ServicesExample.Criteria criteria  = example.createCriteria();
        if (StringUtils.isNotBlank(services.getIsNormal())){
            criteria.andIsNormalEqualTo(services.getIsNormal());
        }
        if (StringUtils.isNotBlank(services.getProject())){
            criteria.andProjectLike("%"+ services.getProject() + "%");
        }
        if (StringUtils.isNotBlank(services.getServiceName())){
            criteria.andServiceNameLike("%"+services.getServiceName()+"%");
        }
        example.setOrderByClause("create_time desc");
        PageHelper.startPage(pageNum,pageSize);
        List<Services> list = servicesMapper.selectByExample(example);
        PageInfo<Services> page = new PageInfo<>(list);
        return page;
    }

    @Override
    public boolean insertService(Services services) {
        services.setCreateTime(CommUtil.nowTime());
        services.setIsNormal(AppContext.YES_OR_NO.YES.name());
        return servicesMapper.insertSelective(services)>0;
    }

    @Override
    public Services getService(Integer id) {
        return servicesMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean updateService(Services services) {
        services.setUpdateTime(CommUtil.nowTime());
        return servicesMapper.updateByPrimaryKeySelective(services)>0;
    }

    @Override
    public boolean deleteService(Integer id) {
        return servicesMapper.deleteByPrimaryKey(id)>0;
    }
    @Override
    public PageInfo<RequestQueue> getRequestPage(int pageNum, int pageSize) {
        RequestQueueExample example = new RequestQueueExample();
        example.setOrderByClause("create_time desc");
        PageHelper.startPage(pageNum,pageSize);
        List<RequestQueue> list = requestQueueMapper.selectByExample(example);
        PageInfo<RequestQueue> page = new PageInfo<>(list);
        return page;
    }

    @Override
    public PageInfo<ErrorRequest> getErrorRequestPage(int pageNum, int pageSize,String  serviceId) {
        ErrorRequestExample example = new ErrorRequestExample();
        ErrorRequestExample.Criteria  criteria = example.createCriteria();
        if (StringUtils.isNotBlank(serviceId)){
            criteria.andServiceIdEqualTo(serviceId);
        }
        example.setOrderByClause("create_time desc");
        PageHelper.startPage(pageNum,pageSize);
        List<ErrorRequest> list = errorRequestMapper.selectByExample(example);
        PageInfo<ErrorRequest> page = new PageInfo<>(list);
        return page;
    }

    @Override
    public boolean deleteRequest(Integer id) {

        return requestQueueMapper.deleteByPrimaryKey(id)>0;
    }

    @Override
    public boolean deleteErrorRequest(Integer id) {

        return errorRequestMapper.deleteByPrimaryKey(id)>0;
    }

    @Override
    public void interfaceTest(Integer id) throws TestException {
        ServicesExample servicesExample = new ServicesExample();
        servicesExample.createCriteria().andIdEqualTo(id);
        commonRequestBiz.commonQuest(servicesExample);
    }

    @Override
    public long exceptionCounts() {
        ErrorRequestExample errorRequestExample = new ErrorRequestExample();
        return errorRequestMapper.countByExample(errorRequestExample);
    }

    @Override
    public long interfaceCounts() {
        RequestQueueExample example = new RequestQueueExample();
        return requestQueueMapper.countByExample(example);
    }

    @Override
    public long serviceCount() {
        ServicesExample example = new ServicesExample();

        return servicesMapper.countByExample(example);
    }

    @Override
    public long errorServiceCount() {
        ServicesExample example = new ServicesExample();
        example.createCriteria().andIsNormalEqualTo(AppContext.YES_OR_NO.NO.name());

        return servicesMapper.countByExample(example);
    }
}
