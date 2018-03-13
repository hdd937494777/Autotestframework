package com.mizlicai.eudemon.mng.controller;

import com.github.pagehelper.PageInfo;
import com.mizlicai.eudemon.entity.*;
import com.mizlicai.eudemon.exceptions.TestException;
import com.mizlicai.eudemon.mng.biz.InterfaceServicesBiz;
import com.mizlicai.eudemon.mng.utils.ControllerResult;
import com.mizlicai.eudemon.mng.utils.PagerHelper;
import com.mizlicai.eudemon.service.ProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


/**
 * Created by huangyt on 2017/6/7.
 */
@Controller
@RequestMapping(value = "interface")
public class InterfaceTestController extends  BaseController {

    private  Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private InterfaceServicesBiz interfaceServicesBiz;

    @Autowired
    private ProjectService projectService;

    /**
     * 查询服务列表
     * @param pageNum
     * @param pageSize
     * @param model
     * @return
     */
    @RequestMapping(value = "servicelist", method = RequestMethod.GET)
    public String servicesList(@RequestParam(value="pageNum", defaultValue="1") int pageNum, @RequestParam(value="pageSize", defaultValue="20") int pageSize,Services services, Model model){
        PageInfo<Services> page = interfaceServicesBiz.getServicePage(pageNum,pageSize,services);
        PagerHelper<Services> pagerHelper = new PagerHelper<>();
        pagerHelper.setPager(page);
        pagerHelper.setBaseUrl("servicelist");
        model.addAttribute("list", page.getList());
        model.addAttribute("pagerHelper", pagerHelper);
        model.addAttribute("services",services);
        return "interface/listService";
    }

    /**
     * 服务添加页面跳转
     */
    @RequestMapping(value = "addservices", method = RequestMethod.GET)
    public String addservices(Model model) {
        ProjectExample example = new ProjectExample();
        List<Project> list = projectService.getProjectByExample(example);
        model.addAttribute("projectList",list);
        return "interface/addService";
    }

    /**
     * 服务添加
     */
    @RequestMapping(value = "addservice", method = RequestMethod.POST)
    public String addservice(Services services, RedirectAttributes redirectAttributes) {
        interfaceServicesBiz.insertService(services);
        redirectAttributes.addFlashAttribute("msg", "服务添加成功");
        return "redirect:servicelist";
    }

    /**
     * 服务修改页面跳转
     */
    @RequestMapping(value = "updateservice/{id}", method = RequestMethod.GET)
    public String updateservice(@PathVariable Integer id, Model model) {
        ProjectExample example = new ProjectExample();
        List<Project> list = projectService.getProjectByExample(example);
        model.addAttribute("projectList",list);

        Services services = interfaceServicesBiz.getService(id);
        model.addAttribute("services", services);
        return "interface/addService";
    }
    /**
     * 服务修改
     */
    @RequestMapping(value = "updateservice", method = RequestMethod.POST)
    public String updateservice(Services services,RedirectAttributes redirectAttributes) {
        interfaceServicesBiz.updateService(services);
        redirectAttributes.addFlashAttribute("msg", "服务更新成功");
        return "redirect:servicelist";
    }

    /**
     * 服务删除
     */
    @RequestMapping(value = "deleteservice/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ControllerResult deleteService(@PathVariable Integer id) {
        ControllerResult result = new ControllerResult();
        interfaceServicesBiz.deleteService(id);
        result.setSuccess(true);
        result.setMessage("服务删除成功");
        return result;
    }
    /**
     * 服务测试触发
     */
    @RequestMapping(value = "interfacetest/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ControllerResult interfaceTest(@PathVariable Integer id) {
        ControllerResult result = new ControllerResult();
        try {
            interfaceServicesBiz.interfaceTest(id);
            result.setSuccess(true);
            result.setMessage("服务测试触发成功");
        } catch (TestException e) {

            result.setSuccess(true);
            result.setMessage("服务测试触发异常");
            logger.error("服务测试触发异常",e);
        }
        return result;
    }
    /**
     * 查询服务列表
     * @param pageNum
     * @param pageSize
     * @param model
     * @return
     */
    @RequestMapping(value = "requestlist", method = RequestMethod.GET)
    public String requestList(@RequestParam(value="pageNum", defaultValue="1") int pageNum, @RequestParam(value="pageSize", defaultValue="20") int pageSize,Model model){
        PageInfo<RequestQueue> page = interfaceServicesBiz.getRequestPage(pageNum,pageSize);
        PagerHelper<RequestQueue> pagerHelper = new PagerHelper<>();
        pagerHelper.setPager(page);
        pagerHelper.setBaseUrl("requestlist");
        model.addAttribute("list", page.getList());
        model.addAttribute("pagerHelper", pagerHelper);
        return "interface/listRequest";
    }

    /**
     * 查询服务列表
     * @param pageNum
     * @param pageSize
     * @param model
     * @return
     */
    @RequestMapping(value = "exceptionlist", method = RequestMethod.GET)
    public String exceptionList(@RequestParam(value="pageNum", defaultValue="1") int pageNum, @RequestParam(value="pageSize", defaultValue="20") int pageSize,String serviceId, Model model){
        PageInfo<ErrorRequest> page = interfaceServicesBiz.getErrorRequestPage(pageNum,pageSize,serviceId);
        PagerHelper<ErrorRequest> pagerHelper = new PagerHelper<>();
        pagerHelper.setPager(page);
        pagerHelper.setBaseUrl("exceptionlist");
        model.addAttribute("list", page.getList());
        model.addAttribute("pagerHelper", pagerHelper);
        return "interface/listException";
    }
    /**
     * 服务删除
     */
    @RequestMapping(value = "deleterequest/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ControllerResult deleteRequest(@PathVariable Integer id) {
        ControllerResult result = new ControllerResult();
        interfaceServicesBiz.deleteRequest(id);
        result.setSuccess(true);
        result.setMessage("请求删除成功");
        return result;
    }


    /**
     * 服务删除
     */
    @RequestMapping(value = "deleteexception/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ControllerResult deleteException(@PathVariable Integer id) {
        ControllerResult result = new ControllerResult();
        interfaceServicesBiz.deleteErrorRequest(id);
        result.setSuccess(true);
        result.setMessage("异常删除成功");
        return result;
    }



}
