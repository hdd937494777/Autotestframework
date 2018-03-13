package com.mizlicai.eudemon.mng.enums;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by huangyt on 2017/6/21.
 */
public enum  MerchantAccountType {

    FINANCE("008128fe04752349fb", "S002", "财务结算系统"),
    MZD("00498639fc1f7a4b22", "S003", "米庄贷"),
    TRAVEL("0080b99d86648a4a05", "S004", "旅游分期系统"),
    URANUS("004306b3f1a2b646e9", "S001", "交易系统");

    private String merchantAccount;
    private String merchantId;
    private String merchantName;

    public static MerchantAccountType getByMerchantAccount(String merchantAccount) {
        MerchantAccountType[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            MerchantAccountType value = var1[var3];
            if(StringUtils.equals(value.getMerchantAccount(), merchantAccount)) {
                return value;
            }
        }

        return null;
    }

    public static MerchantAccountType getByMerchantId(String merchantId) {
        MerchantAccountType[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            MerchantAccountType value = var1[var3];
            if(StringUtils.equals(value.getMerchantId(), merchantId)) {
                return value;
            }
        }

        return null;
    }

    private MerchantAccountType(String merchantAccount, String merchantId, String merchantName) {
        this.merchantAccount = merchantAccount;
        this.merchantId = merchantId;
        this.merchantName = merchantName;
    }

    public String getMerchantAccount() {
        return this.merchantAccount;
    }

    public String getMerchantName() {
        return this.merchantName;
    }

    public String getMerchantId() {
        return this.merchantId;
    }
}
