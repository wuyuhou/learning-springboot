/*******************************************************************************
 *
 *==============================================================================
 *
 * Copyright (c) 2101-2016 Primeton Technologies, Ltd.
 * All rights reserved.
 * 
 * Created on 2016年11月22日 上午10:09:06
 *******************************************************************************/
package com.primeton.learns.springboot.jpa.demo.dao;

import com.primeton.learns.springboot.jpa.demo.model.User;

/**
 * 用户DAO
 * 
 * @author wuyuhou
 *
 */
public interface UserDao extends CommonDao<User, String> {
	
	User getByUserName(String userName);
}
