package com.baiteng.controller;

import com.baiteng.bean.SysUser;
import com.baiteng.service.SysUserService;
import com.baiteng.util.GsonUtils;
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
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    SysUserService sysUserService;

    @ApiOperation(value = "添加用户", notes = "addUser")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "userId", value = " ", required = true, dataType = "String",defaultValue="4567"),
            @ApiImplicitParam(paramType="query", name = "userName", value = " ", required = true, dataType = "String",defaultValue="佰腾")
    })
    @PostMapping("/addUser")
    public String addUser(@RequestParam String userId,
                            @RequestParam String userName
    ){
        SysUser sysUser=new SysUser();
        sysUser.setUserid(userId);
        sysUser.setUsername(userName);
        sysUserService.insert(sysUser);
        sysUser=sysUserService.selectByPrimaryKey(userId);
        return GsonUtils.getJsonFromObject(sysUser);
    }
}
