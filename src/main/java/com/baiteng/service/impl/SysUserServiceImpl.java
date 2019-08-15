package com.baiteng.service.impl;

import com.baiteng.bean.SysUser;
import com.baiteng.dao.SysUserMapper;
import com.baiteng.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ：gaozhixing
 * @date ：Created in 2019/8/15 17:43
 * @description：
 * @modified By：
 * @version:
 */
@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    SysUserMapper sysUserMapper;
    @Override
    public int insert(SysUser record) {
        return sysUserMapper.insert(record);
    }

    @Override
    public int insertSelective(SysUser record) {
        return 0;
    }

    @Override
    public SysUser selectByPrimaryKey(String userid) {
        return sysUserMapper.selectByPrimaryKey(userid);
    }
}
