/*******************************************************************************
 *
 *==============================================================================
 *
 * Copyright (c) 2101-2016 Primeton Technologies, Ltd.
 * All rights reserved.
 * 
 * Created on 2016年11月22日 上午10:09:06
 *******************************************************************************/
package com.primeton.learns.springboot.mybatis.demo.exception;

import com.primeton.learns.springboot.mybatis.demo.util.ValidateUtil;

/**
 * 业务异常
 * 
 * @author wuyuhou
 *
 */
public class DemoException extends Exception {
	
	/**
	 * Comment for <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = -3876319857610564892L;
	
	private final static String ERROR_CODE = "ErrCode: ";
	
	private final static String ERROR_MESSAGE = "Message: ";
	
	/**
	 * http状态码
	 */
	private int httpStatus = 500;
	
	private String errCode;
	
	private String message;
	
	private Object[] params;
	
	/**
	 * 额外信息
	 */
	private Object additional;
	
	/**
	 * 无参构造方法.
	 * 
	 * @deprecated 不推荐使用
	 */
	public DemoException() {		
		super();
	}
	
	/**
	 * 构造方法.
	 * 
	 * @param httpStatus http状态码
	 * @param errCode 异常编号
	 * @param message 用户自定义异常描述信息
	 * @param params  异常描述时用到的格式化参数
	 * @param cause   上层异常
	 * @param additional 额外信息，前端用
	 */
	public DemoException(int httpStatus, String errCode, String message, Object[] params, Throwable cause, Object additional) {		
		super(cause);
		this.httpStatus = httpStatus;
		this.errCode = errCode;
		this.message = message;
		this.params = params;
		this.additional = additional;
	}
	
	/**
	 * 构造方法.
	 * 
	 * @param errCode 异常编号
	 * @param message 用户自定义异常描述信息
	 * @param params  异常描述时用到的格式化参数
	 */
	public DemoException(String errCode, String message, Object... params) {		
		this(500, errCode, message, params, null, null);
	}
	
	/**
	 * 构造方法.
	 * 
	 * @param errCode 异常编号
	 * @param message 用户自定义异常描述信息
	 * @param params  异常描述时用到的格式化参数
	 * @param additional 额外信息，前端用
	 */
	public DemoException(String errCode, String message, Object[] params, Object additional) {		
		this(errCode, message, params, null, additional);
	}
	
	/**
	 * 构造方法.
	 * 
	 * @param errCode 异常编号
	 * @param message 用户自定义异常描述信息
	 * @param cause   上层异常
	 */
	public DemoException(String errCode, Throwable cause) {		
		this(errCode, null , null, cause, null);
	}
	
	/**
	 * 构造方法.
	 * 
	 * @param errCode 异常编号
	 * @param message 用户自定义异常描述信息
	 * @param cause   上层异常
	 */
	public DemoException(String errCode, String message, Throwable cause) {		
		this(errCode, message, null, cause, null);
	}
	
	/**
	 * 构造方法.
	 * 
	 * @param errCode 异常编号
	 * @param message 用户自定义异常描述信息
	 * @param params  异常描述时用到的格式化参数
	 * @param cause   上层异常
	 */
	public DemoException(String errCode, String message, Object[] params, Throwable cause) {		
		this(errCode, message, params, cause, null);
	}
	
	/**
	 * 构造方法.
	 * 
	 * @param errCode 异常编号
	 * @param message 用户自定义异常描述信息
	 * @param params  异常描述时用到的格式化参数
	 * @param cause   上层异常
	 * @param additional 额外信息，前端用
	 */
	public DemoException(String errCode, String message, Object[] params, Throwable cause, Object additional) {		
		this(500, errCode, message, params, cause, additional);
	}
	
	/**
	 * 构造方法.
	 * 
	 * @param httpStatus http状态码
	 * @param errCode 异常编号
	 * @param message 用户自定义异常描述信息
	 * @param params  异常描述时用到的格式化参数
	 */
	public DemoException(int httpStatus, String errCode, String message, Object... params) {		
		this(500, errCode, message, params, null, null);
	}
	
	/**
	 * 构造方法.
	 * 
	 * @param httpStatus http状态码
	 * @param errCode 异常编号
	 * @param cause   上层异常
	 */
	public DemoException(int httpStatus, String errCode, Throwable cause) {		
		this(500, errCode, null, null, null, null);
	}
	
	public int getHttpStatus() {
		return httpStatus;
	}


	public String getErrCode() {
		return errCode;
	}

	public Object[] getParams() {
		return params;
	}
	
	public String getMessage() {
		StringBuilder messageBuffer = new StringBuilder();
		if (errCode != null) {
			messageBuffer.append(ERROR_CODE).append(errCode).append("\n");
		}
		String resourceMessage = getMessageOnly();		
		if ((resourceMessage != null) && (resourceMessage.length() > 0)) {
			messageBuffer.append(ERROR_MESSAGE).append(resourceMessage);
		}
		
		return messageBuffer.toString();
	}

	/**
	 * 只取得异常信息，不带编号
	 * 
	 * @return 异常信息，不带编号
	 */
	public String getMessageOnly() {
		return ValidateUtil.format(message, params);
	}
	
	/**
	 * 取得额外信息
	 * 
	 * @return 额外信息
	 */
	public Object getAdditional() {
		return additional;
	}

	/**
	 * 构造方法不够齐全，这个方法还是有必要的，否则补全构造方法。<br>
	 * 
	 * @param additional The additional to set.
	 */
	public void setAdditional(Object additional) {
		this.additional = additional;
	}

}
