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

import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Optional;

import javax.persistence.LockModeType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * 公共DAO
 * 
 * @author wuyuhou
 *
 */
@NoRepositoryBean
public interface CommonDao <T, ID extends Serializable> extends JpaRepository<T, ID> {
	
	//获取行锁方法：select ... for update
	@Lock(LockModeType.PESSIMISTIC_WRITE)
	Optional<T> findById(ID id);
	
	//获取行锁
	default T getLock(ID id) {
		return findById(id).orElse(null);
	}
	
	default T getById(ID id) {
		Iterator<T> it = findAllById(Arrays.asList(id)).iterator();
		if (it.hasNext()) {
			return it.next();
		}
		return null;
	}
}
