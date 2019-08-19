package com.baiteng.base;

import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
/**
 **  @Author: gaozhijun
 **  @Company:
 **  @Date: 2019/8/18 11:50
 **  @Description:
 **/
public abstract class  Result<T> {

    public static final int CODE_SUCCESS = 2000;
    public static final int CODE_SIGN_ERROR_AND_ILLEGAL_REQUEST = 3000;
    public static final int CODE_ILLEGAL_REQUEST_WITHOUT_LOGIN = 3003;
    public static final int CODE_SERVER_EXCEPTION= 5000;
    public static final int CODE_REQUEST_PARAM_NOT_CORRECT = 5001;
    public static final int CODE_APP_VERSION_INVALID_SHOULD_UPDATE = 6000;
    public static final int CODE_APP_VERSION_AVAILABLE_HAVE_NEW_VERSION_NOTIFY_UPDATE = 6001;

    public static Result<?> newResult()
    {
        return new DefaultResult();
    }

    public static <T> Result<T> newResult(T payload) {
        return new DefaultResult(payload);
    }

    public static <T> Result<T> newFailResult(String code, String message) {
        return new DefaultResult(code, message);
    }

    public static <T> Result<T> newFailResult(String code, String message, T payload) {
        return new DefaultResult(code, message, payload);
    }

    public static <T> DefaultResult newFailResult(Errors errors)
    {
        StringBuilder responseMessage = new StringBuilder("");
        for (ObjectError objectError : errors.getAllErrors()) {
            responseMessage.append("[").append(objectError.getDefaultMessage()).append("]");
        }

        return new DefaultResult("ER0000", responseMessage.toString());
    }
}
