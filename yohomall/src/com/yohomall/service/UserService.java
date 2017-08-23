package com.yohomall.service;

import com.yohomall.pojo.User;
import com.yohomall.service.exception.InvalidNameException;
import com.yohomall.service.exception.InvalidPasswordException;
import com.yohomall.service.exception.existException;

/**
 * 
 * @author YL
 *
 */
public interface UserService {

	/**
	 * 客户登录
	 * 
	 * @param name
	 *            用户名（手机号）
	 * @param password
	 *            密码
	 * @return
	 * @throws InvalidNameException
	 * @throws InvalidPasswordException
	 */
	User login(String email, String password);
	User checkEmail(String email)throws existException;
	int register(User u);
	int update(User u);
}
