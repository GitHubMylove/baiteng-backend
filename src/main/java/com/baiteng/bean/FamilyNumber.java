package com.baiteng.bean;

import org.springframework.data.annotation.Id;

import javax.persistence.GeneratedValue;
import java.sql.Timestamp;

public class FamilyNumber {
    @Id
    @GeneratedValue
    /** 车辆ID*/
    private String familyNumberId;
    /** 头像*/
    private String iconURL;
    /** 称呼*/
    private String nickName;
    /** 手机号*/
    private String mobileNo;
    /** 状态：0-	有效，1-	已删除*/
    private String status;
    /** 添加时间*/
    private Timestamp  addedDate;
    /** 删除时间*/
    private Timestamp  removeDate;

    public FamilyNumber() {
        super();
    }

    public FamilyNumber(String familyNumberId, String iconURL, String nickName, String mobileNo, String status, Timestamp addedDate, Timestamp removeDate) {
        this.familyNumberId = familyNumberId;
        this.iconURL = iconURL;
        this.nickName = nickName;
        this.mobileNo = mobileNo;
        this.status = status;
        this.addedDate = addedDate;
        this.removeDate = removeDate;
    }

    public String getFamilyNumberId() {
        return familyNumberId;
    }

    public void setFamilyNumberId(String familyNumberId) {
        this.familyNumberId = familyNumberId;
    }

    public String getIconURL() {
        return iconURL;
    }

    public void setIconURL(String iconURL) {
        this.iconURL = iconURL;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Timestamp addedDate) {
        this.addedDate = addedDate;
    }

    public Timestamp getRemoveDate() {
        return removeDate;
    }

    public void setRemoveDate(Timestamp removeDate) {
        this.removeDate = removeDate;
    }
}
