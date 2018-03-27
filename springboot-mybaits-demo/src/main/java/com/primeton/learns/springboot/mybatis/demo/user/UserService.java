/*******************************************************************************
 *
 *==============================================================================
 *
 * Copyright (c) 2101-2016 Primeton Technologies, Ltd.
 * All rights reserved.
 * 
 * Created on 2016年11月22日 上午10:09:06
 *******************************************************************************/
package com.primeton.learns.springboot.mybatis.demo.user;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.primeton.learns.springboot.mybatis.demo.dao.UserDao;
import com.primeton.learns.springboot.mybatis.demo.exception.Demo;
import com.primeton.learns.springboot.mybatis.demo.exception.DemoException;
import com.primeton.learns.springboot.mybatis.demo.model.User;
import com.primeton.learns.springboot.mybatis.demo.util.IdGenerator;
import com.primeton.learns.springboot.mybatis.demo.util.TraceLoggerFactory;
import com.primeton.learns.springboot.mybatis.demo.util.ValidateUtil;

/**
 * 用户服务
 * 
 * @author wuyuhou
 *
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class UserService {
	
	private static Logger logger = TraceLoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private IdGenerator idGenerator;
	
	/**
	 * 查询所有用户
	 
	 * @return 用户列表
	 * @throws Exception
	 */
	public List<User> queryAllUsers() throws Exception {
		return userDao.queryAll();
	}
	
	/**
	 * 获取用户
	 * 
	 * @param userId 用户ID
	 * @return 用户
	 * @throws Exception
	 */
	public User getUser(String userId) throws Exception {
		ValidateUtil.assertNotNull(userId, "userId");
		return userDao.getById(userId);
	}
	
	/**
	 * 创建用户
	 * 
	 * @param user 用户
	 * @return 用户
	 * @throws Exception
	 */
	public User createUser(User user) throws Exception {
		ValidateUtil.assertNotNull(user, "user");
		ValidateUtil.assertNotNull(user.getUserName(), "userName");
		
		User oldUser = userDao.getByUserName(user.getUserName());
		if (oldUser != null) {
			throw new DemoException(
					Demo.User.USER_NAME_DUPLICAT.toString(),
					"User[name={0}] already existed!",
					new Object[] { user.getUserName() }, null,
					user.getUserName());
		}
		if (StringUtils.isBlank(user.getUserId())) {
			user.setUserId(idGenerator.getNextId(User.class));
		} else {
			if (userDao.getById(user.getUserId()) != null) {
				throw new DemoException(
						Demo.User.USER_ALRREADY_EXISTED.toString(),
						"User[id={0}] already existed!",
						new Object[] { user.getUserId() }, null,
						user.getUserId());
			}
		}
		user.setCreatedTime(new Date());
		userDao.insert(user);
		return user;
	}
	
	/**
	 * 修改用户
	 * 
	 * @param user 用户
	 * @return 用户
	 * @throws Exception
	 */
	public User modifyUser(User user) throws Exception {
		ValidateUtil.assertNotNull(user, "user");
		ValidateUtil.assertNotNull(user.getUserId(), "userId");
		ValidateUtil.assertNotNull(user.getUserName(), "userName");
		
		User oldUser = userDao.getByUserName(user.getUserName());
		if (oldUser != null && !oldUser.getUserId().equals(user.getUserId())) {
			throw new DemoException(
					Demo.User.USER_NAME_DUPLICAT.toString(),
					"User[name={0}] already existed!",
					new Object[] { user.getUserName() }, null,
					user.getUserName());	
		}
		
		//并发锁定
		oldUser = userDao.getLock(user.getUserId());
		if (oldUser == null) {
			throw new DemoException(
					Demo.User.USER_NOT_EXISTED.toString(),
					"User[userId={0}] not existed!",
					new Object[] { user.getUserId() }, null, user.getUserId());
		}
		user.setUpdatedTime(new Date());
		userDao.update(user);	
		return user;
	}
	
	/**
	 * 删除用户
	 * 
	 * @param userId 用户ID
	 * @return 用户
	 * @throws Exception
	 */
	public User removeUser(String userId) throws Exception {
		ValidateUtil.assertNotNull(userId, "userId");
		
		//并发锁定
		User user = userDao.getLock(userId);
		if (user == null) {
			return null;
		}
		
		userDao.delete(userId);
		
		return user;
	}
}
