package com.yohomall.service.impl;

import com.yohomall.dao.UserMapper;
import com.yohomall.pojo.User;
import com.yohomall.service.UserService;
import com.yohomall.service.exception.InvalidNameException;
import com.yohomall.service.exception.InvalidPasswordException;
import com.yohomall.util.Util;

/**
 * 
 * @author YL
 *
 */
public class UserServiceImpl implements UserService {

	UserMapper userMapper;

	/*
	 * (non-Javadoc)
	 * @see com.yohomall.service.UserService#login(java.lang.String, java.lang.String)
	 */
	@Override
	public User login(String name, String password)
			throws InvalidNameException, InvalidPasswordException {

		User user = userMapper.findByName(name);

		if (user == null)
			throw new InvalidNameException();

		String md5 = Util.getMD5(password);
		if (!md5.equals(user.getPassword()))
			throw new InvalidPasswordException();

		return user;
	}

}
