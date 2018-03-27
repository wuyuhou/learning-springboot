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

import com.primeton.learns.springboot.mybatis.demo.model.IdEntity;

/**
 * ID生成用的DAO
 * 
 * @author wuyuhou
 *
 */
@Mapper
public interface IdEntityDao extends CommonDao<IdEntity, String> {

}
