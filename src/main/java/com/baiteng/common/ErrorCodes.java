package com.baiteng.common;

public class ErrorCodes {
    //此手机号已注册
    public static final String MOBILE_NO_IS_REGISTERED = "U0001";
    //验证码不正确
    public static final String VERIFY_CODE_NOT_CORRECT = "U0002";
    //车架号不存在
    public static final String SERIAL_NO_NOT_EXIST = "U0003";
    //车架号已被注册
    public static final String SERIAL_NO_IS_REGISTERED = "U0004";

    //手机号不存在
    public static final String MOBILE_NO_IS_NOT_EXIST = "U0011";

    //密码不正确
    public static final String PASSWORD_NOT_CORRECT = "U0012";

    //手机号为空
    public static final String MOBILE_NO_IS_NULL = "BT0001";
    //验证码为空
    public static final String VERIFY_CODE_IS_NULL = "BT0002";
    //车架号为空
    public static final String SERIAL_NO_IS_NULL = "BT0003";
    //手机号格式不合法
    public static final String ILLEGAL_FORMAT_OF_MOBILE_PHONE_NUMBE = "BT0004";


    //令牌不为空
    public static final String TMP_TOKEN_IS_NULL = "BT0005";
    //密码不为空
    public static final String PASSWORD_IS_NULL = "BT0006";



}
