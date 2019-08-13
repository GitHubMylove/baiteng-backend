package com.baiteng.bean;
/**
**  @Author: gaozhixing
**  @Company: exsun
**  @Date: 2018/3/18 21:37
**  @Description:
**/
public class RetResult {
    int code;
	String error;
    String  msg;
    Object retain;
    Object detail;


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Object getDetail() {
        return detail;
    }

    public void setDetail(Object detail) {
        this.detail = detail;
    }

    public Object getRetain() {
        return retain;
    }

    public void setRetain(Object retain) {
        this.retain = retain;
    }
}
