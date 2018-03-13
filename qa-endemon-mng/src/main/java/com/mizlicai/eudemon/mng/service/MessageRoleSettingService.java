package com.mizlicai.eudemon.mng.service;

import com.mizlicai.eudemon.mng.entity.MemberRole;
import com.mizlicai.eudemon.mng.entity.MessageRoleSetting;

import java.util.List;

/**
 * Created by huangyt on 2017/6/7.
 */
public interface MessageRoleSettingService {

    /**
     * 插入消息通知设置权限
     * @param setting
     * @return
     */
    boolean insertMessageRoleSetting(String traceId,MessageRoleSetting setting);

    /**
     * 更新
     * @param traceId
     * @param setting
     * @return
     */
    boolean updateMessageRoleSettingById(String traceId,MessageRoleSetting setting);

    /**
     * 根据roleId 获取角色设定的权限
     * @param traceId
     * @param roleId
     * @return
     */
    MessageRoleSetting selectSettingByRoleId(String traceId,String roleId);


    /**
     * 删除 角色消息通知权限
     * @param traceId
     * @param roleId
     * @return
     */
    boolean deleteRoleSetting(String traceId,String roleId);

    /**
     * 获取所有消息权限设置记录
     * @param traceId
     * @return
     */
    List<MessageRoleSetting> selectRoleSettings(String traceId);

    /*
     *
     */
    MessageRoleSetting selectRoleSettingById(String traceId,Integer id);

    /**
     *
     * @param traceId
     * @param memberId
     * @return
     */
    MemberRole getMemberRoleByMemberId(String traceId, Integer memberId);

}
