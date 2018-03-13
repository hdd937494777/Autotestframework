package com.mizlicai.eudemon.mng.exception;

/**
 * 
 * 
 * 
 *新用户
 * Created by chars on 2015 下午4:14:45.
 *
 * Copyright © mizhuanglicai
 */
public enum BusinessExceptionCode {
	EXCEPTION_0(0, "OK"),
	
	EXCEPTION_1(1, "%s"),
	
	
	EXCEPTION_1000(1000, "未知错误"),

	EXCEPTION_1001(1001, "请输入11位手机号码"),
	EXCEPTION_1002(1002, "请输入正确的11位手机号码"),
	EXCEPTION_1003(1003, "请输入手机号码"),
	EXCEPTION_1004(1004, "该号码已经被注册"),
	EXCEPTION_1005(1005, "该手机号码还未注册"),

	

	EXCEPTION_1010(1010, "请输入6～16位长度的密码"), 
	EXCEPTION_1011(1011, "请输登录密码"),
	EXCEPTION_1012(1012, "请输新登录密码"),
	EXCEPTION_1013(1013, "新密码不能与当前密码相同"),
	EXCEPTION_1014(1014, "手机号或者密码不正确"),
	EXCEPTION_1015(1015, "请输入手机号和密码"),
	EXCEPTION_1016(1016, "当前密码错误"),
	EXCEPTION_1017(1017, "openid不能为空"),
	EXCEPTION_1018(1018, "账户不存在，请前往注册页面注册"),
	EXCEPTION_1019(1019, "该用户不存在"),
	

	

	EXCEPTION_1021(1021, "请输入验证码"),
	EXCEPTION_1022(1022, "验证码错误，请重新输入"),
//	EXCEPTION_1023(1023, "验证码超时，请重新获取"),
	EXCEPTION_1024(1024, "请输入校验码"),
	EXCEPTION_1025(1025, "校验码错误，请重新输入"),
	EXCEPTION_1026(1026, "验证码超时，请重新获取"),

	EXCEPTION_1027(1027, "该红包已被使用"),
	EXCEPTION_1028(1028, "该红包只能在8月8日当天使用"),
	EXCEPTION_1029(1029, "新手产品不能使用券包"),
	EXCEPTION_1030(1030, "该银行卡已存在"),
	EXCEPTION_1031(1031, "请输入真实姓名"),
	EXCEPTION_1032(1032, "真实姓名与账户姓名不符"),
	EXCEPTION_1033(1033, "身份证与账户身份证不符"),
	EXCEPTION_1034(1034, "不支持该银行卡"),
	EXCEPTION_1035(1035, "请输入身份证号"),
	EXCEPTION_1036(1036, "银行卡不存在"), 
	EXCEPTION_1037(1037, "抱歉，您未满18周岁，无法购买理财产品"),
	
	EXCEPTION_1038(1038, "非常抱歉，此产品只有新用户才能购买"),
	EXCEPTION_1039(1039, "非常抱歉，此产品只有专属用户才能购买"),

	EXCEPTION_1040(1040, "该订单已过期，请重新购买"),
	EXCEPTION_1041(1041, "该订单已付款"),
	EXCEPTION_1042(1042, "请输入姓名、身份证号和银行卡号。"),
	EXCEPTION_1043(1043, "一个身份证号只能绑定一个手机账号"),
	EXCEPTION_1044(1044, "请输入银行卡号"),
	EXCEPTION_1045(1045, "订单不存在"),
	EXCEPTION_1046(1046, "庄主，该红包不在有效期内哦"),
	
	EXCEPTION_1052(1052,"米庄宝可用本金不足，请使用其他方式支付"),
	EXCEPTION_1053(1053,"庄主，购买30天(含)以上的理财产品才能使用该红包哦"),
	EXCEPTION_1054(1054,"庄主，购买金额1000元以上才能使用该红包哦"),
	EXCEPTION_1055(1055,"该银行卡与米庄宝绑定的银行卡不一致"),
	EXCEPTION_1056(1056,"该银行单笔最高购买金额为%s元"),
	EXCEPTION_1057(1057, "产品剩余份额不足"), 
	EXCEPTION_1058(1058, "该产品单笔最低购买金额为%s元"), 
	EXCEPTION_1059(1059, "该产品单笔最高购买金额为%s元"), 
	EXCEPTION_1060(1060, "身份证号错误，请重新输入"), 
	EXCEPTION_1061(1061, "银行卡号错误，请重新输入"),
	EXCEPTION_1062(1062, "购买金额必须为%s的整数倍"),
	EXCEPTION_1063(1063, "剩余份额不足，您最多还可以购买%s元"),
	EXCEPTION_1064(1064, "订单金额不合法"),
	EXCEPTION_1065(1065, "有用户下单暂未付款，您多刷新页面，还会有机会购买到此产品。"), 
	EXCEPTION_1066(1066, "手慢了...产品已售完！"),
	EXCEPTION_1067(1067, "银行卡不能为空"),
	EXCEPTION_1068(1068, "产品不存在"),

	EXCEPTION_1069(1069, "版本一致"), 
	EXCEPTION_1070(1070, "没有版本信息"), 
	EXCEPTION_1071(1071, "协议不存在"),
	EXCEPTION_1072(1072, "产品不能购买"),

	EXCEPTION_1073(1073, "请输入整数进行取现，或全部提取"),
	
	EXCEPTION_1074(1074, "提现金额不合法"),
	EXCEPTION_1075(1075, "没有可提现的本金"),
	EXCEPTION_1076(1076, "最高可提现金额为%s元"),
	EXCEPTION_1077(1077, "提现金额须为100的整数倍"),
	EXCEPTION_1078(1078, "您今日的提现次数已用完，请明天再来哦"),
	
	EXCEPTION_1079(1079, "您的米庄宝购买额度已满"),
	EXCEPTION_1080(1080, "您最多还可购买%s元米庄宝"),
	EXCEPTION_1081(1081, "现在提现会遇到节假日，到账时间在下一个工作日，确定要提现吗？"),
	
	
	EXCEPTION_1082(1082, "购买理财金产品只能支付1元"),
	EXCEPTION_1083(1083, "该理财金已被使用"),
	EXCEPTION_10083(10083, "没有可使用的理财金"),
	EXCEPTION_1084(1084, "您已领取过8888元理财金"),
	EXCEPTION_1085(1085, "您已领取过2元红包"),
	EXCEPTION_1086(1086, "成功领取8888元理财金"),
	EXCEPTION_1087(1087, "成功领取2元红包"),
	
	EXCEPTION_1088(1088, "本月提现次数已用完"),
	EXCEPTION_1089(1089, "暂无可提现金额"),
	
	EXCEPTION_1090(1090, "账号过期，请重新登录"),

	EXCEPTION_2000(2000, "系统错误。"),
	EXCEPTION_2001(2001, "系统错误，注册失败。"),
	EXCEPTION_2002(2002, "系统错误，修改密码失败。"), 
			
	EXCEPTION_2003(2003, "系统错误，生成订单失败。"),
	EXCEPTION_2004(2004, "非法的订单。"),
	EXCEPTION_2005(2005, "系统错误，修改交易密码失败。"), 
	
	EXCEPTION_2020(2020, "网关错误。"),
	EXCEPTION_2022(2022, "支付网关不支持"),
	EXCEPTION_2023(2023, "发送支付验证码短信失败"),
	EXCEPTION_2024(2024, "支付短信验证码错误"),
	EXCEPTION_2051(2051, "用户消息不存在"),
	EXCEPTION_2052(2052, "非法获取消息。"),

	EXCEPTION_8000(8000, "您已经领取过红包了。"),
	EXCEPTION_8001(8001, "编号对应的红包不存在。"),
	EXCEPTION_8002(8002, "编号不能为空。"),
	EXCEPTION_8005(8005, "请先绑定银行卡。"),
	
	EXCEPTION_8006(8006, "00:00 – 00:45结算中，米庄宝无法提现哦"),
	EXCEPTION_8007(8007, "00:00 – 00:45结算中，无法使用米庄宝哦"),
	EXCEPTION_8008(8008, "00:00 – 00:45结算中，无法购买米庄宝哦"),
	
	EXCEPTION_9001(9001, "此IP发送短信过于频繁，请30分钟后再试"),
	EXCEPTION_9002(9002,"短信发送过于频繁，请30秒后再试"),
	
	
	
	EXCEPTION_10001(10001,"收货人姓名不能为空"),
	EXCEPTION_10002(10002,"收货人手机不能为空"),
	EXCEPTION_10003(10003,"收货人地址不能为空"),
	EXCEPTION_10004(10004,"姓名不能为空"),
	EXCEPTION_10005(10005,"手机不能为空"),
	
	
	
	EXCEPTION_10100(10100,"还没设置交易密码"),
	EXCEPTION_10101(10101,"交易密码不能为空"),
	EXCEPTION_10102(10102, "请输新交易密码"),
	EXCEPTION_10103(10103, "新密码不能和原密码相同"),
	EXCEPTION_10104(10104, "交易密码不正确,请重新输入"),
	EXCEPTION_10108(10108, "原交易密码错误"),
	EXCEPTION_10109(10109, "请输原交易密码"),
	
	EXCEPTION_10400(10400,"庄主，购买30天(含)以上的理财产品才能使用该红包哦"),
	EXCEPTION_10401(10401,"庄主，购买50天(含)以上的理财产品才能使用该红包哦"),
	EXCEPTION_10402(10402,"庄主，购买80天(含)以上的理财产品才能使用该红包哦"),
	EXCEPTION_10403(10403,"庄主，购买金额1000元以上才能使用该红包哦"),
	EXCEPTION_10404(10404,"庄主，购买金额3000元以上才能使用该红包哦"),
	EXCEPTION_10405(10405,"庄主，购买金额6000元以上才能使用该红包哦"),
	EXCEPTION_10406(10406,"庄主，购买金额15000元以上才能使用该红包哦"),
	EXCEPTION_10407(10407,"庄主，购买金额25000元以上才能使用该红包哦"),
	EXCEPTION_10408(10408,"庄主，购买金额100000元以上才能使用该红包哦"),
	
	EXCEPTION_10410(10410,"产品理财周期【%s】（含）以上，才能使用该红包或加息券"),
	EXCEPTION_10411(10411,"购买金额%s元（含）以上，才能使用该红包或加息券"),
	
	
	
	
	
	EXCEPTION_10200(10200,"非常抱歉,只有开通米庄合伙人计划才能购买此产品"),
	
	EXCEPTION_10300(10300,"第一次米庄宝"),
	EXCEPTION_10301(10301,"每日最多可提现5万"),
	
	EXCEPTION_20001(20001,"密码错误！"),
	EXCEPTION_20002(20002,"没有此用户！"),
	EXCEPTION_20003(20003,"权限不足！"),
	EXCEPTION_20004(20004,"联系管理员初始化密码!"),

	EXCEPTION_21000(21000, "账号过期，请重新登录"),

    EXCEPTION_31000(31000, "发送易宝支付短信验证码失败"),

    EXCEPTION_41000(41000, "爱财接口错误，批量插入融资项目信息失败"),
    EXCEPTION_41001(41001, "爱财接口错误，批量插入资产信息失败"),
    EXCEPTION_41002(41002, "爱财接口错误，批量插入还款信息失败"),
    EXCEPTION_41003(41003, "爱财接口错误，批量插入通知信息失败"),
    EXCEPTION_41004(41004, "爱财接口错误，批量插入资产修改信息失败"),

    EXCEPTION_50000(50000, "请联系管理员设置手机号码"),

    EXCEPTION_60000(60000, "原登录密码错误!"),
	EXCEPTION_60001(60001, "2次输入的新密码不同!"),
	EXCEPTION_60002(60002, "旧密码与新密码相同!"),
    EXCEPTION_60003(60003, "庄主，您最多还可购买该产品%s元。"),

	
	 EXCEPTION_70000(70000, "银联支付预留手机号码不能为空"),
	 EXCEPTION_70001(70001, "非法支付渠道订单"),
	 EXCEPTION_70002(70002, "银联支付签名信息不符合"),
	 EXCEPTION_70003(70003, "银联支付订单提交失败"),
	 EXCEPTION_70004(70004, "请输入正确的验证码"),
	 EXCEPTION_70005(70005, "银联支付预留手机号码不对"),
	 EXCEPTION_70006(70006, "该订单已经提交到支付平台"),
	 EXCEPTION_70007(70007, "订单已经过期，请重新下单"),
	 EXCEPTION_70008(70008, "验证码已超时，请重新获取"),
	 EXCEPTION_70009(70009, "请勿重复下单"),
	 EXCEPTION_70010(70010, ""),
	 EXCEPTION_70011(70011, "该银行卡实名认证失败"),
	 
	 EXCEPTION_70012(70012, "请求超时,请稍后再试"),
    ;

	private int code;
	private String description;

	private BusinessExceptionCode(int code, String description) {
		setCode(code);
		setDescription(description);
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public static BusinessExceptionCode getBusinessExceptionCodeFromCode(
			Integer code) {
		BusinessExceptionCode excode = null;
		if (code == null)
			code = 1000;
		for (BusinessExceptionCode item : BusinessExceptionCode.values()) {
			if (item.getCode() == code.intValue()) {
				excode = item;
				break;
			}
		}
		if (excode == null)
			excode = EXCEPTION_1000;
		return excode;
	}
	
	public static void main(String[] args) {
		try {
			throw new BusinessException(
					BusinessExceptionCode.EXCEPTION_1058,100);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
	}
}
