package com.mizlicai.eudemon.mng.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MoneyUtil {
	/**
	 * 分转换为元
	 * 
	 * Created by eric on 2016年6月16日上午11:02:10.
	 *
	 * Copyright © mizhuanglicai
	 */
	public static double fen2Yuan(Integer fen){
		BigDecimal bd = new BigDecimal(fen);
		bd = bd.divide(new BigDecimal(100));
		
		return bd.setScale(2, BigDecimal.ROUND_HALF_EVEN).doubleValue();
	}
	
	/**
	 * 元转换为分
	 * 
	 * Created by eric on 2016年6月16日上午11:02:25.
	 *
	 * Copyright © mizhuanglicai
	 */
	public static int yuan2Fen(float yuan){
		BigDecimal bd = new BigDecimal(yuan);
		bd = bd.multiply(new BigDecimal(100)).setScale(0, RoundingMode.HALF_EVEN);
		
		return bd.intValue();
	}
	
	/**
	 * 
	* @Description: 价格打折
	* @param @param amount
	* @param @param rate
	* @param @return    设定文件 
	* @return int    返回类型 
	* @throws
	 */
	public static int disaccount(Integer amount, String rate){
		BigDecimal bd = new BigDecimal(amount);
		bd = bd.multiply(new BigDecimal(rate)).setScale(0, RoundingMode.HALF_EVEN);
		
		return bd.intValue();
	}
}
