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

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * 公共DAO
 * 
 * @author wuyuhou
 *
 */
public interface CommonDao <T, ID extends Serializable> {
	
	//根据ID查询
	T getById(@Param("id") ID id);
	
	//获取行锁
	T getLock(@Param("id") ID id);
	
	List<T> queryAll();
	
	void insert(T entity);
	
	void update(T entity);
	
	void delete(@Param("id") ID id);
}
