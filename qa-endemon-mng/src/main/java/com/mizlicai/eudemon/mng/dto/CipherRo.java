package com.mizlicai.eudemon.mng.dto;

/**
 * Created by huangyt on 2017/6/21.
 */
public class CipherRo {

    private static final long serialVersionUID = 1L;

    /**
     * 密文(外部必传)
     */
    private String cipher;
    /**
     * 错误地址, 当不可逆或系统异常或验签,解密失败时, 返回该地址,与密文中的交易结果落地后returnUrl无关(外部必传), 不参与验签
     */
    private String errorUrl;
    /**
     * 请求唯一号(内部必传), 不参与验签 业务系统不能传
     */
    private String requestId;

    /**
     * token(外部必传), 不参与验签
     */
    private String token;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getCipher() {
        return cipher;
    }

    public void setCipher(String cipher) {
        this.cipher = cipher;
    }

    public String getErrorUrl() {
        return errorUrl;
    }

    public void setErrorUrl(String errorUrl) {
        this.errorUrl = errorUrl;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
