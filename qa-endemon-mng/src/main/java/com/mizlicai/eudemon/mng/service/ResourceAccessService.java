package com.mizlicai.eudemon.mng.service;

import com.github.pagehelper.PageInfo;
import com.mizlicai.eudemon.mng.entity.*;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * chaos - com.miz.chaos.service
 * Created by clt on 15/5/5.下午3:55
 * 资源权限
 */
public interface ResourceAccessService {

    /**
     * 短信验证
     *
     * @param code 短信验证码
     * @param username 用户名
     * @param session 会话
     * @param model model
     */
    public boolean certifyCode(String code, String username, HttpSession session, Model model);

    /**
     * 验证码发送
     *
     * @param username 用户名
     * @param session 会话
     * @param model model
     */
    String sendCode(String username, String password, HttpSession session, Model model);

    /**
     * 根据名称查询管理员
     */
    Member findMemberByName(String name);

    /**
     * 登录权限
     */
    boolean isEnoughPermissionsToLogin(Member member, String resourceUrl);

    /**
     * 判断是否具有权限
     */
    boolean isEnoughPermissions(Member member, String resourceUrl);

    /**
     * 判断当不存在这条资源时，添加
     */
    void addNewResourceUrl(String url);

    /**
     * 根据url值查询实体
     */
    ResourceUrl findResourceUrlByValue(String url);

    /**
     * 成员列表
     */
    PageInfo<Member> listMember(int pageNum, int pageSize);

    /**
     * 插入member role 的映射
     */
    boolean insertMemberRoleWithId(Integer memberId, Integer[] roleIds);


    /**
     * 查询账户关联角色
     */
    Member findMemberWithRole(Integer id);

    /**
     * 根据 memberId 删除对应的映射表
     */
    void deleteMemberRoleByMemberId(Integer id);

    /**
     * 修改member role 的映射
     */
    boolean updateMemberRoleWithId(Integer memberId, Integer[] roleIds);

    /**
     * 添加账户
     */
    boolean insertMember(Member member);

    /**
     * 修改账户
     */
    boolean updateMember(Member member);

    /**
     * 删除角色
     */
    boolean deleteMember(Integer id);

    /**
     * 根据id查找账户
     */
    Member findMemberById(Integer id);

    /**
     * 显示角色列表
     */
    PageInfo<RoleManager> listRoleManage(int pageNum, int pageSize);

    List<RoleManager> listAllRoleManage();

    /**
     * 插入一条角色信息
     */
    boolean insertRole(RoleManager roleManager);

    /**
     * 根据id查找角色实体
     */
    RoleManager findRoleManagerById(Integer id);

    /**
     * 根据 memberId 查询 成员角色 映射列表
     */
    List<MemberRole> listMemberRoleByMemberId(Integer id);

    /**
     * 根据roleId resourcesIds 插入角色 权限映射表
     */
    boolean insertResourceUrlRole(Integer roleId, Integer[] resourcesIds);

    /**
     * 根据roleId resourcesIds 修改角色 权限映射表
     */
    boolean updateResourceUrlRoleWithRoleIdAndResourcesIds(Integer roleId, Integer[] resourcesIds);

    /**
     * 修改角色
     */
    boolean updateRoleManager(RoleManager roleManager);

    /**
     * 根据角色id列出对应的权限
     */
    List<ResourceUrl> listResourceUrlByRoleId(Integer id);

    /**
     * 根据角色 id 资源id查找映射
     */
    ResourceRole findResourceRole(Integer roleId, Integer resourceUrlId);

    /**
     * 根据角色id和权限id删除映射
     */
    void deleteRoleResourceUrl(Integer roleId, Integer resourceUrlId);

    /**
     * 删除角色
     */
    boolean deleteRoleManager(Integer id);

    /**
     * 根据角色id删除角色资源映射
     */
    void deleteResourceRoleByRoleId(Integer roleId);

    /**
     * 显示资源
     */
    PageInfo<ResourceUrl> listResource(int pageNum, int pageSize);

    List<ResourceUrl> listAllResource();

    /**
     * 插入一条角色信息
     */
    boolean insertResourceUrl(ResourceUrl resourceUrl);

    /**
     * 根据 id 查找资源实体
     */
    ResourceUrl findResourceUrlById(Integer id);

    /**
     * 更改资源
     */
    boolean updateResourceUrl(ResourceUrl resourceUrl);

    /**
     * 删除资源
     */
    boolean deleteResourceUrl(Integer id);

    /**
     * 判断资源是否入库
     */
    boolean areStorage(String resourceUrl);

    /**
     * 关闭账户
     */
    boolean closeMember(Integer id);

    /**
     * 根据账户name和status查找账户
     */
    Member findMemberByNameStatus(String name);
    
    /**
     * 成员列表
     */
    PageInfo<Member> listMember(boolean hasMobile, int pageNum, int pageSize);
    
    /**
     * 
     * @param traceId
     * @param name
     * @return
     */
    String queryMemberByRoleName(String traceId, String name);
}
