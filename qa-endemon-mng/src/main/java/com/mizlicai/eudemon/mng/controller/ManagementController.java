package com.mizlicai.eudemon.mng.controller;

import com.github.pagehelper.PageInfo;
import com.mizlicai.eudemon.mng.entity.Member;
import com.mizlicai.eudemon.mng.entity.MessageRoleSetting;
import com.mizlicai.eudemon.mng.entity.ResourceUrl;
import com.mizlicai.eudemon.mng.entity.RoleManager;
import com.mizlicai.eudemon.mng.service.MessageRoleSettingService;
import com.mizlicai.eudemon.mng.service.ResourceAccessService;
import com.mizlicai.eudemon.mng.utils.ControllerResult;
import com.mizlicai.eudemon.mng.utils.PagerHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by chenlt on 15/6/8.下午9:26
 * Copyright © mizhuanglicai
 * 权限管理控制
 */
@Controller
@RequestMapping("rolemanagement")
public class ManagementController {

    @Resource
    private ResourceAccessService accessService;
    
    @Autowired
    private MessageRoleSettingService messageRoleSettingService;

    /**
     * 账户列表
     */
    @RequestMapping(value = "member", method = RequestMethod.GET)
    public String memberList(@RequestParam(value="pageNum", defaultValue="1") int pageNum, @RequestParam(value="pageSize", defaultValue="20") int pageSize, Model model) {
        PageInfo<Member> page = accessService.listMember(pageNum ,pageSize);

        PagerHelper<Member> pagerHelper = new PagerHelper<>();
        pagerHelper.setPager(page);
        pagerHelper.setBaseUrl("member");

        model.addAttribute("list", page.getList());
        model.addAttribute("pagerHelper", pagerHelper);
        return "management/member";
    }

    /**
     * 账户添加页面跳转
     */
    @RequestMapping(value = "addmember", method = RequestMethod.GET)
    public String addMember(Model model) {
        List<RoleManager> list = accessService.listAllRoleManage();
        model.addAttribute("roleManagers", list);
        return "management/addMember";
    }


    /**
     * 账户添加
     */
    @RequestMapping(value = "addmember", method = RequestMethod.POST)
    public String addMemberAction(Member member, Integer[] activity, RedirectAttributes redirectAttributes) {
        if (accessService.findMemberByNameStatus(member.getName()) != null){
            redirectAttributes.addFlashAttribute("msg", "账户名" + member.getName() + "已存在");
            return "redirect:member";
        }
        if (accessService.insertMember(member)) {
            if(accessService.insertMemberRoleWithId(member.getId(), activity)){
                redirectAttributes.addFlashAttribute("msg", "账户添加成功");
            }
        } else {
            redirectAttributes.addFlashAttribute("msg", "账户添加失败");
        }
        return "redirect:member";
    }

    /**
     * 账户修改页面跳转
     */
    @RequestMapping(value = "updatemember/{id}", method = RequestMethod.GET)
    public String updateMember(@PathVariable Integer id, Model model) {
        Member member = accessService.findMemberWithRole(id);
        List<RoleManager> list = accessService.listAllRoleManage();
        model.addAttribute("roleManagers", list);
        model.addAttribute("member", member);
        return "management/addMember";
    }

    /**
     * 账户修改
     */
    @RequestMapping(value = "updatemember", method = RequestMethod.POST)
    public String updateMemberAction(Member member, Integer[] activity, RedirectAttributes redirectAttributes) {
        if (accessService.updateMember(member)) {
            accessService.updateMemberRoleWithId(member.getId(), activity);
            redirectAttributes.addFlashAttribute("msg", "资源修改成功");
        } else {
            redirectAttributes.addFlashAttribute("msg", "资源修改失败");
        }
        return "redirect:member";
    }

    /**
     * 账户删除,逻辑删除
     */
    @RequestMapping(value = "deletemember/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ControllerResult resourcesMember(@PathVariable Integer id) {
        ControllerResult result = new ControllerResult();
        accessService.deleteMemberRoleByMemberId(id);
        if (accessService.closeMember(id)) {
            result.setSuccess(true);
            result.setMessage("账户删除成功");
        } else {
            result.setSuccess(false);
            result.setMessage("账户删除失败");
        }

        return result;
    }


    /**
     * 角色列表
     */
    @RequestMapping(value = "role", method = RequestMethod.GET)
    public String roleManagement(@RequestParam(value="pageNum", defaultValue="1") int pageNum, @RequestParam(value="pageSize", defaultValue="20") int pageSize, Model model) {
        PageInfo<RoleManager> page = accessService.listRoleManage(pageNum,pageSize );
        PagerHelper<RoleManager> pagerHelper = new PagerHelper<>();
        pagerHelper.setPager(page);
        pagerHelper.setBaseUrl("role");

        model.addAttribute("list", page.getList());
        model.addAttribute("pagerHelper", pagerHelper);
        return "management/role";
    }

    /**
     * 角色添加页面跳转
     */
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String addRoleManagement() {
        return "management/addRole";
    }

    /**
     * 角色添加
     */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String addAction(RoleManager roleManager, Integer[] resourcesIds, RedirectAttributes redirectAttributes) {
        if (accessService.insertRole(roleManager)) {
        	String traceId = UUID.randomUUID().toString();
        			
            accessService.insertResourceUrlRole(roleManager.getId(), resourcesIds);
            
            MessageRoleSetting setting = new MessageRoleSetting();
            setting.setCreateTime(new Date());
            setting.setIsEffect("NO");
            setting.setRoleId(String.valueOf(roleManager.getId()));
            setting.setRoleName(roleManager.getName());
            messageRoleSettingService.insertMessageRoleSetting(traceId, setting);
            
            redirectAttributes.addFlashAttribute("msg", "角色添加成功");
        } else {
            redirectAttributes.addFlashAttribute("msg", "角色添加失败");
        }
        return "redirect:role";
    }

    /**
     * 角色修改页面跳转
     */
    @RequestMapping(value = "update/{id}", method = RequestMethod.GET)
    public String updateRole(@PathVariable Integer id, Model model) {
        RoleManager roleManager = accessService.findRoleManagerById(id);
        List<ResourceUrl> list = accessService.listResourceUrlByRoleId(roleManager.getId());
        model.addAttribute("role", roleManager);
        model.addAttribute("ResourceUrl", list);

        return "management/addRole";
    }

    /**
     * 删除角色的权限
     */
    @RequestMapping(value = "delete", method = RequestMethod.GET)
    @ResponseBody
    public String deleteRoleResourceUrl(Integer roleId, Integer resourceUrlId) {
        
    	accessService.deleteRoleResourceUrl(roleId, resourceUrlId);
               
        if(accessService.findResourceRole(roleId, resourceUrlId) == null){
            return "success";
        }else{
            return "fail";
        }
    }

    /**
     * 角色修改
     */
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String updateRoleAction(RoleManager roleManager, Integer[] resourcesIds, RedirectAttributes redirectAttributes) {
        if (accessService.updateRoleManager(roleManager)) {
            accessService.updateResourceUrlRoleWithRoleIdAndResourcesIds(roleManager.getId(), resourcesIds);
            
            String traceId = UUID.randomUUID().toString();
            
            MessageRoleSetting setting = messageRoleSettingService.selectSettingByRoleId(traceId, 
            		String.valueOf(roleManager.getId()));
            if(setting == null){
            	setting = new MessageRoleSetting();
            	
            	setting.setIsEffect("NO");
                setting.setRoleId(String.valueOf(roleManager.getId()));
                setting.setRoleName(roleManager.getName());
                setting.setCreateTime(new Date());
                messageRoleSettingService.insertMessageRoleSetting(traceId, setting);
                
            } 
            else {
            	setting.setRoleName(roleManager.getName());
                setting.setCreateTime(new Date());
                messageRoleSettingService.updateMessageRoleSettingById(traceId, setting);
            }
            
            
            redirectAttributes.addFlashAttribute("msg", "角色修改成功");
        } else {
            redirectAttributes.addFlashAttribute("msg", "角色修改失败");
        }
        return "redirect:role";
    }

    /**
     * 角色删除
     */
    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ControllerResult roleDelete(@PathVariable Integer id) {
        ControllerResult result = new ControllerResult();
        if (accessService.deleteRoleManager(id)) {
        	
        	String traceId = UUID.randomUUID().toString();
        	messageRoleSettingService.deleteRoleSetting(traceId, String.valueOf(id));
            result.setSuccess(true);
            result.setMessage("角色删除成功");
        } else {
            result.setSuccess(false);
            result.setMessage("角色删除失败");
        }
        return result;
    }

    /**
     * 请求所有的资源路径 ajax
     */
    @RequestMapping(value = "resourceurl", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> resourceUrl() {
        Map<String, Object> map = new HashMap<>();
        List<ResourceUrl> list = accessService.listAllResource();
        map.put("resourceurls", list);
        return map;
    }

    /**
     * 资源列表
     */
    @RequestMapping(value = "resources", method = RequestMethod.GET)
    public String resources(@RequestParam(value="pageNum", defaultValue="1") int pageNum, @RequestParam(value="pageSize", defaultValue="20") int pageSize, Model model) {
        PageInfo<ResourceUrl> page = accessService.listResource(pageNum,pageSize);
        PagerHelper<ResourceUrl> pagerHelper = new PagerHelper<>();
        pagerHelper.setPager(page);
        pagerHelper.setBaseUrl("resources");
        model.addAttribute("list", page.getList());
        model.addAttribute("pagerHelper", pagerHelper);
        return "management/resources";
    }

    /**
     * 资源添加页面跳转
     */
    @RequestMapping(value = "addResources", method = RequestMethod.GET)
    public String addResources() {
        return "management/addResource";
    }

    /**
     * 资源添加
     */
    @RequestMapping(value = "addResources", method = RequestMethod.POST)
    public String addResourcesAction(ResourceUrl resourceUrl, RedirectAttributes redirectAttributes) {
        if (accessService.insertResourceUrl(resourceUrl)) {
            redirectAttributes.addFlashAttribute("msg", "资源路径添加成功");
        } else {
            redirectAttributes.addFlashAttribute("msg", "资源路径添加失败");
        }
        return "redirect:resources";
    }

    /**
     * 资源修改页面跳转
     */
    @RequestMapping(value = "updateResources/{id}", method = RequestMethod.GET)
    public String updateResources(@PathVariable Integer id, Model model) {
        ResourceUrl resourceUrl = accessService.findResourceUrlById(id);
        model.addAttribute("res", resourceUrl);
        return "management/addResource";
    }

    /**
     * 资源修改
     */
    @RequestMapping(value = "updateResources", method = RequestMethod.POST)
    public String updateResourcesAction(ResourceUrl resourceUrl, RedirectAttributes redirectAttributes) {
        if (accessService.updateResourceUrl(resourceUrl)) {
            redirectAttributes.addFlashAttribute("msg", "资源修改成功");
        } else {
            redirectAttributes.addFlashAttribute("msg", "资源修改失败");
        }
        return "redirect:resources";
    }

    /**
     * 资源删除
     */
    @RequestMapping(value = "deleteresources/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ControllerResult resourcesDelete(@PathVariable Integer id) {
        ControllerResult result = new ControllerResult();
        if (accessService.deleteResourceUrl(id)) {
            result.setSuccess(true);
            result.setMessage("资源删除成功");
        } else {
            result.setSuccess(true);
            result.setMessage("资源删除失败");
        }
        return result;
    }
}
