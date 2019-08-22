package com.baiteng.service.impl;

import com.baiteng.bean.UserInfo;
import com.baiteng.dao.UserInfoMapper;
import com.baiteng.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * @author ：John007
 * @date ：Created in 2019/8/20 17:43
 * @description：
 * @modified By：
 * @version:
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    UserInfoMapper userInfoMapper;

    @Override
    public int selectUserInfoByMobile(String mobileNo) {
        return userInfoMapper.selectUserInfoByMobile(mobileNo);
    }

    @Override
    public void addUserInfo(UserInfo userInfo) {
        userInfoMapper.addUserInfo(userInfo);
    }
}
