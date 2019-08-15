package com.baiteng.bean;

public class SysUser {
    private String userid;

    private String username;

    public SysUser(String userid, String username) {
        this.userid = userid;
        this.username = username;
    }

    public SysUser() {
        super();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }
}