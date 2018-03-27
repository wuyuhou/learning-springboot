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

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.primeton.learns.springboot.mybatis.demo.model.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 用户Controller
 * 
 * @author wuyuhou
 *
 */
@RestController
@RequestMapping("/api/users")
@Api(tags={"用户API"})
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@ApiOperation(value = "查询所有用户", response = User[].class)
	@GetMapping
	public List<User> queryAllUsers() throws Exception {
		return userService.queryAllUsers();
	}
	
	@ApiOperation(value = "获取一个用户", response = User.class)
	@GetMapping("/{userId}")
	public User getUser(@ApiParam("用户ID") @PathVariable("userId") String userId) throws Exception {
		return userService.getUser(userId);
	}
	
	@ApiOperation(value = "创建一个用户", response = User.class)
	@PostMapping
	public User createUser(@ApiParam("用户") @RequestBody User user) throws Exception {
		return userService.createUser(user);
	}
	
	@ApiOperation(value = "修改一个用户", response = User.class)
	@PutMapping("/{userId}")
	public User modifyUser(@ApiParam("用户") @RequestBody User user) throws Exception {
		return userService.modifyUser(user);
	}
	
	@ApiOperation(value = "删除一个用户", response = User.class)
	@DeleteMapping("/{userId}")
	public User removeUser(@ApiParam("用户ID") @PathVariable("userId") String userId) throws Exception {
		return userService.removeUser(userId);
	}
}
