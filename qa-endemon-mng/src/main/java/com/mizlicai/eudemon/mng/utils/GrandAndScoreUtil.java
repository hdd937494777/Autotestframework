package com.mizlicai.eudemon.mng.utils;

/**
 * 
     * @author carro     
     * Copyright © mizhuanglicai  
     * @created 2016年10月11日 下午7:08:07
 */
public class GrandAndScoreUtil {
	
	/**
	 * 分数对应的星数（会员等级）
	 * @param score
	 * @return
	 */
	public static String obtainLevel(Integer score){
		String result = "";
		
		if(0 < score && score <= 20){
			result = "★";
		}else if(21 <= score && score <= 40){
			result = "★★";
		}else if(41 <= score && score <= 60){
			result="★★★";
		}else if(61 <= score && score <= 80){
			result="★★★★";
		}else{
			result = "★★★★★";
		}
	
		return result;
	}

}
