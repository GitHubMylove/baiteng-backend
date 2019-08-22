package com.baiteng.bean;

import org.springframework.data.annotation.Id;

import javax.persistence.GeneratedValue;
import java.util.Date;

public class MyCircle {
    @Id
    @GeneratedValue
    /** 车辆ID*/
    private String circleId;
    /** 车架号*/
    private String serialNo;
    /** 电池编号*/
    private String betterySn;
    /** 车型ID*/
    private Integer modalId;
    /** 车型*/
    private String  modal;
    /** 来源：1-自购， 2-装让， 3-捡的*/
    private Integer fromType;
    /** 购买营业点fromType为 1，此处为营业网点名称；fromType为 2，此处为转让用户呢称；fromType为 其它值，此处为留空*/
    private Integer shopName;
    /** 购入日期*/
    private Date buyDate;
    /** 绑定日期*/
    private Date bindDate;
    /** 自有车辆 True-自有车;False-我是家人*/
    private boolean  isMine;
    /** 车主: IsMine为 false, 此处为车主呢称*/
    private String  owner;
    /** 车辆图片地址*/
    private String picURL;
    /** 车辆用途*/
    private String use;
    /** 上次保养*/
    private Date lastMaintenance;
    /** 下次保养*/
    private Date nextMaintenance;
    /** 固件版本*/
    private String  csVersion;
    /** 状态：0-正常，1-已报整车失窃，2-已报电池失窃*/
    private String  status;

    public MyCircle() {
        super();
    }
    public MyCircle(String serialNo, String betterySn, Integer modalId, String modal, Integer fromType, Integer shopName, Date buyDate, Date bindDate, boolean isMine, String owner, String picURL, String use, Date lastMaintenance, Date nextMaintenance, String csVersion, String status) {
        this.serialNo = serialNo;
        this.betterySn = betterySn;
        this.modalId = modalId;
        this.modal = modal;
        this.fromType = fromType;
        this.shopName = shopName;
        this.buyDate = buyDate;
        this.bindDate = bindDate;
        this.isMine = isMine;
        this.owner = owner;
        this.picURL = picURL;
        this.use = use;
        this.lastMaintenance = lastMaintenance;
        this.nextMaintenance = nextMaintenance;
        this.csVersion = csVersion;
        this.status = status;
    }


    public String getCircleId() {
        return circleId;
    }

    public void setCircleId(String circleId) {
        this.circleId = circleId;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getBetterySn() {
        return betterySn;
    }

    public void setBetterySn(String betterySn) {
        this.betterySn = betterySn;
    }

    public Integer getModalId() {
        return modalId;
    }

    public void setModalId(Integer modalId) {
        this.modalId = modalId;
    }

    public String getModal() {
        return modal;
    }

    public void setModal(String modal) {
        this.modal = modal;
    }

    public Integer getFromType() {
        return fromType;
    }

    public void setFromType(Integer fromType) {
        this.fromType = fromType;
    }

    public Integer getShopName() {
        return shopName;
    }

    public void setShopName(Integer shopName) {
        this.shopName = shopName;
    }

    public Date getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(Date buyDate) {
        this.buyDate = buyDate;
    }

    public Date getBindDate() {
        return bindDate;
    }

    public void setBindDate(Date bindDate) {
        this.bindDate = bindDate;
    }

    public boolean isMine() {
        return isMine;
    }

    public void setMine(boolean mine) {
        isMine = mine;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getPicURL() {
        return picURL;
    }

    public void setPicURL(String picURL) {
        this.picURL = picURL;
    }

    public String getUse() {
        return use;
    }

    public void setUse(String use) {
        this.use = use;
    }

    public Date getLastMaintenance() {
        return lastMaintenance;
    }

    public void setLastMaintenance(Date lastMaintenance) {
        this.lastMaintenance = lastMaintenance;
    }

    public Date getNextMaintenance() {
        return nextMaintenance;
    }

    public void setNextMaintenance(Date nextMaintenance) {
        this.nextMaintenance = nextMaintenance;
    }

    public String getCsVersion() {
        return csVersion;
    }

    public void setCsVersion(String csVersion) {
        this.csVersion = csVersion;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
