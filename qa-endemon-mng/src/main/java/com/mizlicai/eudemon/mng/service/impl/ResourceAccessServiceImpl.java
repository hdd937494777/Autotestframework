package com.mizlicai.eudemon.mng.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mizlicai.eudemon.mng.context.ManagerContext;
import com.mizlicai.eudemon.mng.entity.*;
import com.mizlicai.eudemon.mng.exception.BusinessExceptionCode;
import com.mizlicai.eudemon.mng.mapper.*;
import com.mizlicai.eudemon.mng.service.ResourceAccessService;
import com.mizlicai.eudemon.mng.utils.Md5Util;
import com.mizlicai.eudemon.mng.utils.ModelHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by huangyt on 2017/6/7.
 */
@Service
public class ResourceAccessServiceImpl implements ResourceAccessService {

//    private static final Log logger = LogFactory.getLog(ResourceAccessServiceImpl.class);

    @Resource
    private MemberMapper memberMapper;

    @Resource
    private MemberRoleMapper memberRoleMapper;

    @Resource
    private ResourceRoleMapper resourceRoleMapper;

    @Resource
    private RoleManagerMapper roleManagerMapper;

    @Resource
    private ResourceUrlMapper resourceUrlMapper;

//    @Resource
//	private SmsService smsApiService;


    @Override
    public boolean certifyCode(String code, String username, HttpSession session, Model model) {
        if (StringUtils.isEmpty(code)) {
            ModelHelper.addValidateInfo(model,
                    BusinessExceptionCode.EXCEPTION_1021);
            return false;
        }
        Member member = findMemberByName(username);
        if (member == null) {
            ModelHelper.addValidateInfo(model,
                    BusinessExceptionCode.EXCEPTION_20002);
            return false;
        }

        if (StringUtils.isEmpty(member.getMobile())) {
            ModelHelper.addValidateInfo(model,
                    BusinessExceptionCode.EXCEPTION_50000);
            return false;
        }

        String identifyingCode = (String) session.getAttribute(member.getMobile());
        if (!code.equals(identifyingCode)) {
            ModelHelper.addValidateInfo(model,
                    BusinessExceptionCode.EXCEPTION_1022);
            return false;
        }

        return true;
    }

    /**
     * 发送短信验证码
     *
     * @param username 用户名
     * @param session  会话
     * @param model    model
     */
    @Override
    public String sendCode(String username, String password, HttpSession session, Model model) {
//        Member member = findMemberByName(username);
//        if (member == null){
//            return BusinessExceptionCode.EXCEPTION_20002.getDescription();
//        }
//
//        if (StringUtils.isEmpty(password) || !member.getPassword().equals(Encryption.encrypt(password))) {
//        	return BusinessExceptionCode.EXCEPTION_20001.getDescription();
//        }
//
//        if (StringUtils.isEmpty(member.getMobile())){
//            return BusinessExceptionCode.EXCEPTION_50000.getDescription();
//        }
//
//        StringBuilder sb = new StringBuilder();
//        Random random = new Random();
//        for (int i = 0; i < 4; i++) {
//            sb.append(String.valueOf(random.nextInt(10)));
//        }
//
//        final String identifyingCode = sb.toString();
//
//        SMS sms = new SMS();
//        sms.setMobile(member.getMobile());
//        String message = SmsTemplate.getSmsContent(
//                SmsTemplate.Type.REGISTER, identifyingCode);
//        sms.setMessage(message);
//        sms.setCode(identifyingCode);
//        sms.setType(SmsTemplate.Type.REGISTER.toString());
//
//		smsApiService.sendSms(sms.getMobile(), sms.getMessage(), SmsChannelSetting.SMSCHANNEL_AIXUEDAI);
//        session.setAttribute(member.getMobile(), identifyingCode);
        return "";
    }

    @Override
    public Member findMemberByName(String name) {
        MemberExample example = new MemberExample();
        example.createCriteria().andNameEqualTo(name);
        List<Member> list = memberMapper.selectByExample(example);
        return list != null && list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public Member findMemberByNameStatus(String name) {
        MemberExample example = new MemberExample();
        example.createCriteria().andNameEqualTo(name).andStatusEqualTo(ManagerContext.MemberStatus.OPEN.name());
        List<Member> list = memberMapper.selectByExample(example);
        return list != null && list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public boolean isEnoughPermissionsToLogin(Member member, String resourceUrl) {
        if (member == null) {
            return false;
        }

        List<MemberRole> list = listMemberRoleByMemberId(member.getId());

        for (MemberRole memberRole : list) {
            List<ResourceUrl> resourceUrls = listResourceUrlByRoleId(memberRole.getRoleId());

            for (ResourceUrl permission : resourceUrls) {

                if (permission.getValue().equals(resourceUrl) || permission.getValue().equals("allpermissions")) {
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public boolean isEnoughPermissions(Member member, String resourceUrl) {
        if (member == null) {
            return false;
        }
        //判断资源是否入库
        boolean flag = areStorage(resourceUrl);
        if (!flag) { //如果没有入库直接返回
            return true;
        }

        List<MemberRole> list = listMemberRoleByMemberId(member.getId());

        for (MemberRole memberRole : list) {
            //每一个角色的权限
            List<ResourceUrl> resourceUrls = listResourceUrlByRoleId(memberRole.getRoleId());

            for (ResourceUrl permission : resourceUrls) {

                //如果是已经入库
                if (resourceUrl.contains(permission.getValue()) || permission.getValue().equals("allpermissions")) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * 判断资源是否入库
     */
    @Override
    public boolean areStorage(String resourceUrl) {
        ResourceUrlExample example = new ResourceUrlExample();
        example.createCriteria().andValueEqualTo(resourceUrl);
        List<ResourceUrl> list = resourceUrlMapper.selectByExample(example);
        return list != null && list.size() > 0;
    }

    /**
     * 判断当不存在这条资源时，添加
     */
    @Override
    public void addNewResourceUrl(String url) {
        if (!StringUtils.isEmpty(url) && findResourceUrlByValue(url) == null) {
            ResourceUrl resourceUrl = new ResourceUrl();
            resourceUrl.setModifyDate(new Date());
            resourceUrl.setCreateDate(new Date());
            resourceUrl.setValue(url);
            resourceUrl.setValueName("待命名资源");
            insertResourceUrl(resourceUrl);
        }
    }

    /**
     * 根据url值查询实体
     */
    @Override
    public ResourceUrl findResourceUrlByValue(String url) {
        ResourceUrlExample example = new ResourceUrlExample();
        example.createCriteria().andValueEqualTo(url);
        List<ResourceUrl> list = resourceUrlMapper.selectByExample(example);
        return list != null && list.size() > 0 ? list.get(0) : null;
    }

    /**
     * 成员列表
     */
    @Override
    public PageInfo<Member> listMember(int pageNum, int pageSize) {
        MemberExample example = new MemberExample();
        example.createCriteria().andStatusEqualTo(ManagerContext.MemberStatus.OPEN.name());
        PageHelper.startPage(pageNum, pageSize);
        List<Member> list = memberMapper.selectByExample(example);
        for (Member member : list) {
            member.setRoleManagers(roleManagerMapper.selectRoleByMemberId(member.getId()));
        }
        PageInfo<Member> page = new PageInfo<>(list);
        return page;
    }

    /**
     * 插入member role 的映射
     */
    @Override
    public boolean insertMemberRoleWithId(Integer memberId, Integer[] roleIds) {
        if (memberId == null) {
            return false;
        }
        if (roleIds != null && roleIds.length > 0) {
            for (int i = 0; i < roleIds.length; i++) {
                Integer roleId = roleIds[i];

                MemberRoleExample example = new MemberRoleExample();
                example.createCriteria().andMemberIdEqualTo(memberId).andRoleIdEqualTo(roleId);
                List<MemberRole> list = memberRoleMapper.selectByExample(example);
                if (list != null && list.size() > 0) {
                    continue;
                }

                RoleManager roleManager = roleManagerMapper.selectByPrimaryKey(roleId);

                MemberRole memberRole = new MemberRole();
                memberRole.setCreateDate(new Date());
                memberRole.setModifyDate(new Date());
                memberRole.setMemberId(memberId);
                memberRole.setRoleId(roleManager.getId());
                memberRole.setName(roleManager.getName());
                memberRoleMapper.insert(memberRole);
            }
        }
        return true;
    }

    /**
     * 根据 memberId 删除对应的映射表
     */
    @Override
    public void deleteMemberRoleByMemberId(Integer id) {
        MemberRoleExample example = new MemberRoleExample();
        example.createCriteria().andMemberIdEqualTo(id);
        memberRoleMapper.deleteByExample(example);
    }

    /**
     * 修改member role 的映射
     */
    @Override
    public boolean updateMemberRoleWithId(Integer memberId, Integer[] roleIds) {
        if (memberId == null) {
            return false;
        }
        deleteMemberRoleByMemberId(memberId);
        return insertMemberRoleWithId(memberId, roleIds);
    }

    /**
     * 根据 memberId 查询 成员角色 映射列表
     */
    @Override
    public List<MemberRole> listMemberRoleByMemberId(Integer id) {
        MemberRoleExample example = new MemberRoleExample();
        example.createCriteria().andMemberIdEqualTo(id);
        return memberRoleMapper.selectByExample(example);
    }

    /**
     * 根据roleId resourcesIds 插入角色 权限映射表
     */
    @Override
    public boolean insertResourceUrlRole(Integer roleId, Integer[] resourcesIds) {
        if (roleId == null || resourcesIds == null) {
            return false;
        }
        for (int i = 0; i < resourcesIds.length; i++) {
            Integer resourceUrlId = resourcesIds[i];

            ResourceRoleExample example = new ResourceRoleExample();
            example.createCriteria().andResourceUrlIdEqualTo(resourceUrlId).andRoleIdEqualTo(roleId);
            List<ResourceRole> list = resourceRoleMapper.selectByExample(example);
            if (list != null && list.size() > 0) {
                continue;
            }

            ResourceRole resourceRole = new ResourceRole();
            resourceRole.setCreateDate(new Date());
            resourceRole.setModifyDate(new Date());
            resourceRole.setRoleId(roleId);
            resourceRole.setResourceUrlId(resourceUrlId);
            resourceRoleMapper.insert(resourceRole);
        }
        return true;
    }

    /**
     * 根据roleId resourcesIds 修改角色 权限映射表
     */
    @Override
    public boolean updateResourceUrlRoleWithRoleIdAndResourcesIds(Integer roleId, Integer[] resourcesIds) {
        if (roleId == null || resourcesIds == null) {
            return false;
        }
        deleteResourceRoleByRoleId(roleId);
        return insertResourceUrlRole(roleId, resourcesIds);
    }

    /**
     * 根据角色id删除角色资源映射
     */
    @Override
    public void deleteResourceRoleByRoleId(Integer roleId) {
        ResourceRoleExample example = new ResourceRoleExample();
        example.createCriteria().andRoleIdEqualTo(roleId);
        resourceRoleMapper.deleteByExample(example);
    }

    /**
     * 添加账户成员
     */
    @Override
    public boolean insertMember(Member member) {
        member.setStatus(ManagerContext.MemberStatus.OPEN.name());
        member.setPassword(Md5Util.encrypt(member.getPassword()));
        member.setCreateDate(new Date());
        member.setModifyDate(new Date());
        return memberMapper.insert(member) > 0;
    }

    /**
     * 根据id查找账户
     */
    @Override
    public Member findMemberById(Integer id) {
        return memberMapper.selectByPrimaryKey(id);
    }

    @Override
    public Member findMemberWithRole(Integer id) {
        Member member = findMemberById(id);

        MemberRoleExample example = new MemberRoleExample();
        example.createCriteria().andMemberIdEqualTo(id);
        List<RoleManager> roleManagerList = new ArrayList<>();
        List<MemberRole> list = memberRoleMapper.selectByExample(example);
        for (MemberRole memberRole : list) {
            roleManagerList.add(findRoleManagerById(memberRole.getRoleId()));
        }
        member.setRoleManagers(roleManagerList);
        return member;
    }

    /**
     * 修改账户
     */
    @Override
    public boolean updateMember(Member member) {
        if (StringUtils.isNotEmpty(member.getPassword())) {
            member.setPassword(Md5Util.encrypt(member.getPassword()));
        } else {
            member.setPassword(null);
        }
        member.setModifyDate(new Date());
        return memberMapper.updateByPrimaryKeySelective(member) > 0;
    }

    @Override
    public boolean deleteMember(Integer id) {
        return memberMapper.deleteByPrimaryKey(id) > 0;
    }

    /**
     * 显示角色列表
     */
    @Override
    public PageInfo<RoleManager> listRoleManage(int pageNum, int pageSize) {
        RoleManagerExample example = new RoleManagerExample();
        PageHelper.startPage(pageNum, pageSize);
        List<RoleManager> list = roleManagerMapper.selectByExample(example);
        PageInfo<RoleManager> page = new PageInfo<>(list);
        return page;
    }

    @Override
    public List<RoleManager> listAllRoleManage() {
        return roleManagerMapper.selectByExample(new RoleManagerExample());
    }

    /**
     * 插入一条角色信息
     */
    @Override
    public boolean insertRole(RoleManager roleManager) {
        roleManager.setCreateDate(new Date());
        roleManager.setModifyDate(new Date());
        return roleManagerMapper.insert(roleManager) > 0;
    }

    /**
     * 根据id查找角色实体
     */
    @Override
    public RoleManager findRoleManagerById(Integer id) {
        return roleManagerMapper.selectByPrimaryKey(id);
    }

    /**
     * 修改角色
     */
    @Override
    public boolean updateRoleManager(RoleManager roleManager) {
        roleManager.setModifyDate(new Date());
        return roleManagerMapper.updateByPrimaryKeySelective(roleManager) > 0;
    }

    /**
     * 根据角色id列出对应的权限
     */
    @Override
    public List<ResourceUrl> listResourceUrlByRoleId(Integer id) {
        return resourceUrlMapper.listResourceUrlByRoleId(id);
    }

    /**
     * 根据角色 id 资源id查找映射
     */
    @Override
    public ResourceRole findResourceRole(Integer roleId, Integer resourceUrlId) {
        ResourceRoleExample example = new ResourceRoleExample();
        example.createCriteria().andRoleIdEqualTo(roleId).andResourceUrlIdEqualTo(resourceUrlId);
        List<ResourceRole> list = resourceRoleMapper.selectByExample(example);
        return list != null && list.size() > 0 ? list.get(0) : null;
    }

    /**
     * 根据角色id和权限id删除映射
     */
    @Override
    public void deleteRoleResourceUrl(Integer roleId, Integer resourceUrlId) {
        ResourceRoleExample example = new ResourceRoleExample();
        example.createCriteria().andRoleIdEqualTo(roleId).andResourceUrlIdEqualTo(resourceUrlId);
        resourceRoleMapper.deleteByExample(example);
    }

    /**
     * 删除角色
     */
    @Override
    public boolean deleteRoleManager(Integer id) {
        return roleManagerMapper.deleteByPrimaryKey(id) > 0;
    }

    /**
     * 显示资源列表
     */
    @Override
    public PageInfo<ResourceUrl> listResource(int pageNum, int pageSize) {
       PageHelper.startPage(pageNum, pageSize);
        ResourceUrlExample example = new ResourceUrlExample();
        example.setOrderByClause("create_date desc");
        List<ResourceUrl> list = resourceUrlMapper.selectByExample(example);
        PageInfo<ResourceUrl> page = new PageInfo<>(list);
        return page;
    }

    @Override
    public List<ResourceUrl> listAllResource() {
        ResourceUrlExample example = new ResourceUrlExample();
        example.setOrderByClause("create_date desc");
        List<ResourceUrl> list = resourceUrlMapper.selectByExample(example);
        return list;
    }

    @Override
    public boolean insertResourceUrl(ResourceUrl resourceUrl) {
        resourceUrl.setCreateDate(new Date());
        resourceUrl.setModifyDate(new Date());
        return resourceUrlMapper.insert(resourceUrl) > 0;
    }

    @Override
    public ResourceUrl findResourceUrlById(Integer id) {
        return resourceUrlMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean updateResourceUrl(ResourceUrl resourceUrl) {
        resourceUrl.setModifyDate(new Date());
        return resourceUrlMapper.updateByPrimaryKeySelective(resourceUrl) > 0;
    }

    @Override
    public boolean deleteResourceUrl(Integer id) {
        return resourceUrlMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public boolean closeMember(Integer id) {
        Member member = new Member();
        member.setId(id);
        member.setStatus(ManagerContext.MemberStatus.CLOSE.name());
        return memberMapper.updateByPrimaryKeySelective(member) > 0;
    }

    @Override
    public PageInfo<Member> listMember(boolean hasMobile, int pageNum, int pageSize) {
        MemberExample example = new MemberExample();
        MemberExample.Criteria criteria = example.createCriteria();
        if (hasMobile) {
            criteria.andMobileIsNotNull();
        }
        PageHelper.startPage(pageNum, pageSize);
        List<Member> list = memberMapper.selectByExample(example);
        for (Member member : list) {
            member.setRoleManagers(roleManagerMapper.selectRoleByMemberId(member.getId()));
        }
        PageInfo<Member> page = new PageInfo<>(list);
        return page;
    }


    @Override
    public String queryMemberByRoleName(String traceId, String name) {

        name = "%" + name + "%";
        return roleManagerMapper.selectMemberAccordingOfRole(name);

    }
}
