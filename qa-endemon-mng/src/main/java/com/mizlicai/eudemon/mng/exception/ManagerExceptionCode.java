package com.mizlicai.eudemon.mng.exception;

public enum ManagerExceptionCode {
	SUCCESS("SUCCESS", "响应成功"),
	FAILED("FAILED","响应失败"),
	AUTH_ERROR("AUTH_ERROR", "验签失败"),
	UNGRANT("UNGRANT", "未授权"),
	USER_NOT_IN_SESSION("USER_NOT_IN_SESSION", "用户尚未登录"),
	TRADE_INFO_NOT_EXIST("TRADE_INFO_NOT_EXIST", "不存在交易信息"),
	MERCHANT_INFO_NOT_EXIST("MERCHANT_INFO_NOT_EXIST","不存在商户信息"),
	LOGIN_ERROR_COUNTS("LOGIN_ERROR_COUNTS","用户已锁定，2小时后自动解锁"),

	CAPTCHA_NOT_MATCH("CAPTCHA_NOT_MATCH", "图形验证码错误"),
	DYNAMIC_CODE_NOT_MATCH("DYNAMIC_CODE_NOT_MATCH", "手机动态码未通过验证"),
	NEW_PASSWORD_NOT_MATCH("NEW_PASSWORD_NOT_MATCH", "两次输入的新密码不一致"),
	CREDIT_MONEY_UNSUPPORTED("CREDIT_MONEY_UNSUPPORTED", "分期金额不支持"),

	SYSTEM_ERROR("SYSTEM_ERROR", "系统异常"),
	PARAMS_ERROR("PARAMS_ERROR", "参数异常"),
	IS_EXITS_EXPIRED("IS_EXITS_EXPIRED","存在逾期账单"),
	IDCARD_NOT_MATCH("IDCARD_NOT_MATCH","身份证号非法"),

	NOT_EXITS_USERNAME("NOT_EXITS_USERNAME","用户名不存在"),

	PASSWORD_LENGTH_INVALID("PASSWORD_LENGTH_INVALID", "请设置6-20位长度的新密码"),
	PASSWORD_CONTAINS_NULLCHAR("PASSWORD_CONTAINS_NULLCHAR","密码不能包含空字符"),
	MOBILE_IS_ERROR("MOBILE_IS_ERROR","手机号不合法"),

	PASSWORD_ERROR("PASSWORD_ERROR","密码错误"),
	LOGIN_SUCESS("LOGIN_SUCCESS","登录成功"),
	EXIST_PAYED_BILL("EXIST_PAYED_BILL","存在已付款账单，已无法取消订单"),

	PAYBILL_NOT_EXIST("NOT_EXIST_PAYBILL","查无此支付单信息"),
	ATTACH_NOT_EXIST("ATTACH_NOT_EXIST", "附件不存在"),

	PURCHASE_BILL_NOT_EXIST("PURCHASE_BILL_NOT_EXIST", "采购订单信息不存在"),
	PURCHASE_BILL_NOT_PENDING_CHECK("PURCHASE_BILL_NOT_PENDING_CHECK", "采购订单不是待审核状态"),
	PURCHASE_BILL_NOT_CHECK_PASS("PURCHASE_BILL_NOT_PENDING_CHECK", "采购订单不是审核成功状态"),
	CHECK_REASON_NOT_CORRECT("CHECK_REASON_NOT_CORRECT", "请选择正确的审核意见"),
	CHECK_REMARK_NOT_BLANK("CHECK_REMARK_NOT_BLANK", "请填写审核备注");


	public String code;
	public String message;

	ManagerExceptionCode(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}