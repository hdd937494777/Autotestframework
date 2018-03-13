package com.mizlicai.cashier.data;

import com.miz.mekansm.common.pojo.request.BaseRequest;
import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

/**
 * Created by huangyt on 2017/6/16.
 */
public class TokenRequest extends BaseRequest {

    private static final long serialVersionUID = 7546166884550640123L;

    /**
     * 商户号
     */
    private String merchantAccount;

    /**
     * 请求唯一标识
     */
    private String requestId;

    /**
     * 签名
     */
    private String sign;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getMerchantAccount() {
        return merchantAccount;
    }

    public void setMerchantAccount(String merchantAccount) {
        this.merchantAccount = merchantAccount;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}