package com.mizlicai.eudemon.exceptions;

/**
 * Created by huangyt on 2017/6/3.
 */
public class TestException extends Exception {
    private String code;


    public TestException(TestExceptionCode testExceptionCode) {
        super(testExceptionCode.getMessage());
        this.setCode(testExceptionCode.getCode());
    }

    public TestException() {
        super("Credtrip Exception");
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
