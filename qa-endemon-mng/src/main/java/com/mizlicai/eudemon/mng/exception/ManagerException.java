package com.mizlicai.eudemon.mng.exception;

import org.springframework.validation.BindingResult;

/**
 * Created by djq on 2016/5/16.
 * Copyright © mizhuanglicai
 *
 * @author djq
 */
public class ManagerException extends Exception {

    /**
	 *
	 */
	private static final long serialVersionUID = 2774353784909367481L;

	private String traceId;

    private String code;

    private BindingResult result;

    public ManagerException(String code, String message) {
        super(message);
        this.setCode(code);
    }

    public ManagerException(String code, String message, BindingResult result) {
        super(message);
        this.setCode(code);
        this.setResult(result);
    }

    public ManagerException(String code, String message, BindingResult result, String traceId) {
        super(message);
        this.setCode(code);
        this.setResult(result);
        this.setTraceId(traceId);
    }

    public ManagerException() {
        super("CreditManager Exception");
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BindingResult getResult() {
        return result;
    }

    public void setResult(BindingResult result) {
        this.result = result;
    }

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }
}
