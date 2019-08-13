package com.baiteng.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "用户服务")
@Controller
@RestController
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @ApiOperation(value = "添加用户", notes = "addUser")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "userName", value = " ", required = true, dataType = "String",defaultValue="190500000000"),
            @ApiImplicitParam(paramType="query", name = "passwd", value = " ", required = true, dataType = "String",defaultValue="8104")
    })
    @PostMapping("/addUser")
    public String addUser(@RequestParam String userName,
                            @RequestParam String passwd
    ){
        return "0000";
    }
}
