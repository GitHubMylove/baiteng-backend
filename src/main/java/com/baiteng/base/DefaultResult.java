package com.baiteng.base;

import com.baiteng.common.Constants;
import com.baiteng.util.GsonUtils;

/**
 **  @Author: John007
 **  @Company:
 **  @Date: 2019/8/18 11:50
 **  @Description:
 **/
public class DefaultResult<T> extends Result {

    private String code;
    private String message;
    private String data;

    public DefaultResult() {
        this.code = Constants.CODE_SUCCESS;
    }

    public DefaultResult(T payload) {
        this.code= Constants.CODE_SUCCESS;
        this.message = Constants.MESSAGE_DEAL_SUCCESS;
        this.data = GsonUtils.getJsonFromObject(payload);
    }

    public DefaultResult(String code, String message) {
        this.code = code;
        this.message = message;
    }
    public DefaultResult(String code, String message, T payload) {
        this.code = code;
        this.message = message;
        this.data = GsonUtils.getJsonFromObject(payload);
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getData() {
        return data;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public void setData(T payload) {
        this.data = GsonUtils.getJsonFromObject(payload);
    }
}
