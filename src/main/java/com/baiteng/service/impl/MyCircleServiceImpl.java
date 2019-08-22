package com.baiteng.service.impl;

import com.baiteng.bean.MyCircle;
import com.baiteng.dao.MyCircleMapper;
import com.baiteng.service.MyCircleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyCircleServiceImpl implements MyCircleService {
    @Autowired
    MyCircleMapper myCircleMapper;


    @Override
    public int selectCirCleBySerialNo(String serialNo) {
        return myCircleMapper.selectCirCleBySerialNo(serialNo);
    }

    @Override
    public MyCircle selectSerialNoByMobileNo(String mobileNo) {
        return myCircleMapper.selectSerialNoByMobileNo(mobileNo);
    }
}
