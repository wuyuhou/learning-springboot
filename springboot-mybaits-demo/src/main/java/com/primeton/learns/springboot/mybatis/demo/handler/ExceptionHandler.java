/*******************************************************************************
 *
 *==============================================================================
 *
 * Copyright (c) 2101-2016 Primeton Technologies, Ltd.
 * All rights reserved.
 * 
 * Created on 2016年11月22日 上午10:09:06
 *******************************************************************************/
package com.primeton.learns.springboot.mybatis.demo.handler;

import java.io.PrintWriter;
import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.primeton.learns.springboot.mybatis.demo.exception.Demo;
import com.primeton.learns.springboot.mybatis.demo.exception.DemoException;
import com.primeton.learns.springboot.mybatis.demo.util.TraceLoggerFactory;

/**
 * 异常拦截器
 * 
 * @author wuyuhou
 *
 */
@Component("exceptionHandler")
@Order(-1000)
public class ExceptionHandler implements HandlerExceptionResolver {
	private static Logger logger = TraceLoggerFactory.getLogger(ExceptionHandler.class);
	private ObjectMapper objectMapper = new ObjectMapper();

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		
		logger.error(request.getMethod() + " : " + request.getRequestURL().toString(), ex);

		int httpStatus = 500;
		String errCode = null;
		String message = null;
		Object[] params = null;
		Object additional = null;
		if (ex instanceof DemoException) {
			DemoException exception = (DemoException) ex;
			message = exception.getMessageOnly();
			errCode = exception.getErrCode();
			params = exception.getParams();
			additional = exception.getAdditional();
			httpStatus = exception.getHttpStatus();
		} else {
			logger.error("Not DemoException, msg = " + ex.getMessage());
			errCode = Demo.Common.SYSTEM_ERROR.toString();
			message = "Uncaught exception: " + ex.getMessage();
		}
		
		response.setStatus(httpStatus);
		response.setContentType(MediaType.APPLICATION_JSON_VALUE); //设置ContentType
        response.setCharacterEncoding("UTF-8"); //避免乱码
        response.setHeader("Cache-Control", "no-cache, must-revalidate");

        try {
            String json = objectMapper.writeValueAsString(new ErrorWrapper(httpStatus, errCode, message, params, additional, null));
            PrintWriter writer = response.getWriter();
            writer.write(json);
            writer.flush();
            writer.close();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

		return new ModelAndView();
	}
	
	public static class ErrorWrapper implements Serializable {
		
		private static final long serialVersionUID = 769681970183943584L;
		private int httpStatus = 500;
		private String code;
		private String message;
		private Object[] params;
		private Object additional;
		private String stackDetails;

		/**
		 * 无参构造方法
		 */
		public ErrorWrapper() {
		}

		/**
		 * 带参构造方法
		 * @param code
		 * @param message
		 * @param params
		 */
		public ErrorWrapper(int httpStatus, String code, String message, Object[] params, Object additional, String stackDetails) {
			this.httpStatus = httpStatus;
			this.code = code;
			this.message = message;
			this.params = params;
			this.additional = additional;
			this.stackDetails = stackDetails;
		}

		public int getHttpStatus() {
			return httpStatus;
		}

		public void setHttpStatus(int httpStatus) {
			this.httpStatus = httpStatus;
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public Object[] getParams() {
			return params;
		}

		public void setParams(Object[] params) {
			this.params = params;
		}

		public Object getAdditional() {
			return additional;
		}

		public void setAdditional(Object additional) {
			this.additional = additional;
		}

		public String getStackDetails() {
			return stackDetails;
		}

		public void setStackDetails(String stackDetails) {
			this.stackDetails = stackDetails;
		}
	}
}
