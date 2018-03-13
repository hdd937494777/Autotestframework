package com.mizlicai.eudemon.mapper;

import com.mizlicai.eudemon.entity.ServiceConfig;
import com.mizlicai.eudemon.entity.ServiceConfigExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ServiceConfigMapper {
    long countByExample(ServiceConfigExample example);

    int deleteByExample(ServiceConfigExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ServiceConfig record);

    int insertSelective(ServiceConfig record);

    List<ServiceConfig> selectByExample(ServiceConfigExample example);

    ServiceConfig selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ServiceConfig record, @Param("example") ServiceConfigExample example);

    int updateByExample(@Param("record") ServiceConfig record, @Param("example") ServiceConfigExample example);

    int updateByPrimaryKeySelective(ServiceConfig record);

    int updateByPrimaryKey(ServiceConfig record);
}