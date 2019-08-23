package com.baiteng.controller;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.baiteng.base.Assert;
import com.baiteng.base.Result;

import com.baiteng.bean.UserInfo;
import com.baiteng.common.Constants;
import com.baiteng.common.ErrorCodes;
import com.baiteng.service.FamilyNumberService;
import com.baiteng.service.MyCircleService;
import com.baiteng.service.UserInfoService;
import com.baiteng.util.IdGeneratorUtils;
import com.baiteng.util.StrUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

@Api(value = "用户服务")
@Controller
@RestController
public class UserInfoController {
    private static final Logger log = LoggerFactory.getLogger(UserInfoController.class);

    @Autowired
    UserInfoService userInfoService;

    @Autowired
    MyCircleService myCircleService;

    @ApiOperation(value = "新用户注册获取验证码", notes = "getVerifyCodeForRegister")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "mobileNo", value = " ", required = true, dataType = "String", defaultValue = "13532757605")
    })
    @PostMapping("/api/user/getVerifyCodeForRegister")
    private Result<?> getVerifyCodeForRegister(@RequestParam String mobileNo) {
        Assert.isTrue(StringUtils.isNotEmpty(mobileNo), ErrorCodes.MOBILE_NO_IS_NULL, Constants.MESSAGE_MOBILE_IS_NULL);
        Assert.isTrue(StrUtils.isMobile(mobileNo), ErrorCodes.ILLEGAL_FORMAT_OF_MOBILE_PHONE_NUMBE, Constants.MESSAGE_ILLEGAL_FORMAT_OF_MOBILE_PHONE_NUMBE);
        int count = userInfoService.selectUserInfoByMobile(mobileNo);
        if (0 != count) return Result.newFailResult(ErrorCodes.MOBILE_NO_IS_REGISTERED, Constants.MESSAGE_MOBILE_NO_IS_REGISTERED);
        return Result.newResult(Constants.CODE_SUCCESS, Constants.MESSAGE_DEAL_SUCCESS);
    }

    @ApiOperation(value = "用户注册", notes = "register")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "mobileNo", value = " ", required = true, dataType = "String", defaultValue = "13532757605"),
            @ApiImplicitParam(paramType = "query", name = "verifyCode", value = " ", required = true, dataType = "String", defaultValue = "123456"),
            @ApiImplicitParam(paramType = "query", name = "serialNo", value = " ", required = false, dataType = "String", defaultValue = "123456")
    })
    @PostMapping("/api/user/register")
    private Result<?> register(@RequestParam String mobileNo, @RequestParam String verifyCode, @RequestParam String serialNo) {

        Assert.isTrue(StringUtils.isNotEmpty(mobileNo), ErrorCodes.MOBILE_NO_IS_NULL, Constants.MESSAGE_MOBILE_IS_NULL);
        Assert.isTrue(StringUtils.isNotEmpty(verifyCode), ErrorCodes.VERIFY_CODE_IS_NULL, Constants.MESSAGE_VERIFY_CODE_IS_NULL);
        Assert.isTrue(StrUtils.isMobile(mobileNo), ErrorCodes.ILLEGAL_FORMAT_OF_MOBILE_PHONE_NUMBE, Constants.MESSAGE_ILLEGAL_FORMAT_OF_MOBILE_PHONE_NUMBE);
        Assert.isTrue(0 == userInfoService.selectUserInfoByMobile(mobileNo), ErrorCodes.MOBILE_NO_IS_REGISTERED, Constants.MESSAGE_MOBILE_NO_IS_REGISTERED);
        Assert.isTrue("123456".equals(verifyCode), ErrorCodes.VERIFY_CODE_NOT_CORRECT, Constants.MESSAGE_VERIFY_CODE_NOT_CORRECT);
        /**如果车架号上送*/
        if (StringUtils.isNotEmpty(serialNo)) {
            /** 校验车架号不存在*/
            Assert.isTrue(0 != myCircleService.selectCirCleBySerialNo(serialNo), ErrorCodes.SERIAL_NO_NOT_EXIST, Constants.MESSAGE_SERIAL_NO_IS_NO_EXIST);
            /** 车架号已注册*/
            Assert.isTrue(null != myCircleService.selectSerialNoByMobileNo(mobileNo), ErrorCodes.SERIAL_NO_IS_REGISTERED, Constants.MESSAGE_SERIAL_NO_IS_REGISTERED);
        }
        /** 注册用户信息新增*/
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(IdGeneratorUtils.generateRandom());
        userInfo.setMobileNo(mobileNo);
        userInfo.setStatus(Constants.STATUS_NORMAL);
        userInfoService.addUserInfo(userInfo);
        String tmpToken = IdGeneratorUtils.generateRandom();
        Map<String, Object> rspMap = new HashMap<String, Object>();
        rspMap.put("tmpToken", tmpToken);
        return Result.newResult(rspMap);
    }

    @ApiOperation(value = "设置密码", notes = "setPassword")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "tmpToken", value = " ", required = true, dataType = "String", defaultValue = "234141"),
            @ApiImplicitParam(paramType = "query", name = "password", value = " ", required = true, dataType = "String", defaultValue = "123456")
    })
    @PostMapping("/api/user/setPassword")
    private Result<?> setPassword(@RequestParam String tmpToken, @RequestParam String password){
        Assert.isTrue(StringUtils.isNotEmpty(tmpToken), ErrorCodes.TMP_TOKEN_IS_NULL, Constants.MESSAGE_TMP_TOKEN_IS_NULL);
        Assert.isTrue(StringUtils.isNotEmpty(password), ErrorCodes.PASSWORD_IS_NULL, Constants.MESSAGE_PASSWORD_IS_NULL);
        return Result.newResult(Constants.CODE_SUCCESS, Constants.MESSAGE_DEAL_SUCCESS);
    }

    @ApiOperation(value = "用户登录", notes = "login")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "mobileNo", value = " ", required = true, dataType = "String", defaultValue = "13632757605"),
            @ApiImplicitParam(paramType = "query", name = "password", value = " ", required = true, dataType = "String", defaultValue = "123456")
    })
    @PostMapping("/api/user/login")
    private Result<?> login(@RequestParam String mobileNo, @RequestParam String password) {
        Assert.isTrue(StringUtils.isNotEmpty(mobileNo), ErrorCodes.MOBILE_NO_IS_NULL, Constants.MESSAGE_MOBILE_IS_NULL);
        Assert.isTrue(StrUtils.isMobile(mobileNo), ErrorCodes.ILLEGAL_FORMAT_OF_MOBILE_PHONE_NUMBE, Constants.MESSAGE_ILLEGAL_FORMAT_OF_MOBILE_PHONE_NUMBE);
        Assert.isTrue(0 == userInfoService.selectUserInfoByMobile(mobileNo), ErrorCodes.MOBILE_NO_IS_NOT_EXIST, Constants.MESSAGE_MOBILE_NO_IS_NOT_EXIST);
        Assert.isTrue("123456".equals(password), ErrorCodes.PASSWORD_NOT_CORRECT, Constants.MESSAGE_PASSWORD_NOT_CORRECT);
        // TODO帐号已锁定??? 主要是考虑用户登录失败次数要不要限制
        String token = IdGeneratorUtils.generateRandom();
        Map<String, Object> rspMap = new HashMap<String, Object>();
        rspMap.put("token", token);
        return Result.newResult(rspMap);
    }






}
