package com.baiteng.base;

/**
 **  @Author: John007
 **  @Company:
 **  @Date: 2019/8/18 11:50
 **  @Description:
 **/
public class CoreException extends RuntimeException
{
    private static final long serialVersionUID = 3999713779564898790L;
    private String code;
    private Object[] args;

    public CoreException(String code, Object[] args)
    {
        this.code = code;
        this.args = args;
    }

    public CoreException(String code) {
        this.code = code;
    }

    public CoreException(String code, String message) {
        super(message);
        this.code = code;
    }

    public CoreException(String code, Throwable cause) {
        super(cause);
        this.code = code;
    }

    public CoreException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }

    public static long getSerialversionuid() {
        return 3999713779564898790L;
    }

    public Object[] getArgs() {
        return this.args;
    }
}
