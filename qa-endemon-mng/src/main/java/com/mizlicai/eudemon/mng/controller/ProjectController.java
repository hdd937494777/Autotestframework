package com.mizlicai.eudemon.mng.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mizlicai.eudemon.entity.Project;
import com.mizlicai.eudemon.entity.ProjectExample;
import com.mizlicai.eudemon.entity.Services;
import com.mizlicai.eudemon.mng.utils.ControllerResult;
import com.mizlicai.eudemon.mng.utils.PagerHelper;
import com.mizlicai.eudemon.service.ProjectService;
import com.mizlicai.eudemon.utils.CommUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * Created by huangyt on 2017/7/24.
 */
@Controller
@RequestMapping(value = "project")
public class ProjectController   extends  BaseController{

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ProjectService projectService;


    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String servicesList(@RequestParam(value="pageNum", defaultValue="1") int pageNum, @RequestParam(value="pageSize", defaultValue="20") int pageSize, Model model){
        ProjectExample example = new ProjectExample();
        PageHelper.startPage(pageNum,pageSize);
        List<Project> list = projectService.getProjectByExample(example);
        PageInfo<Project> page = new PageInfo<>(list);
        PagerHelper<Project> pagerHelper = new PagerHelper<>();
        pagerHelper.setPager(page);
        pagerHelper.setBaseUrl("list");
        model.addAttribute("list", page.getList());
        model.addAttribute("pagerHelper", pagerHelper);
        return "project/list";
    }

    /**
     * 项目添加页面跳转
     */
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {

        return "project/add";
    }

    /**
     * 项目添加
     */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String addservice(Project project, RedirectAttributes redirectAttributes) {
        project.setCreateTime(CommUtil.nowTime());
        project.setUpdateTime(CommUtil.nowTime());
        projectService.insert(project);
        redirectAttributes.addFlashAttribute("msg", "项目添加成功");
        return "redirect:list";
    }

    /**
     * 项目修改页面跳转
     */
    @RequestMapping(value = "update/{id}", method = RequestMethod.GET)
    public String update(@PathVariable Integer id, Model model) {

        Project project = projectService.getProjectById(id);
        model.addAttribute("project", project);
        return "project/add";
    }
    /**
     * 服务修改
     */
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(Project project,RedirectAttributes redirectAttributes) {
        projectService.update(project);
        redirectAttributes.addFlashAttribute("msg", "项目更新成功");
        return "redirect:list";
    }

    /**
     * 项目删除
     */
    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ControllerResult delete(@PathVariable Integer id) {
        ControllerResult result = new ControllerResult();
        projectService.delete(id);
        result.setSuccess(true);
        result.setMessage("项目删除成功");
        return result;
    }
}
