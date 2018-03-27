/*******************************************************************************
 *
 *==============================================================================
 *
 * Copyright (c) 2101-2016 Primeton Technologies, Ltd.
 * All rights reserved.
 * 
 * Created on 2016年11月22日 上午10:09:06
 *******************************************************************************/
package com.primeton.learns.springboot.mybatis.demo.constant;

/**
 * 性别
 *
 * @author wuyuhou (mailto:wuyh@primeton.com)
 */
public enum Gender {
	
	MALE("male"),//男
	FEMALE("female"),//女
	UNKNOWN("unknown");//未知

	private String dbValue;

	public String getDbValue() {
		return this.dbValue;
	}

	Gender(String dbValue) {
		this.dbValue = dbValue;
	}
}
