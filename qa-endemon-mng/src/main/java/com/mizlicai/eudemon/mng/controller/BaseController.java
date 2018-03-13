package com.mizlicai.eudemon.mng.controller;

import com.mizlicai.eudemon.mng.exception.ManagerExceptionCode;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * 
 * 
 * 
 * 
 *
 * Created by aone on 2015 上午10:17:56.
 *
 * Copyright © mizhuanglicai
 */
public class BaseController {

	protected String STATUS_SUCCESS = "success";
	protected String STATUS_FAILD = "faild";

	@InitBinder
	// 此处的参数也可以是ServletRequestDataBinder类型
	public void initBinder(WebDataBinder binder) throws Exception {
		// 注册自定义的属性编辑器
		// 1、日期属性编辑器
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		CustomDateEditor dateEditor = new CustomDateEditor(df, true);
		// 表示如果命令对象有Date类型的属性，将使用该属性编辑器进行类型转换
		binder.registerCustomEditor(Date.class, dateEditor);

	}

	protected void setSuccess( Map<String, Object> map){
		map.put("retCode", ManagerExceptionCode.SUCCESS.getCode());
		map.put("retMsg", ManagerExceptionCode.SUCCESS.getMessage());
	}

}
