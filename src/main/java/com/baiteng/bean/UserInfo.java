package com.baiteng.bean;


import org.springframework.data.annotation.Id;

import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.GeneratedValue;

public class UserInfo {
    @Id
    @GeneratedValue
    private String userId;
    private String iconURL;
    private String nickName;
    private String mobileNo;
    private String city;
    private String address;
    private String email;
    private Boolean isVIP;
    private Date vipEndDate;
    private String status;
    private Timestamp registeDate;

    public UserInfo() {
        super();
    }

    public UserInfo(String userId, String iconURL, String nickName, String mobileNo, String city, String address, String email, Boolean isVIP, Date vipEndDate, String status, Timestamp registeDate) {
        this.userId = userId;
        this.iconURL = iconURL;
        this.nickName = nickName;
        this.mobileNo = mobileNo;
        this.city = city;
        this.address = address;
        this.email = email;
        this.isVIP = isVIP;
        this.vipEndDate = vipEndDate;
        this.status = status;
        this.registeDate = registeDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getIconURL() {
        return iconURL;
    }

    public void setIconURL(String iconURL) {
        this.iconURL = iconURL == null ? null : iconURL.trim();
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo == null ? null : mobileNo.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getAddress() { return address; }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Boolean getVIP() { return isVIP; }

    public Date getVipEndDate() {
        return vipEndDate;
    }

    public void setVipEndDate(Date vipEndDate) {
        this.vipEndDate = vipEndDate;
    }

    public Timestamp getRegisteDate() {
        return registeDate;
    }

    public void setRegisteDate(Timestamp registeDate) {
        this.registeDate = registeDate;
    }

    public void setVIP(Boolean VIP) {
        isVIP = VIP;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}
