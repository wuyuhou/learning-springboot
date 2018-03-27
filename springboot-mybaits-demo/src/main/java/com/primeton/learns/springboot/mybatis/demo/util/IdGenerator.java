/*******************************************************************************
 *
 *==============================================================================
 *
 * Copyright (c) 2101-2016 Primeton Technologies, Ltd.
 * All rights reserved.
 * 
 * Created on 2016年11月22日 上午10:09:06
 *******************************************************************************/
package com.primeton.learns.springboot.mybatis.demo.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.primeton.learns.springboot.mybatis.demo.dao.IdEntityDao;
import com.primeton.learns.springboot.mybatis.demo.model.IdEntity;

/**
 * ID生成器
 * 
 * @author wuyuhou
 *
 */
@Component 
public class IdGenerator {
	
	private Map<String, IdEntity> idEntityMap = new ConcurrentHashMap<>();
	
	@Autowired
	private IdEntityService idEntityService;
	
	/**
	 * 获取ID
	 * 
	 * @param clazz clazz
	 * @return ID值
	 */
	public String getNextId(Class<?> clazz) {
		return getNextId(clazz.getName());
	}
	
	/**
	 * 获取ID
	 * 
	 * @param idName id名称
	 * @return ID值
	 */
	public synchronized String getNextId(String idName) {
		ValidateUtil.assertNotNull(idName, "idName");
		IdEntity idEntity = idEntityMap.get(idName);
		if (idEntity == null) {
			idEntity = idEntityService.getIdEntity(idName);
			idEntityMap.put(idName, idEntity);
		} else {
			if (idEntity.getCurrentId() > idEntity.getIdValue()) {
				idEntityService.updateIdEntity(idEntity);
			}
		}
		long id = idEntity.getCurrentId();
		idEntity.setCurrentId(id + 1);
		return id + "";
	}
	
	@Service
	@Transactional(rollbackFor=Exception.class)
	public static class IdEntityService {
		
		private static final int poolSize = 20;
		
		@Autowired
		private IdEntityDao idEntityDao;
		
		public IdEntity getIdEntity(String idName) {
			IdEntity idEntity = idEntityDao.getLock(idName);
			if (idEntity == null) {
				idEntity = new IdEntity();
				idEntity.setIdName(idName);
				idEntity.setCurrentId(1);
				idEntity.setIdValue(poolSize);
				idEntityDao.insert(idEntity);
			} else {
				idEntity.setCurrentId(idEntity.getIdValue() + 1);
				idEntity.setIdValue(idEntity.getIdValue() + poolSize);
				idEntityDao.update(idEntity);
			}
			return idEntity;
		}
		
		public void updateIdEntity(IdEntity idEntity) {
			idEntityDao.getLock(idEntity.getIdName());
			idEntity.setCurrentId(idEntity.getIdValue() + 1);
			idEntity.setIdValue(idEntity.getIdValue() + poolSize);
			idEntityDao.update(idEntity);
		}
	}
}
