package com.baiteng.base;

import com.baiteng.util.GsonUtils;

/**
 **  @Author: gaozhijun
 **  @Company:
 **  @Date: 2019/8/18 11:50
 **  @Description:
 **/
public class DefaultResult<T> extends Result {

    private String code;
    private String message;
    private String data;

    public DefaultResult() {
        this.code = "2000";
    }

    public DefaultResult(T payload) {
        this.code= "2000";
        this.message = "处理成功";
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
