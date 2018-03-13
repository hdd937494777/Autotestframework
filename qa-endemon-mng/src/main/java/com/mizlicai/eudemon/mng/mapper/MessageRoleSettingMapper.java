package com.mizlicai.eudemon.mng.mapper;

import com.mizlicai.eudemon.mng.entity.MessageRoleSetting;
import com.mizlicai.eudemon.mng.entity.MessageRoleSettingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MessageRoleSettingMapper {
    long countByExample(MessageRoleSettingExample example);

    int deleteByExample(MessageRoleSettingExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MessageRoleSetting record);

    int insertSelective(MessageRoleSetting record);

    List<MessageRoleSetting> selectByExample(MessageRoleSettingExample example);

    MessageRoleSetting selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MessageRoleSetting record, @Param("example") MessageRoleSettingExample example);

    int updateByExample(@Param("record") MessageRoleSetting record, @Param("example") MessageRoleSettingExample example);

    int updateByPrimaryKeySelective(MessageRoleSetting record);

    int updateByPrimaryKey(MessageRoleSetting record);
}