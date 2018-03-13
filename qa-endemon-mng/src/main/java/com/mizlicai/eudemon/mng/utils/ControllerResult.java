package com.mizlicai.eudemon.mng.utils;

/**
 * Created by caofei on 2016-08-17 14:18.
 * <p>
 * Copyright © mizlicai
 */
public class ControllerResult {

    private boolean success = true;

    private String message;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
