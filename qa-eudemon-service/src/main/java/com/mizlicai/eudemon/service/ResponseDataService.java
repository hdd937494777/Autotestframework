package com.mizlicai.eudemon.service;

import com.mizlicai.eudemon.entity.ResponseData;
import com.mizlicai.eudemon.entity.ResponseDataExample;

import java.util.List;

/**
 * Created by MaiBenBen on 2017/6/2.
 */
public interface ResponseDataService {
    
    int deleteByExample(ResponseDataExample example);

    int delete(Integer id);

    int insert(ResponseData record);

    int update(ResponseData record);

    ResponseData getResponseDataById(Integer id);

    List<ResponseData> getResponseDataByExample(ResponseDataExample example);

    List<ResponseData>  getByServiceId(Integer ServiceId);

}
