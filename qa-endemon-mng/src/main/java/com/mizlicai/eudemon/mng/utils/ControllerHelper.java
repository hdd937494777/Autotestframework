package com.mizlicai.eudemon.mng.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 * 
 * 
 *
 *
 * Copyright © mizhuanglicai
 */
public class ControllerHelper {

	/**
	 * 获取请求跟路径
	 * 
	 * @param request
	 * @return
	 */
	public static String getBasePath(HttpServletRequest request) {
		String base = request.getScheme() + "://" + request.getServerName()
				+ ":" + request.getServerPort() + request.getContextPath()
				+ "/";
		return base;
	}
}
