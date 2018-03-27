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

import org.slf4j.Logger;

/**
 * 跟踪日志工厂
 *
 * @author wuyuhou (mailto:wuyh@primeton.com)
 */

public class TraceLoggerFactory {
	
	/**
	 * 获取日志
	 * 
	 * @param clazz 类
	 * @return 日志对象
	 */
	public static Logger getLogger(Class<?> clazz) {
		return org.slf4j.LoggerFactory.getLogger(clazz.getName());
	}
}
