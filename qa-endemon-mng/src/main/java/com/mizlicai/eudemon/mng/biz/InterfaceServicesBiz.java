package com.mizlicai.eudemon.mng.biz;

import com.github.pagehelper.PageInfo;
import com.mizlicai.eudemon.entity.ErrorRequest;
import com.mizlicai.eudemon.entity.RequestQueue;
import com.mizlicai.eudemon.entity.Services;
import com.mizlicai.eudemon.exceptions.TestException;

/**
 * Created by huangyt on 2017/6/7.
 */
public interface InterfaceServicesBiz {

    PageInfo<Services> getServicePage(int pageNum,int pageSize, Services services);

    boolean insertService(Services services);

    Services getService(Integer id);

    boolean updateService(Services services);

    boolean deleteService(Integer id);


    PageInfo<RequestQueue> getRequestPage(int pageNum, int pageSize);

    PageInfo<ErrorRequest> getErrorRequestPage(int pageNum, int pageSize,String serviceId);

    boolean deleteRequest(Integer id);


    boolean deleteErrorRequest(Integer id);


    void interfaceTest(Integer id) throws TestException;

    long exceptionCounts();

    long interfaceCounts();

    long serviceCount();

    long errorServiceCount();
}
