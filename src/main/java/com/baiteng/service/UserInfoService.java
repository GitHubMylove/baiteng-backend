package com.baiteng.service;

import com.baiteng.bean.UserInfo;

/**
 * @author ：John007
 * @date ：Created in 2019/8/20 17:43
 * @description：
 * @modified By：
 * @version:
 */
public interface UserInfoService {

    /** 手机号查用户*/
    int selectUserInfoByMobile (String mobileNo);

    /** 添加用户*/
    void addUserInfo(UserInfo userInfo);
}
