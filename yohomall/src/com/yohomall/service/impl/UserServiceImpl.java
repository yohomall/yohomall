package com.yohomall.service.impl;

import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yohomall.dao.UserMapper;
import com.yohomall.pojo.User;
import com.yohomall.service.UserService;
import com.yohomall.service.exception.InvalidNameException;
import com.yohomall.service.exception.InvalidPasswordException;
import com.yohomall.service.exception.existException;
import com.yohomall.util.Util;

/**
 * 
 * @author YL
 *
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.yohomall.service.UserService#login(java.lang.String,
	 * java.lang.String)
	 */

	// 验证邮箱是否存在
	@Override
	public int checkEmail(String email) throws existException {
		
		return userMapper.findByEmail(email);
	}

	// 注册
	@Override
	public int register(User u) {
		return userMapper.add(u);
	}

	// 编辑个人资料
	@Override
	public int update(User u) {
		return userMapper.update(u);
		
	}

	@Override
	public User login(String email, String password) {
		
		return userMapper.find(email);
	}

}
