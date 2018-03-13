package com.mizlicai.eudemon.mng.interceptor;
import com.mizlicai.eudemon.mng.service.InternalLogService;
import com.mizlicai.eudemon.mng.service.IpConfigService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserSessionInterceptor implements HandlerInterceptor {

	protected final Logger logger = Logger
			.getLogger(UserSessionInterceptor.class);

	@Value("#{settings['session.user.name']}")
	protected String sessionUser;

	@Resource
	private InternalLogService internalLogService;

	@Resource
	private IpConfigService ipConfigService;

	@Override
	public boolean preHandle(final HttpServletRequest request,
			HttpServletResponse response, Object handler){
		boolean visitable = ipConfigService.findByIp(request.getRemoteAddr());
		String uri = null;
//		if (!visitable) {
//			uri = "/sendcode";
//		}
		logger.info(uri);
		logger.info("拦截器第一步");
		try {
			return internalLogService.authorizedAccessV2(request, response,
					sessionUser, uri);
		}catch (Exception e){
			e.printStackTrace();
		}
		logger.info("拦截器第二步");
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}
}
