package com.mizlicai.cashier.data;

import com.mizlicai.cashier.enums.OperationType;

import java.util.Date;

/**
 * 请求信息bo
 * Created by chars on  2016/11/9 12:21
 *
 * @since 1.0.0
 */
public class RequestInfoBo /*extends BaseTableBo */{

    /**
     * 请求id
     */
    private String requestId;

    /**
     * 商户号
     */
    private String merchantAccount;

    /**
     * 用户id
     */
    private Long buyerUserId;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 用户姓名
     */
    private String userName;

    /**
     * 身份证号
     */
    private String certNo;

    /**
     * 平台来源
     */
    private String platform;

    /**
     * 商户订单号（唯一）
     */
    private String outOrderNo;

    /**
     * 交易金额(单位：分)
     */
    private Long tradeAmount;

    /**
     * 订单创建时间
     */
    private Date outOrderCreateDate;

    /**
     * 产品名称
     */
    private String productName;

    /**
     * 产品类型
     */
    private String productType;

    /**
     * 金额是否可以编辑
     */
    private boolean isAmountEditable;

    /**
     * 请求类型
     */
    private OperationType type;

    /**
     * 通知url
     */
    private String notifyUrl;

    /**
     * 返回url
     */
    private String returnUrl;

    /**
     * ip
     */
    private String ip;

    /**
     * token
     */
    private String token;

    /**
     * 支付系统返回code
     */
    private String code;

    /**
     * 支付系统返回message
     */
    private String message;

    /**
     * 银行编码
     */
    private String bankCode;

    /**
     * 银行卡号
     */
    private String cardNumber;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getMerchantAccount() {
        return merchantAccount;
    }

    public void setMerchantAccount(String merchantAccount) {
        this.merchantAccount = merchantAccount;
    }

    public Long getBuyerUserId() {
        return buyerUserId;
    }

    public void setBuyerUserId(Long buyerUserId) {
        this.buyerUserId = buyerUserId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCertNo() {
        return certNo;
    }

    public void setCertNo(String certNo) {
        this.certNo = certNo;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getOutOrderNo() {
        return outOrderNo;
    }

    public void setOutOrderNo(String outOrderNo) {
        this.outOrderNo = outOrderNo;
    }

    public Long getTradeAmount() {
        return tradeAmount;
    }

    public void setTradeAmount(Long tradeAmount) {
        this.tradeAmount = tradeAmount;
    }

    public Date getOutOrderCreateDate() {
        return outOrderCreateDate;
    }

    public void setOutOrderCreateDate(Date outOrderCreateDate) {
        this.outOrderCreateDate = outOrderCreateDate;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public boolean isAmountEditable() {
        return isAmountEditable;
    }

    public void setAmountEditable(boolean amountEditable) {
        isAmountEditable = amountEditable;
    }

    public OperationType getType() {
        return type;
    }

    public void setType(OperationType type) {
        this.type = type;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
}
