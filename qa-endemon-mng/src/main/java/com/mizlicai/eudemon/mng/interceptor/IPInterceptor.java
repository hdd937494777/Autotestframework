package com.mizlicai.eudemon.mng.interceptor;

import com.mizlicai.eudemon.mng.service.IpConfigService;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * 
 * 
 *
 * Created by chars on 2015 下午2:03:55.
 *
 * Copyright © mizhuanglicai
 */
public class IPInterceptor extends HandlerInterceptorAdapter {

	@Resource
	private IpConfigService ipConfigService;

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		boolean visitable = ipConfigService.findByIp(request.getRemoteAddr());
		if(1==1)return true;
		if (!visitable) {
			response.getOutputStream().write("IP Illegal".getBytes());
			response.flushBuffer();
			return false;
		}
		return true;
	}
}
