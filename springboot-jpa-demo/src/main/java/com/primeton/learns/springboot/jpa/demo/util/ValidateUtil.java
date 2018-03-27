/*******************************************************************************
 *
 *==============================================================================
 *
 * Copyright (c) 2101-2016 Primeton Technologies, Ltd.
 * All rights reserved.
 * 
 * Created on 2016年11月22日 上午10:09:06
 *******************************************************************************/
package com.primeton.learns.springboot.jpa.demo.util;

import java.text.MessageFormat;
import java.util.Collection;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.util.CollectionUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 校验工具类
 *
 * @author wuyuhou (mailto:wuyh@primeton.com)
 */
public class ValidateUtil {
	
	private static ObjectMapper objectMapper = new ObjectMapper();
	
	private ValidateUtil() {
	}
	
	/**
	 * 参数校验：验证非空
	 * 
	 * @param obj
	 * @param message 用户自定义异常描述信息
	 * @throws IllegalArgumentException 
	 */
	public static void assertNotNull(Object obj, String message, Object ... params) {
		if (obj == null || (obj instanceof String && StringUtils.isBlank((String)obj))) {
			if (message != null && !StringUtils.containsIgnoreCase(message, "is null")) {
				message = message + " is null!";
			}
			throw new IllegalArgumentException(format(message, params));
		}
	}
	
	/**
	 * 参数校验：验证是否为真
	 * 
	 * @param expression 表达式
	 * @param message 用户自定义异常描述信息
	 * @param params  异常描述时用到的格式化参数
	 * @throws IllegalArgumentException  当为假时抛出运行期异常
	 */
	public static void assertTrue(boolean expression, String message, Object ... params) {
		if (!expression) {
			throw new IllegalArgumentException(format(message, params));
		}
	}
	
	/**
	 * 参数校验：验证是否为假
	 * 
	 * @param expression 表达式
	 * @param message 用户自定义异常描述信息
	 * @param params  异常描述时用到的格式化参数
	 * @throws IllegalArgumentException 当为真时抛出运行期异常
	 */
	public static void assertFalse(boolean expression, String message, Object ... params) {
		if (expression) {
			throw new IllegalArgumentException(format(message, params));
		}
	}
	
	public static void assertNotEmpty(Collection<?> object, String message, Object ... params) {
		if (CollectionUtils.isEmpty(object)) {
			throw new IllegalArgumentException(format(message, params));
		}
	}
	
	public static void assertNotEmpty(Object[] object, String message, Object ... params) {
		if (ArrayUtils.isEmpty(object)) {
			throw new IllegalArgumentException(format(message, params));
		}
	}
	
	public static String format(String message, Object[] params) {
		if (message != null && message.trim().length() > 0) {
			if (params != null && params.length > 0) {
				try {
					return new MessageFormat(message).format(convert(params));
				} catch (Exception e) {
					return message;
				}
				
			}
		}
		return message;
	}
	
	static Object[] convert(Object[] params) throws Exception {
		if (params == null) {
			return null;
		}
		for (int i = 0; i < params.length; i++) {
			if (params[i] != null) {
				if (params[i].getClass().isArray()) {
					if (isPrimitiveObject(params[i].getClass())) {
						params[i] = StringUtils.join((Object[])params[i], ",");
					} else {
						params[i] = objectMapper.writeValueAsString(params[i]);
					}
				} else if (params[i] instanceof Collection) {
					params[i] = StringUtils.join((Collection)params[i], ",");
				} else if (!isPrimitiveObject(params[i])) {
					params[i] = objectMapper.writeValueAsString(params[i]);
				}
			}
		}
		return params;
	}
	
	static boolean isPrimitiveObject(Object obj) {
		if (obj.getClass().isPrimitive() || Number.class.isAssignableFrom(obj.getClass()) || obj instanceof Boolean) {
			return true;
		} else if (obj instanceof Character || Character.TYPE.equals(obj.getClass()) || obj instanceof String) {
			return true;
		} else if (obj instanceof Character || Character.TYPE.equals(obj.getClass())) {
			return true;
		}
		return false;
	}
	
}
