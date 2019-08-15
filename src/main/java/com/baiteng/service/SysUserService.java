package com.baiteng.service;

import com.baiteng.bean.SysUser;

/**
 * @author ：gaozhixing
 * @date ：Created in 2019/8/15 17:43
 * @description：
 * @modified By：
 * @version:
 */
public interface SysUserService{
    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(String userid);
}
