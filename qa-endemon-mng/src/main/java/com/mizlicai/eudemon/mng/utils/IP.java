package com.mizlicai.eudemon.mng.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

import static org.springframework.util.StringUtils.hasText;

/**
 * 
 * 
 * 
 * 
 *
 * Created by chars on 2015 下午4:30:48.
 *
 * Copyright © mizhuanglicai
 */
public class IP {
	private static final Log LOGGER = LogFactory.getLog(IP.class);

	/**
	 * 获取访问者IP
	 * 
	 * 在一般情况下使用Request.getRemoteAddr()即可，但是经过nginx等反向代理软件后，这个方法会失效。
	 * 
	 * 本方法先从Header中获取X-Real-IP，如果不存在再从X-Forwarded-For获得第一个IP(用,分割)，
	 * 如果还不存在则调用Request .getRemoteAddr()。
	 * 
	 * @param request
	 * @return
	 */
	public static String getRemoteAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-real-ip");
		if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
			return ip;
		}
		ip = request.getHeader("X-Real-IP");
		if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
			return ip;
		}
		ip = request.getHeader("X-Forwarded-For");
		if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
			// 多次反向代理后会有多个IP值，第一个为真实IP。
			int index = ip.indexOf(',');
			if (index != -1) {
				return ip.substring(0, index);
			} else {
				return ip;
			}
		} else {
			return request.getRemoteAddr();
		}
	}

	/**
	 * 根据ip获取城市
	 * 
	 * @param ip
	 * @return
	 */
	public static String getCityFromIp(String ip) {
		String city = "";
		if (hasText(ip)) {

			String url = "http://ip.taobao.com/service/getIpInfo.php?ip=" + ip;
			try {
				@SuppressWarnings("unchecked")
				Map<String, Object> result = JacksonJsonMapper.getInstance()
						.readValue(HttpRequest.httpGet(url, null), Map.class);
				Integer code = (Integer) result.get("code");
				if (code != null && code.equals(0)) {
					@SuppressWarnings("unchecked")
					Map<String, Object> data = (Map<String, Object>) result
							.get("data");
					city = (String) data.get("city");
				}
			} catch (Exception e) {
				LOGGER.error(e.getMessage());
				e.printStackTrace();
			}
		}
		return city;
	}
}
