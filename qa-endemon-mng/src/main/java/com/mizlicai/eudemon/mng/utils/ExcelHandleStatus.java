package com.mizlicai.eudemon.mng.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * 	   处理各种导出状态对应中文
     * @author carro     
     * Copyright © mizhuanglicai  
     * @created 2016年9月21日 下午3:12:33
 */
public class ExcelHandleStatus {
	
	/**
	 * 处理对应支付状态
	 * @param status
	 * @return
	 */
	public static String handlePayBillStatus(String status){
		
		String pStatus = "";
		if(StringUtils.isNotEmpty(status)){
		switch (status)	{
			
			case "SUCCESS":
					pStatus =  "支付成功" ; break;
					
			case "NEW"	:
					pStatus = "待支付";break;
					
			case "REFUND":
					pStatus = "已退款";break;
		
			case "CANCEL":
					pStatus = "已取消";break;
					
			case "FAIL" :
					pStatus = "支付失败"; break;
					
			default : break;
		}}
		return pStatus;
		
	}
	
	/**
	 * 处理对应审核状态
	 * @param settleStatus
	 * @return
	 */
	public static String handleSettleStatus(String settleStatus){
		String sStatus = "";
		if(StringUtils.isNotEmpty(settleStatus)){
		switch (settleStatus)	{
		
		case "CHECK_INIT":
				sStatus =  "待审核" ; break;
				
		case "KEFU_CHECK_PASS"	:
				sStatus = "客服审核通过";break;
				
		case "KEFU_CHECK_DENY":
				sStatus = "客服审核拒绝";break;
	
		case "MANAGER_CHECK_PASS":
				sStatus = "主管审核通过";break;
				
		case "MANAGER_CHECK_DENY" :
				sStatus = "主管审核拒绝"; break;
				
		case "CEO_CHECK_PASS":
			sStatus = "CEO审核通过";break;

		case "CEO_CHECK_DENY":
			sStatus = "CEO审核拒绝";break;
			
		case "CHECK_SUCCESS" :
			sStatus = "审核通过"; break;		
				
			default : break;
		}}
		return sStatus;
		
	}

	/**
	 * 返回账单对应状态
	 * @param billStatus
	 * @return
	 */
	public static String handleBillStatus(String billStatus){
		String bStatus = "";
		
		if(billStatus != null){
		switch (billStatus){
			
			case "NOPAY":
				bStatus =  "未还款" ; break;
					
			case "PAYED"	:
				bStatus = "已还款";break;
					
			case "EXPIRED":
				bStatus = "逾期";break;
		
			case "REFUND":
				bStatus = "退款";break;
			case "CANCEL":
				bStatus = "取消"; break;
				default : bStatus = "N/A";break;
			}	
		}
		return bStatus;
	}
	
	/**
	 * 返回订单状态
	 * @param orderStatus
	 * @return
	 */
	public static String  handleOrderStatus(String orderStatus){
		String oStatus = "";
		if(orderStatus != null ){
			
			switch (orderStatus){
			
			case "NEW":
				oStatus =  "新建" ; break;
					
			case "UNCHECK"	:
				oStatus = "待审核";break;
					
			case "CHECK":
				oStatus = "审核通过";break;
		
			case "UNPASS":
				oStatus = "审核不通过";break;	
				
			case "SUCCESS":
				oStatus =  "下单成功" ; break;
					
			case "FAILED"	:
				oStatus = "下单失败";break;
					
			case "AUTOCANCEL":
				oStatus = "自动取消";break;
		
			case "CHECKCANCEL":
				oStatus = "主动取消";break;	
				
			case "REFUND"	:
				oStatus = "已退款";break;						
				default : break;
			}	
				
		}
		return oStatus;	
	}
	
	/**
	 * 结算
	 * @param pStatus
	 * @return
	 */
	public static String handleSmentStatus(String pStatus){
		String sStatus = "";
		if(StringUtils.isNotEmpty(pStatus)){
		switch (pStatus)	{
		
		case "CHECK_SUCCESS":
			sStatus =  "待结算" ; break;
				
		case "SETTLING"	:
			sStatus = "结算中";break;		
			
		case "SETTLED":
			sStatus =  "已结算" ; break;
				
				
			default : break;
		}}
		return sStatus;
		
	}
	
	public static String handleSSettleSatus(String ssStatus){
		String sStatus = "";
		
		if(StringUtils.isNotEmpty(ssStatus)){
			switch (ssStatus)	{
			
			case "SETTLING":
				sStatus =  "未打款" ; break;
					
			case "SETTLED"	:
				sStatus = "已打款";break;		
				
			case "DENY":
				sStatus =  "驳回" ; break;
					
					
				default : break;
			}}
			
		return sStatus;
		
	}
	
	/**
	 * 处理分销商状态
	 * @param status
	 * @return
	 */
	public static String handleScmAccountStatus(String status){
		
		String pStatus = "";
		if(StringUtils.isNotEmpty(status)){
		switch (status)	{
			
			case "UNCHECK":
					pStatus =  "未审核" ; break;
					
			case "DENY"	:
					pStatus = "未通过";break;
					
			case "EXPIRE":
					pStatus = "过期";break;
		
			case "ACTIVE":
					pStatus = "激活";break;
					
			case "FROZEN" :
					pStatus = "冻结"; break;
					
			case "CHECKING" :
				pStatus = "审核中"; break;		
					
			default : break;
		}}
		return pStatus;
		
	}
	
	/**
	 * 
	 * @param status
	 * @return
	 */
	public static String handleScmOrderStatus(String status){
		
		String pStatus = "";
		if(StringUtils.isNotEmpty(status)){
			switch (status)	{
				
				case "NEW":
						pStatus =  "待支付" ; break;
						
				case "SUCCESS"	:
						pStatus = "已支付";break;
						
				case "UNCHECK":
						pStatus = "待复核";break;
			
				case "UNPAY":
						pStatus = "待打款";break;
						
				case "UNREPAY" :
						pStatus = "待还款"; break;
						
				case "PAYED" :
					pStatus = "已 还款"; break;		
				
				case "CANCEL" :
					pStatus = "已取消"; break;
					
				case "REFUND" :
					pStatus = "已退款"; break;
				
				case "COMPLETE" :
					pStatus = "已完成"; break;	
					
				case "REFUNDING" :
					pStatus = "退款中"; break;
					
				case "INITFAILED" :
					pStatus = "初审失败"; break;
					
				case "REPFAILED" :
					pStatus = "复审失败"; break;	
				default : break;
			}
		}
		return pStatus;
		
	}
	
	/**
	 * 订单融结算单结算状体
	 * @param status
	 * @return
	 */
	public static String handleSettleScmOrder(String status){
		
		String sStatus = "";
		
		if(StringUtils.isNotEmpty(status)){
			switch (status)	{
			
			case "UNSETTE":
				sStatus =  "未结算" ; break;
					
			case "SETTLING"	:
				sStatus = "结算中";break;		
				
			case "SETTLED":
				sStatus =  "已结算" ; break;
						
				default : break;
			}
		}
			
		return sStatus;
		
	}
	
	
	/**
	 * 订单融订单结算状体
	 * @param status
	 * @return
	 */
	public static String handleSettleStatusOrder(String status){
		
		String sStatus = "";
		
		if(StringUtils.isNotEmpty(status)){
			
			switch (status)	{
			
			case "":
				sStatus =  "未开始" ; break;
				
			case "NEW":
				sStatus =  "未开始" ; break;
					
			case "FIRST_UNSETTLE"	:
				sStatus = "首款待结算";break;		
				
			case "FIRST_SETTLING":
				sStatus =  "首付结算中" ; break;
				
			case "FIRST_SETTLED":
				sStatus =  "首款已结算" ; break;
					
			case "TAIL_UNSETTLE"	:
				sStatus = "尾款待结算";break;		
				
			case "TAIL_SETTING":
				sStatus =  "尾款结算中" ; break;
			
			
			case "TAIL_SETTLED":
				sStatus =  "尾款已结算" ; break;
					
			case "REFUND_UNSETTLE"	:
				sStatus = "退款待结算";break;		
				
			case "REFUND_SETTLING":
				sStatus =  "退款结算中" ; break;	
				
			case "REFUND_SETTLED":
				sStatus =  "退款已结算" ; break;
					
			case "NOT_NEED_SETTLED"	:
				sStatus = "无需结算";break;		
			
				default : break;
			}					
			
		}
			
		return sStatus;
		
	}
	
	
	public static String handleUserStatus(String status){
		String result = "";
		switch (status)	{
		case "FREEZE":
			result =  "冻结" ; break;
		case "ACTIVE":
			result =  "激活" ; break;
				
		case "INACTIVE":
			result = "未激活";break;
			
			default : break;
		}					
		return result;
	}
}
