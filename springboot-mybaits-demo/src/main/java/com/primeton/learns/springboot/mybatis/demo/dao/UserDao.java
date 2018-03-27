/*******************************************************************************
 *
 *==============================================================================
 *
 * Copyright (c) 2101-2016 Primeton Technologies, Ltd.
 * All rights reserved.
 * 
 * Created on 2016年11月22日 上午10:09:06
 *******************************************************************************/
package com.primeton.learns.springboot.mybatis.demo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.primeton.learns.springboot.mybatis.demo.model.User;

/**
 * 用户DAO
 * 
 * @author wuyuhou
 *
 */
@Mapper
public interface UserDao extends CommonDao<User, String> {
	
	User getByUserName(@Param("userName") String userName);
}
