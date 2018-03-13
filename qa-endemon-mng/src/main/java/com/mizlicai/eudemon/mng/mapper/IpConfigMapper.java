package com.mizlicai.eudemon.mng.mapper;

import com.mizlicai.eudemon.mng.entity.IpConfig;
import com.mizlicai.eudemon.mng.entity.IpConfigExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IpConfigMapper {
    Long countByExample(IpConfigExample example);

    int deleteByExample(IpConfigExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(IpConfig record);

    int insertSelective(IpConfig record);

    List<IpConfig> selectByExample(IpConfigExample example);

    IpConfig selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") IpConfig record, @Param("example") IpConfigExample example);

    int updateByExample(@Param("record") IpConfig record, @Param("example") IpConfigExample example);

    int updateByPrimaryKeySelective(IpConfig record);

    int updateByPrimaryKey(IpConfig record);
}