package com.mizlicai.eudemon.service;

import com.mizlicai.eudemon.entity.ErrorRequest;
import com.mizlicai.eudemon.entity.ErrorRequestExample;

import java.util.List;

/**
 * Created by huangyt on 2017/6/6.
 */
public interface ErrorRequestService {

    int deleteByExample(ErrorRequestExample example);

    int delete(Integer id);

    int insert(ErrorRequest record);

    int update(ErrorRequest record);

    List<ErrorRequest> getServiceById(Integer serviceId);

    List<ErrorRequest> getErrorRequestByExample(ErrorRequestExample example);

    List<ErrorRequest> getServiceByName(String  serviceName);
}
