package com.baiteng.service;

import com.baiteng.bean.MyCircle;

public interface MyCircleService {
    /** 车架号查车辆信息**/
    int selectCirCleBySerialNo(String serialNo);

    /** 手机号查车辆信息**/
    MyCircle selectSerialNoByMobileNo(String mobileNo);

}
