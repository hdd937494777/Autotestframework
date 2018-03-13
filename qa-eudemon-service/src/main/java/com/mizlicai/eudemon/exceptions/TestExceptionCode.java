package com.mizlicai.eudemon.exceptions;

public enum TestExceptionCode {

    SUCCESS("SUCCESS", "成功"),
    FAILED("FAILED", "系统异常"),
    PARAM_MISS("PARAM_MISS", "参数缺失"),
    SYSTEM_ERROR("SYSTEM_ERROR","系统错误"),
    RECODE_NOT_EXIST("RECODE_NOT_EXIST","记录不存在");


    private String code;

    private String message;

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

    TestExceptionCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

}
