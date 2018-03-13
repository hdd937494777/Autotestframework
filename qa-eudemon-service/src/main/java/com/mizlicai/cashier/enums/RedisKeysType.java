package com.mizlicai.cashier.enums;

import java.util.concurrent.TimeUnit;

/**
 * Created by MaiBenBen on 2017/6/1.
 */
public enum RedisKeysType {

    /**
     * todo 请求上下文存在时间
     */
    CASHIER_REQUEST_CONTEXT("cashier_request_context_", 10, TimeUnit.MINUTES),
    //CASHIER_REQUEST_CONTEXT("cashier_request_context_", 60, TimeUnit.MINUTES),

    /**
     * todo token 刷新次数
     */
    CASHIER_TOKEN_REFRESH_COUNT("cashier_token_refresh_count_", 10, TimeUnit.MINUTES),
    //CASHIER_TOKEN_REFRESH_COUNT("cashier_token_refresh_count_", 100, TimeUnit.MINUTES),


    /**
     * 短信验证码失效
     */
    CASHIER_SMS_CODE_TIMEOUT("cashier_sms_code_timeout_", 5, TimeUnit.MINUTES),

    /**
     * 短信发送间隔
     */
    CASHIER_SMS_SENDING("cashier_sms_sending_", 60, TimeUnit.SECONDS),

    /**
     * 短信发送间隔
     */
    CASHIER_AUTH_SMS_SENDING("cashier_auth_sms_sending_", 60, TimeUnit.SECONDS),

    /**
     * 短信单笔发送次数
     */
    CASHIER_SMS_SINGLE_COUNT("cashier_sms_single_count_", 10, TimeUnit.MINUTES),

    /**
     * 短信单笔错误次数
     */
    CASHIER_SMS_SINGLE_ERROR_COUNT("cashier_sms_single_error_count_", 10, TimeUnit.MINUTES),

    /**
     * 短信一天发送次数
     */
    CASHIER_SMS_DAY_COUNT("cashier_sms_day_count_", 1, TimeUnit.DAYS),;

    /**
     *
     */
    private String key;
    /**
     *
     */
    private long timeout;
    /**
     *
     */
    private TimeUnit unit;

    RedisKeysType(final String key, final long timeout, final TimeUnit unit) {
        this.key = key;
        this.timeout = timeout;
        this.unit = unit;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public long getTimeout() {
        return timeout;
    }

    public void setTimeout(long timeout) {
        this.timeout = timeout;
    }

    public TimeUnit getUnit() {
        return unit;
    }

    public void setUnit(TimeUnit unit) {
        this.unit = unit;
    }
}
