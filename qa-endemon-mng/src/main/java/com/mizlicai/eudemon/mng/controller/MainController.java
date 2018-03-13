package com.mizlicai.eudemon.mng.controller;

import com.miz.mekansm.common.utils.JsonUtil;
import com.mizlicai.eudemon.mng.biz.InterfaceServicesBiz;
import com.mizlicai.eudemon.mng.entity.Member;
import com.mizlicai.eudemon.mng.exception.BusinessExceptionCode;
import com.mizlicai.eudemon.mng.service.InternalLogService;
import com.mizlicai.eudemon.mng.service.IpConfigService;
import com.mizlicai.eudemon.mng.service.ResourceAccessService;
import com.mizlicai.eudemon.mng.utils.DateTimeUtil;
import com.mizlicai.eudemon.mng.utils.Md5Util;
import com.mizlicai.eudemon.mng.utils.ModelHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.UUID;

@Controller
public class MainController {

    @Value("#{settings['dev.mode']}")
    protected boolean dev;

    @Value("#{settings['session.user.name']}")
    protected String sessionUser;

    @Resource
    private InternalLogService internalLogService; //内部登录服务


    @Resource
    private ResourceAccessService resourceAccessService;

    @Resource
    private IpConfigService ipConfigService;

    @Resource
    private RedisTemplate<String, String> redisTemplate;


    @Autowired
    private InterfaceServicesBiz interfaceServicesBiz;
    
    
    private Logger logger = LoggerFactory.getLogger(getClass());


    @RequestMapping(value = "/chars", method = RequestMethod.GET)
    public String chars(HttpSession session, Model model) {

        redisTemplate.opsForValue().set("chars", "chars");
        String chars = redisTemplate.opsForValue().get("chars");
        model.addAttribute("chars", chars);

        return null;
    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String login(HttpSession session, Model model, HttpServletRequest request, @RequestHeader("User-Agent") String userAgent) {
        if (dev) {
            Member member = internalLogService.login(session, model, "admin", "admin", request.getRequestURL().toString().trim(), userAgent, request);
            session.setAttribute(sessionUser, member);
            //查询剩余份额
//            List<Product> list = gaProductService.leftReminder(10000);
//            model.addAttribute("left", new ArrayList<>());
           return  index(model);
        }
        return "login";
    }


    /**
     * 发送短信验证码
     *
     * @param username 用户名
     * @param session  会话
     * @param model    model
     */
    @RequestMapping(value = "/sendcode", method = RequestMethod.GET)
    @ResponseBody
    public String code(String username, String password, HttpSession session, Model model) {
        //短线发送接口
        return resourceAccessService.sendCode(username, password, session, model);
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, HttpSession session, String certify, String code,
                        Model model, String username, String password, @RequestHeader("User-Agent") String userAgent) {
        StringBuffer url = request.getRequestURL();

        //防撞库安全校验
//        try {
//            SafetyUtils.checkSafety(redisTemplate, username, userAgent, IP.getRemoteAddr(request), SafetyUtils.Type.LOGIN, Boolean.TRUE);
//        } catch (BusinessException e) {
//            model.addAttribute("status", e.getCode());
//            model.addAttribute("errorMsg", e.getMessage());
//            return null;
//        }

        //只验证前端传来的是不可信的,需要在后端判断
//        boolean visitable = ipConfigService.findByIp(request.getRemoteAddr());
//
//        if ("true".equals(certify) || !visitable) {
//            boolean flag = resourceAccessService.certifyCode(code, username,
//                    session, model);
//            if (!flag) {
//                return "login";
//            }
//        }

        Member member = internalLogService.login(session, model, username,
                password, url.toString().trim(), userAgent, request);
        if (member == null) {
            return "login";
        }
        logger.info("登录完成sessionUser",member.getId());
        session.setAttribute(sessionUser, member);
//        if (!visitable) {
//            ipConfigService.deleteByName(member.getName());
//            ipConfigService.addIpConfig(request.getRemoteAddr(), member.getName());
//        }

       return index(model);
    }

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String main(Model model) {
        return "index";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        session.invalidate();
        return "login";
    }

    /**
     * 修改登录密码页面
     */
    @RequestMapping(value = "/modifypassword", method = RequestMethod.GET)
    public String modifypassword() {
        return "modifypassword";
    }

    /**
     * 修改登录密码
     */
    @RequestMapping(value = "/modifypassword", method = RequestMethod.POST)
    public String modifypassword(String oldPassword, String newPassword, String newPasswordAgain, HttpSession session,
                                 Model model, RedirectAttributes redirectAttributes) {
        Member member = (Member) session.getAttribute(sessionUser);

        if (member == null) {
            return "modifypassword";
        }

        if (!member.getPassword().equals(Md5Util.encrypt(oldPassword))) {
            ModelHelper.addValidateInfo(model, BusinessExceptionCode.EXCEPTION_60000);
            return "modifypassword";
        }
        if (!newPassword.equals(newPasswordAgain)) {
            ModelHelper.addValidateInfo(model,
                    BusinessExceptionCode.EXCEPTION_60001);
            return "modifypassword";
        }
        if (newPassword.equals(oldPassword)) {
            ModelHelper.addValidateInfo(model,
                    BusinessExceptionCode.EXCEPTION_60002);
            return "modifypassword";
        }
        member.setPassword(newPassword);
        if (resourceAccessService.updateMember(member)) {
            redirectAttributes.addFlashAttribute("msg", "修改密码成功");
        } else {
            redirectAttributes.addFlashAttribute("msg", "修改密码失败");
        }
        return "redirect:/main";
    }
    
    /**
     * 获取最近12个月
     */
    @RequestMapping(value = "/getRecent12Month", method = RequestMethod.POST)
    @ResponseBody
    public String getRecent12Month() {

    	return JsonUtil.toJson(DateTimeUtil.getRecent12MonthsOtherFormat());
    }
   

    /**
     * 获取最近12个月订单数
     */
    @RequestMapping(value = "/getRecent12MonthOrders", method = RequestMethod.POST)
    @ResponseBody
    public String getRecent12MonthOrders() {
    	
    	String traceId = UUID.randomUUID().toString();
    	logger.info(String.format("[5000 统计 近12月订单数 traceId=%s}]", traceId));
    	return "";//JsonUtil.toJson(censusBiz.census12RecentMonthOrderCounts(traceId));
       
    }
   
    
    /**
    * 获取最近12个月用户数
    */
   @RequestMapping(value = "/getRecent12MonthUsers", method = RequestMethod.POST)
   @ResponseBody
   public String getRecent12MonthUsers() {
   	
	   String traceId = UUID.randomUUID().toString();
	   logger.info(String.format("[5000 统计 近12个月用户数 {traceId=%s}]", traceId));
       return "";//JsonUtil.toJson(censusBiz.census12RecentMonthUserCounts(traceId));
      
   }
    
   /**
    * 获取不同时间段订单数
    */
   @RequestMapping(value = "/getDiffTimeOrdersCounts", method = RequestMethod.POST)
   @ResponseBody
   public String getDiffTimeOrdersCounts() {
   	
	   String traceId = UUID.randomUUID().toString();
	   logger.info(String.format("[5000 统计 各个时间段订单数 {traceId=%s}]", traceId));
   	//   CensusOrdersResVO vo = censusBiz.censusDiffPeriodOrderCounts(traceId);

       return "";//JsonUtil.toJson(vo);
   }
   
   
   
   /**
    * 获取不同时间段订单新用户下单数，旧用户下单数
    */
   @RequestMapping(value="/ajaxGetOrdersCountsType" ,method = RequestMethod.POST)
   @ResponseBody
   public String ajaxGetDiffTimeOrdersCountsType(String type){
	   String traceId = UUID.randomUUID().toString();
	   logger.info(String.format("[5000 统计 各个时间段新用户，老用户，下单个数 {traceId=%s,type=%s}]", traceId,type));
	   
	   //CensusOrderUsersVO vo = censusBiz.censusDiffTypeOrderCounts(traceId, type);

       return "";// JsonUtil.toJson(vo);
	   
   }
   
   
   
   /**
    * 获取不同时间段用户数
    */
   @RequestMapping(value = "/getDiffTimeUserCounts", method = RequestMethod.POST)
   @ResponseBody
   public String getDiffTimeUserCounts() {
   	
	   String traceId = UUID.randomUUID().toString();
	   logger.info(String.format("[5000 统计 各个时间段用户数 {traceId=%s}]", traceId));
   	   //CensusUsersResVO vo = censusBiz.censusDiffPeriodUserCounts(traceId);

       return "";//JsonUtil.toJson(vo);
   }
   
   
   
   /**
    * 获取不同时间段已实名用户，未实名用户数，黑名单数
    */
   @RequestMapping(value="/ajaxGetUserCountsType" ,method = RequestMethod.POST)
   @ResponseBody
   public String ajaxGetDiffTimeUserCountsType(String type){
	   String traceId = UUID.randomUUID().toString();
	   logger.info(String.format("[5000 统计 各个时间段已实名，未实名，黑名单的个数 {traceId=%s,type=%s}]", traceId,type));
	  // CensusUsersVO vo = censusBiz.censusDiffTypeUserCounts(traceId, type);

       return "";//JsonUtil.toJson(vo);
	   
   }
   
   /**
    * 首页
    * @param model
    * @return
    */
   private String index(Model model){
	   String traceId = UUID.randomUUID().toString();
       
	   logger.info(String.format("[5000  运营系统首页 index {traceId=%s}]", traceId));
	   long  exceptionCounts = interfaceServicesBiz.exceptionCounts();
	   long interfaceRequestCounts = interfaceServicesBiz.interfaceCounts();
	   long serviceCount = interfaceServicesBiz.serviceCount();
	   long errorServiceCount = interfaceServicesBiz.errorServiceCount();
	   
	   model.addAttribute("interfaceRequestCounts",interfaceRequestCounts);
	   model.addAttribute("serviceCount",serviceCount);
       model.addAttribute("errorServiceCount",errorServiceCount);
	   
       return "index";
   }
   

   
   @RequestMapping("gotoMain")
   public String gotoIndex(HttpSession session,Model model){
	   return index(model); 
   }
   
    
}
