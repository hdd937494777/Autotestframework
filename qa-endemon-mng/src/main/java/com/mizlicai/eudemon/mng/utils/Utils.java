package com.mizlicai.eudemon.mng.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.apache.commons.lang3.StringUtils.*;
import static org.apache.commons.lang3.time.DateFormatUtils.ISO_DATETIME_FORMAT;
import static org.apache.commons.lang3.time.DateFormatUtils.ISO_DATE_FORMAT;
import static org.apache.commons.lang3.time.DateUtils.*;

/**
 * 
 * 
 * 
 *
 *
 * Copyright © mizhuanglicai
 */
public class Utils {


	public static final String UTF_8 = org.apache.commons.codec.CharEncoding.UTF_8;

	public static final String MYSQL_DATE_FORMAT = "DATE_FORMAT(%s, \'%%Y-%%m-%%d\')";

	static volatile ObjectMapper objectMapper = null;

	private Utils() {
	}

	public static SimpleDateFormat format = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");

	public static String formatDateTime(Date date) {
		return replace(ISO_DATETIME_FORMAT.format(date), "T", " ");
	}

	public static String formatDateTime_i18n(Date date) {
		return ISO_DATETIME_FORMAT.format(date);
	}

	public static String formatDate(Date date) {
		return ISO_DATE_FORMAT.format(date);
	}

	public static String formatDateTime(Calendar calendar) {
		return replace(ISO_DATETIME_FORMAT.format(calendar), "T", " ");
	}

	public static String formatDateTime_i18n(Calendar calendar) {
		return ISO_DATETIME_FORMAT.format(calendar);
	}

	public static String formatDate(Calendar calendar) {
		return ISO_DATE_FORMAT.format(calendar);
	}

	public static String getServerName(String url) {
		if (isNotBlank(url)) {
			if (url.startsWith("http://")) {
				return url.substring(7);
			} else if (url.startsWith("https://")) {
				return url.substring(8);
			}
		}
		return url;
	}

	/**
	 * 对对象中对String字符串属性过滤空格
	 * 
	 * @param obj
	 * @return
	 */
	public static Object objectTrim(Object obj) {
		JSONObject json = JSON.parseObject(JSON.toJSONString(obj));
		Iterator<String> iterator = json.keySet().iterator();
		while (iterator.hasNext()) {
			String key = iterator.next();

			if (json.get(key) != null) {
				String value = json.get(key).toString().trim();
				json.put(key, value);
			}
		}
		obj = JSONObject.parseObject(json.toJSONString(), obj.getClass());

		return obj;
	}

	/**
	 * 获取异常日志
	 * 
	 * @param ex
	 * @return
	 */
	public static String getExceptionLog(Exception ex) {
		StringBuffer sb = new StringBuffer();

		sb.append(ex.getClass().getName() + ":" + ex.getMessage() + "\n");
		StackTraceElement[] ste = ex.getStackTrace();
		for (int i = 0; ste != null && i < ste.length; i++) {
			sb.append("at " + ste[i].getClassName() + "."
					+ ste[i].getMethodName() + "(" + ste[i].getFileName() + ":"
					+ ste[i].getLineNumber() + ")\n");
		}
		return sb.toString();
	}

	@SuppressWarnings("rawtypes")
	public static String toJSON(Object obj) {
		ObjectMapper mapper = new ObjectMapper();
		String json = "";
		try {
			json = mapper.writer().writeValueAsString(
					obj == null ? new HashMap() : obj);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return json;
	}

	public static boolean isCredit51(String openid) {
		return isNotBlank(openid)
				&& !trimToEmpty(openid).equalsIgnoreCase("${openid}") ? true
				: false;
	}

	public static Date getNextDayZero() {
		return setSeconds(setMinutes(setHours(addDays(new Date(), 1), 0), 0), 0);
	}

	/**
	 * 
	 * @param active
	 *            是否活跃用户（即老用户）
	 * @return
	 */
	public static Integer getBonus(int min, int max) {
		Random seed = new Random();
		int[] pool = new int[max - min + 1];
		for (int i = min; i <= max; i++) {
			pool[i - min] = i;
		}
		int total = 0, n = 1;
		for (int i = 0; i < n; i++) {
			total += pool[seed.nextInt(pool.length)];
		}
		return total / n;
	}

	public static BigDecimal getIncrementInterestRate(BigDecimal base,
			BigDecimal increment, BigDecimal max) {
		BigDecimal interestRate = new BigDecimal("0");
		if (base != null && increment != null && max != null) {
			BigDecimal temp = base.add(increment);
			interestRate = temp.compareTo(max) > 0 ? max : temp;
		}
		return interestRate;
	}
}
