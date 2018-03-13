package com.mizlicai.eudemon.mng.service.impl;

import com.mizlicai.eudemon.mng.entity.MemberRole;
import com.mizlicai.eudemon.mng.entity.MemberRoleExample;
import com.mizlicai.eudemon.mng.entity.MessageRoleSetting;
import com.mizlicai.eudemon.mng.entity.MessageRoleSettingExample;
import com.mizlicai.eudemon.mng.mapper.MemberRoleMapper;
import com.mizlicai.eudemon.mng.mapper.MessageRoleSettingMapper;
import com.mizlicai.eudemon.mng.service.MessageRoleSettingService;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by huangyt on 2017/6/7.
 */
@Service
public class MessageRoleSettingServiceImpl implements MessageRoleSettingService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MessageRoleSettingMapper mRoleSettingMapper;

    @Autowired
    private MemberRoleMapper memberRoleMapper;

    @Override
    @Transactional(readOnly=false,rollbackFor=Exception.class)
    public boolean insertMessageRoleSetting(String traceId,MessageRoleSetting setting) {
        // TODO Auto-generated method stub
        logger.info(String.format("[5000 信程卡消息通知 角色 接收消息通知设定 插入记录 {traceId=%s}]", traceId));
        return mRoleSettingMapper.insertSelective(setting) > 0 ?true : false;

    }

    @Override
    @Transactional(readOnly=false,rollbackFor=Exception.class)
    public boolean updateMessageRoleSettingById(String traceId,
                                                MessageRoleSetting setting) {
        // TODO Auto-generated method stub
        logger.info(String.format("[5000 信程卡消息通知 角色 接收消息通知设定 更新记录 {traceId=%s}]", traceId));

        return mRoleSettingMapper.updateByPrimaryKey(setting) > 0?true : false;
    }

    @Override
    public MessageRoleSetting selectSettingByRoleId(String traceId,
                                                    String roleId) {
        logger.info(String.format("[5000 信程卡消息通知 角色 接收消息通知设定 根据roleId 查询记录 {traceId=%s，roleId=%s}]", traceId,roleId));

        MessageRoleSettingExample example = new MessageRoleSettingExample();
        example.createCriteria().andRoleIdEqualTo(roleId);

        List<MessageRoleSetting> settings = mRoleSettingMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(settings)) return null;

        return settings.get(0);
    }

    @Override
    @Transactional(readOnly=false,rollbackFor=Exception.class)
    public boolean deleteRoleSetting(String traceId, String roleId) {
        logger.info(String.format("[5000 信程卡消息通知 角色 删除消息通知设定 根据roleId 查询记录 {traceId=%s，roleId=%s}]", traceId,roleId));

        MessageRoleSettingExample example = new MessageRoleSettingExample();
        example.createCriteria().andRoleIdEqualTo(roleId);

        return mRoleSettingMapper.deleteByExample(example) > 0 ?true : false;
    }

    @Override
    public List<MessageRoleSetting> selectRoleSettings(String traceId) {
        logger.info(String.format("[5000 信程卡消息通知 角色 接收消息通知角色列表 {traceId=%s}]", traceId));

        MessageRoleSettingExample example = new MessageRoleSettingExample();
        return mRoleSettingMapper.selectByExample(example);
    }

    @Override
    public MessageRoleSetting selectRoleSettingById(String traceId, Integer id) {
        return mRoleSettingMapper.selectByPrimaryKey(id);
    }

    @Override
    public MemberRole getMemberRoleByMemberId(String traceId, Integer memberId) {
        // TODO Auto-generated method stub
        logger.info(String.format("[5000 获取用户登录角色memberRole {traceId=%s,memberId=%d}]", traceId,memberId));

        MemberRoleExample example = new MemberRoleExample();
        example.createCriteria().andMemberIdEqualTo(memberId);

        List<MemberRole> roles = memberRoleMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(roles)) return null;

        return roles.get(0);
    }
}
