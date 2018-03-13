package com.mizlicai.eudemon.mng.mapper;

import com.mizlicai.eudemon.mng.entity.SysSetting;
import com.mizlicai.eudemon.mng.entity.SysSettingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysSettingMapper {
    long countByExample(SysSettingExample example);

    int deleteByExample(SysSettingExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysSetting record);

    int insertSelective(SysSetting record);

    List<SysSetting> selectByExample(SysSettingExample example);

    SysSetting selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysSetting record, @Param("example") SysSettingExample example);

    int updateByExample(@Param("record") SysSetting record, @Param("example") SysSettingExample example);

    int updateByPrimaryKeySelective(SysSetting record);

    int updateByPrimaryKey(SysSetting record);
}