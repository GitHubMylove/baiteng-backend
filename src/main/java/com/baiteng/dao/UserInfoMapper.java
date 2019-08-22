package com.baiteng.dao;


import com.baiteng.bean.UserInfo;

public interface UserInfoMapper {
    /** 手机号查用户*/
    int selectUserInfoByMobile (String mobileNo);

    /** 添加用户*/
    void addUserInfo(UserInfo userInfo);
}
