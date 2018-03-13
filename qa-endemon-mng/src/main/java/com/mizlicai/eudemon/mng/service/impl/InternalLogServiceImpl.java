package com.mizlicai.eudemon.mng.service.impl;


import com.mizlicai.eudemon.mng.entity.Member;
import com.mizlicai.eudemon.mng.exception.BusinessExceptionCode;
import com.mizlicai.eudemon.mng.service.InternalLogService;
import com.mizlicai.eudemon.mng.service.ResourceAccessService;
import com.mizlicai.eudemon.mng.utils.IP;
import com.mizlicai.eudemon.mng.utils.Md5Util;
import com.mizlicai.eudemon.mng.utils.ModelHelper;
import com.mizlicai.eudemon.mng.utils.SafetyUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * chaos - com.miz.chaos.service Created by clt on 15/5/5.上午11:46
 */
@Service
public class InternalLogServiceImpl implements InternalLogService {
	protected final Logger logger = Logger.getLogger(InternalLogServiceImpl.class);
	@Resource
	private ResourceAccessService accessService;

	@Value("#{settings['dev.mode']}")
	protected boolean dev;

	@Resource
	private RedisTemplate<String, String> redisTemplate;

	@Override
	public LogStatus login(HttpServletRequest request,
											  HttpSession session, Model model, String name, String password,
											  String resourceUrl) {

		Member member = accessService.findMemberByName(name);
		if (member == null) {
			return LogStatus.NO_SUCH_USER;
		}

		if (member.getPassword() == null) {
			return LogStatus.INITIALIZATION_CODE;
		}

		if (member.getPassword().equals(Md5Util.encrypt(password))) {
			if (accessService.isEnoughPermissions(member, resourceUrl)) {
				return LogStatus.SUCCESS;
			} else {
				return LogStatus.INSUFFICIENT_PERMISSIONS; // 权限级别不够
			}
		} else {
			return LogStatus.PASSWORD_ERROR;
		}

	}

	@Override
	public Member login(HttpSession session, Model model, String username,
						String password, String resourceUrl, String userAgent, HttpServletRequest request) {
		Member member = accessService.findMemberByNameStatus(username);
		if (member == null) {
			ModelHelper.addValidateInfo(model,
					BusinessExceptionCode.EXCEPTION_20002);
			return null;
		}

		if (member.getPassword() == null) {
			ModelHelper.addValidateInfo(model,
					BusinessExceptionCode.EXCEPTION_20004);
			return null;
		}

		if (!member.getPassword().equals(Md5Util.encrypt(password))) {
			//防撞库操作次数累计
			SafetyUtils.safetyTimes(redisTemplate, username, userAgent, IP.getRemoteAddr(request), SafetyUtils.Type.LOGIN);

			ModelHelper.addValidateInfo(model,
					BusinessExceptionCode.EXCEPTION_20001);
			return null;
		}

		// 登录权限需要数据库维护访问地址，故暂时注释
		/*if (!accessService.isEnoughPermissionsToLogin(member, resourceUrl)) {
			ModelHelper.addValidateInfo(model,
					BusinessExceptionCode.EXCEPTION_20003);
			return null;
		}*/
		
		return member;
	}

	/**
	 * 授权进入
	 *
	 * @throws Exception
	 */
	@Override
	public boolean authorizedAccess(HttpServletRequest request,
			HttpServletResponse response, String sessionUser) throws Exception {
		Object user = request.getSession().getAttribute(sessionUser);

		String ctx=request.getContextPath();
		String uri = request.getRequestURI();
		uri=uri.substring(uri.indexOf(ctx)+ctx.length());

		if ("/ditui/login".equals(uri) || uri.contains("/zhaohangPay/")) {
			return true;
		}

		if (user == null && !("/".equals(uri) || "/login".equals(uri) || "/sendcode".equals(uri))) {
			response.sendRedirect("/");
			return false;
		}

		// 请求的资源路径授权判断
		if (user != null) {
			Member member = (Member) user;
			boolean flag = accessService
					.isEnoughPermissions(member, uri.trim());

			if (!flag) {
				String lastUrl = request.getHeader("Referer");

				response.sendRedirect(lastUrl == null ? "/main" : lastUrl);
			}

			return flag;

		}

		return true;
	}

	/**
	 * 授权进入V2版
	 * 多了一个 uri 的参数
	 *
	 * @param request 请求
	 * @param response 响应
	 * @param sessionUser
	 * @return true false
	 * @throws Exception
	 */
	@Override
	public boolean authorizedAccessV2(HttpServletRequest request, HttpServletResponse response,
									  String sessionUser, String uri) throws Exception {
		logger.info("登录拦截seesionUser:{}"+sessionUser);

		logger.info("登录拦截seesionId:{}"+request.getSession().getId());
		Object user = request.getSession().getAttribute(sessionUser);
		HttpSession session = request.getSession();

		/**
		 * 如果主动传入的 uri 为空，则没有要重新定向的 url 取默认的
		 */
		if(uri == null){
			uri = request.getRequestURI();
			session.setAttribute("ipIllegal", false);
		}else{
			session.setAttribute("ipIllegal", true);
		}
//		if (dev){
//			session.setAttribute("ipIllegal", false);
//		}
		String ctx = request.getContextPath();
//		uri=uri.substring(uri.indexOf(ctx));
		if (user != null) {
			logger.info("进入登录拦截,用户已登录");
			uri = uri.substring(uri.indexOf(ctx));
		} else {
			logger.info("进入登录拦截,用户未登录");
			uri = request.getRequestURI();
			uri = uri.substring(uri.indexOf(ctx) + ctx.length());
		}
		/**
		 * 一些特殊的处理
		 */
		if (user == null && !("/".equals(uri) || "/login".equals(uri) || "/sendcode".equals(uri))) {
			response.sendRedirect("/");
			return false;
		}

		// 请求的资源路径授权判断
		if (user != null) {
			Member member = (Member) user;
			boolean flag = accessService
					.isEnoughPermissions(member, uri.trim());

			if (!flag) {
				String lastUrl = request.getHeader("Referer");

				response.sendRedirect(lastUrl == null ? "/main" : lastUrl);
			}
			return flag;
		}

		return true;
	}
}
