package com.mizlicai.eudemon.mapper;

import com.mizlicai.eudemon.entity.RequestQueue;
import com.mizlicai.eudemon.entity.RequestQueueExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RequestQueueMapper {
    long countByExample(RequestQueueExample example);

    int deleteByExample(RequestQueueExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RequestQueue record);

    int insertSelective(RequestQueue record);

    List<RequestQueue> selectByExample(RequestQueueExample example);

    RequestQueue selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RequestQueue record, @Param("example") RequestQueueExample example);

    int updateByExample(@Param("record") RequestQueue record, @Param("example") RequestQueueExample example);

    int updateByPrimaryKeySelective(RequestQueue record);

    int updateByPrimaryKey(RequestQueue record);
}