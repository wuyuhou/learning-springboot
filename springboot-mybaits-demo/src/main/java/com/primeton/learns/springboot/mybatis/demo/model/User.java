/*******************************************************************************
 *
 *==============================================================================
 *
 * Copyright (c) 2101-2016 Primeton Technologies, Ltd.
 * All rights reserved.
 * 
 * Created on 2016年11月22日 上午10:09:06
 *******************************************************************************/
package com.primeton.learns.springboot.mybatis.demo.model;

import java.util.Date;

/**
 * 用户
 * 
 * @author wuyuhou
 *
 */
public class User implements java.io.Serializable {

	private static final long serialVersionUID = -2775490162402650327L;
	
	/**
	 * 唯一标识
	 */
    private String userId;
	
    /**
	 * 用户名
	 */
    private String userName;
    
    /**
     * 电子邮箱
     */
    private String userEmail;
    
    /**
     * 手机号
     */
    private String userMobile;
    
    /**
     * 昵称
     */
    private String userNickname;
    
    /**
     * 头像
     */
    private String userAvatar;
    
    /**
     * 密码
     */
    private String userPassword;
    
    /**
     * 性别
     */
    private String userGender;
    
    /**
     * 出生日期
     */
    private Date userBirthdate;
    
    /**
     * 地址
     */
    private String userAddress;
    
    /**
     * 备注
     */
    private String userNotes;		
    
    /**
     * 登录时间
     */
    private Date loginTime;
    
    /**
     * 上次登录时间
     */
    private Date lastLoginTime;
    
    /**
	 * 删除标记
	 */
	private boolean delFlag;
	
	/**
	 * 创建人
	 */
	private String createdUser;
	
	/**
	 * 创建时间
	 */
	private Date createdTime;
	
	/**
	 * 更新人
	 */
	private String updatedUser;
	
	/**
	 * 更新时间
	 */
	private Date updatedTime;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserMobile() {
		return userMobile;
	}

	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}

	public String getUserNickname() {
		return userNickname;
	}

	public void setUserNickname(String userNickName) {
		this.userNickname = userNickName;
	}

	public String getUserAvatar() {
		return userAvatar;
	}

	public void setUserAvatar(String userAvatar) {
		this.userAvatar = userAvatar;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserGender() {
		return userGender;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}

	public Date getUserBirthdate() {
		return userBirthdate;
	}

	public void setUserBirthdate(Date userBirthdate) {
		this.userBirthdate = userBirthdate;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserNotes() {
		return userNotes;
	}

	public void setUserNotes(String userNotes) {
		this.userNotes = userNotes;
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public boolean isDelFlag() {
		return delFlag;
	}

	public void setDelFlag(boolean delFlag) {
		this.delFlag = delFlag;
	}

	public String getCreatedUser() {
		return createdUser;
	}

	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public String getUpdatedUser() {
		return updatedUser;
	}

	public void setUpdatedUser(String updatedUser) {
		this.updatedUser = updatedUser;
	}

	public Date getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}
}
