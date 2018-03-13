package com.mizlicai.eudemon.service;

import com.mizlicai.eudemon.entity. RequestQueue;
import com.mizlicai.eudemon.entity. RequestQueueExample;

import java.util.List;

/**
 * Created by MaiBenBen on 2017/6/2.
 */
public interface RequestQueueService {

    int deleteByExample(RequestQueueExample example);

    int delete(Integer id);

    int insert(RequestQueue record);

    int update(RequestQueue record);

     RequestQueue getRequestQueueById(Integer id);

     List<RequestQueue> getRequestQueueByExample(RequestQueueExample example);

    List<RequestQueue>  getByServiceId(Integer ServiceId);


}
