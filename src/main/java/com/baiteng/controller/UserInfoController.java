package com.baiteng.controller;

import com.baiteng.base.Result;

import com.baiteng.common.Constants;
import com.baiteng.common.ErrorCodes;
import com.baiteng.service.UserInfoService;
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

@Api(value = "用户服务")
@Controller
@RestController
public class UserInfoController {
    private static final Logger log = LoggerFactory.getLogger(UserInfoController.class);

    @Autowired
    UserInfoService userInfoService;

    @ApiOperation(value = "新用户注册获取验证码", notes = "getVerifyCodeForRegister")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "mobileNo", value = " ", required = true, dataType = "String", defaultValue="13532757605")
    })
    @PostMapping("/api/user/getVerifyCodeForRegister")
    public Result<?> getVerifyCodeForRegister(@RequestParam  String mobileNo){
        log.info("--------------------mobileNo:{}", mobileNo);
       int count = userInfoService.selectUserInfoByMobile(mobileNo);
       if (0 != count) return Result.newFailResult(ErrorCodes.MOBILE_NO_IS_REGISTERED, "此手机号已注册");
       return Result.newResult(Constants.CODE_SUCCESS, Constants.MESSAGE_DEAL_SUCCESS);
    }

}
