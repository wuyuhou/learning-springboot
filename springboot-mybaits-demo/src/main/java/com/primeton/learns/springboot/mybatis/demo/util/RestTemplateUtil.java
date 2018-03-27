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

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * RestTemplate工具类
 *
 * @author wuyuhou (mailto:wuyh@primeton.com)
 */

public class RestTemplateUtil {
	
	private static RestTemplate restTemplate = new RestTemplate();
	
	public static <T> T Get(String url, Map<String, String> headersMap, Class<T> responseType, Map<String, ?> uriVariables) {
		return Request(url, HttpMethod.GET, headersMap, null, responseType, uriVariables);
	}
	
	public static <T> T Post(String url, Map<String, String> headersMap, Object request, Class<T> responseType, Map<String, ?> uriVariables) {
		return Request(url, HttpMethod.POST, headersMap, request, responseType, uriVariables);
	}
	
	public static <T> T Put(String url, Map<String, String> headersMap, Object request, Class<T> responseType, Map<String, ?> uriVariables) {
		return Request(url, HttpMethod.PUT, headersMap, request, responseType, uriVariables);
	}
	
	public static void Delete(String url, Map<String, ?> uriVariables) {
		Delete(url, null, uriVariables);
	}
	
	public static void Delete(String url, Map<String, String> headersMap, Map<String, ?> uriVariables) {
		Request(url, HttpMethod.DELETE, headersMap, null, null, uriVariables);
	}
	
	public static <T> T Request(String url, HttpMethod method, Map<String, String> headersMap, Object request, Class<T> responseType, Map<String, ?> uriVariables) {
		HttpHeaders headers = null;
		if (headersMap != null && !headersMap.isEmpty()) {
			headers = new HttpHeaders();
			for (String key : headersMap.keySet()) {
				headers.set(key, headersMap.get(key));
			}
		}
		HttpEntity<?> requestEntity = new HttpEntity(request, headers);
		if (responseType == null) {
			restTemplate.exchange(url, method, requestEntity, responseType, uriVariables);
			return null;
		}
		ResponseEntity<T> responseEntity = restTemplate.exchange(url, method, requestEntity, responseType, uriVariables);
		return responseEntity.getBody();
	}
}
