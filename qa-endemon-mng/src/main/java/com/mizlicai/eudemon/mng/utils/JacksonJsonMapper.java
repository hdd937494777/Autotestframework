package com.mizlicai.eudemon.mng.utils;

import org.codehaus.jackson.map.ObjectMapper;

/**
 * 
 * 
 * 
 *
 * Created by chars on 2015 下午4:30:24.
 *
 * Copyright © mizhuanglicai
 */
public final class JacksonJsonMapper {
	static volatile ObjectMapper objectMapper = null;

	private JacksonJsonMapper() {
	}

	public static ObjectMapper getInstance() {
		if (objectMapper == null) {
			objectMapper = new ObjectMapper();
		}
		return objectMapper;
	}
}
