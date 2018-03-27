/*******************************************************************************
 *
 * ==============================================================================
 *
 * Copyright (c) 2101-2016 Primeton Technologies, Ltd. All rights reserved.
 * 
 * Created on 2016年11月22日 上午10:09:06
 *******************************************************************************/
package com.primeton.learns.springboot.mybatis.demo.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.primeton.learns.springboot.mybatis.demo.util.TraceLoggerFactory;

/**
 * web拦截器
 * 
 * @author wuyuhou
 *
 */
@Component
public class WebHandlerInterceptor implements HandlerInterceptor {

	private static Logger logger = TraceLoggerFactory.getLogger(WebHandlerInterceptor.class);

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// 验证 token
		String token = request.getHeader("Authorization");
		if (StringUtils.isNotBlank(token)) {
			
		}
		return true;
	}
	
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable ModelAndView modelAndView) throws Exception {
		
	}
	
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable Exception ex) throws Exception {
		
	}
}
