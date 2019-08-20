package com.baiteng.base;

import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
/**
 **  @Author: John007
 **  @Company:
 **  @Date: 2019/8/18 11:50
 **  @Description:
 **/
public abstract class  Result<T> {

    public static Result<?> newResult()
    {
        return new DefaultResult();
    }

    public static <T> Result<T> newResult(T payload) {
        return new DefaultResult(payload);
    }

    public static <T> Result<T> newResult(String code, String message) {
        return new DefaultResult(code, message);
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

        return new DefaultResult("5000", responseMessage.toString());
    }
}
